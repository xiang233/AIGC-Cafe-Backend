package com.aigccafe.buterin.service.impl;

import com.aigccafe.buterin.common.enumerate.ClientType;
import com.aigccafe.buterin.common.enumerate.HttpMethod;
import com.aigccafe.buterin.common.enumerate.ImageType;
import com.aigccafe.buterin.common.model.http.HttpRequestConfig;
import com.aigccafe.buterin.common.model.resp.UploadImageRespVO;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.common.util.RandomUtil;
import com.aigccafe.buterin.common.util.SecUtil;
import com.aigccafe.buterin.repository.OOSRepository;
import com.aigccafe.buterin.service.HttpService;
import com.aigccafe.buterin.service.ImageService;
import com.alibaba.fastjson.JSON;
import com.aliyun.oss.model.CannedAccessControlList;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.aigccafe.buterin.common.Constant.VERSION_IMAGE_DIR;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    @Autowired
    private OOSRepository oosRepository;
    @Autowired
    private HttpService httpService;

    @Override
    public UploadImageRespVO uploadAvatar(MultipartFile file) {
        return uploadImage(ImageType.AVATAR, file, CannedAccessControlList.PublicRead, true);
    }

    @Override
    public UploadImageRespVO uploadArticleImage(MultipartFile file) {
        return uploadImage(ImageType.ARTICLE, file, CannedAccessControlList.PublicRead, false);
    }

    @Override
    public List<UploadImageRespVO> uploadArticleImageList(MultipartFile[] files) {
        log.info("文件个数：{}", files.length);
        List<UploadImageRespVO> uploadImageRespVOList = Lists.newArrayList();
        for (MultipartFile file : files) {
            UploadImageRespVO respVO = uploadArticleImage(file);
            log.info("上传成功：{}", JSON.toJSONString(respVO));
            uploadImageRespVOList.add(respVO);
        }
        return uploadImageRespVOList;
    }

    @Override
    public UploadImageRespVO uploadImage(ImageType imageType, MultipartFile file, CannedAccessControlList acl, Boolean resize) {
        String date = DateTimeUtils.formatConsecutiveDate(DateTimeUtils.nowSeconds() * 1000);
        String random = RandomUtil.generateRandomEnglishString(8);
        Long milSecond = DateTimeUtils.nowMilliSeconds() % 100000;

        String originalFilename = file.getOriginalFilename();
        String suffixName = ".jpeg";
        if (!Strings.isNullOrEmpty(originalFilename)) {
            suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            if (Strings.isNullOrEmpty(suffixName)) {
                suffixName = ".jpeg";
            }
        }

        String fileName = String.format("%s_%s%s", random, milSecond, suffixName);
        String imagePath = String.format("%s/%s/%s", imageType.getDir(), date, fileName);
        try {
            oosRepository.uploadImage(imagePath, file.getBytes(), acl);
            if (resize) {
                oosRepository.resizeImageInOOS(imagePath, imagePath, imageType.getResizeCmd());
                if (acl.equals(CannedAccessControlList.PublicRead) || acl.equals(CannedAccessControlList.PublicReadWrite)) {
                    oosRepository.setFileACL(imagePath, CannedAccessControlList.PublicRead);
                }
            }
            String url = oosRepository.getPublicUrl(imagePath);
            if (acl.equals(CannedAccessControlList.Default) || acl.equals(CannedAccessControlList.Private)) {
                url = oosRepository.getSafeUrl(imagePath);
            }
            return UploadImageRespVO.builder()
                    .path(imagePath)
                    .url(url)
                    .build();
        } catch (Exception exp) {
            log.info("上传图片失败：" + exp.getMessage());
            throw new RuntimeException("上传图片失败：" + exp.getMessage());
        }
    }

    @Override
    public String storeImageOnOOS(String imageUrl, ClientType type) {
        // 下载图片并转储到oss
        Long begin = DateTimeUtils.nowSeconds();
        HttpRequestConfig requestConfig = HttpRequestConfig.builder()
                .httpMethod(HttpMethod.GET)
                .clientType(type)
                .url(imageUrl)
                .retry(3)
                .build();
        log.info("请求图片地址：{}", imageUrl);
        String newName = SecUtil.md5(imageUrl);
        String format = getImageFormat(imageUrl);
        String date = DateTimeUtils.formatConsecutiveDate(DateTimeUtils.nowSeconds() * 1000);
        String fileName = String.format("%s.%s", newName, format);
        String imagePath = String.format("%s/%s/%s", ImageType.OUTER_ARTICLE.getDir(), date, fileName);
        byte[] imageBytes;
        try {
            imageBytes = httpService.requestBytes(requestConfig);
        } catch (IOException e) {
            e.printStackTrace();
            log.info("请求图片失败，忽略");
            return null;
        }
        Long end = DateTimeUtils.nowSeconds();
        log.info("请求图片耗时：{}", end - begin);
        begin = DateTimeUtils.nowSeconds();
        oosRepository.uploadImage(imagePath, imageBytes, CannedAccessControlList.PublicRead);
        end = DateTimeUtils.nowSeconds();
        log.info("上传oos耗时：{}", end - begin);
        return oosRepository.getPublicUrl(imagePath);
    }

    private String getImageFormat(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            URLConnection connection = url.openConnection();
            String contentType = connection.getContentType();
            if (contentType != null && contentType.startsWith("image/")) {
                return contentType.substring("image/".length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "jpeg";
    }
}
