package com.aigccafe.buterin.service;

import com.aigccafe.buterin.common.enumerate.ClientType;
import com.aigccafe.buterin.common.enumerate.ImageType;
import com.aigccafe.buterin.common.model.resp.UploadImageRespVO;
import com.aliyun.oss.model.CannedAccessControlList;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    UploadImageRespVO uploadImage(ImageType imageType, MultipartFile file, CannedAccessControlList acl, Boolean resize);

    UploadImageRespVO uploadAvatar(MultipartFile file);

    UploadImageRespVO uploadArticleImage(MultipartFile file);

    List<UploadImageRespVO> uploadArticleImageList(MultipartFile[] files);

    String storeImageOnOOS(String imageUrl, ClientType type);
}
