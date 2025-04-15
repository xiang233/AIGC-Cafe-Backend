package com.aigccafe.buterin.repository.impl;

import com.aigccafe.buterin.repository.OOSRepository;
import com.aliyun.oss.*;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.common.utils.IOUtils;
import com.aliyun.oss.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

import static com.aigccafe.buterin.common.Constant.*;

@Slf4j
@Repository
public class OOSRepositoryImpl implements OOSRepository {
    @Value("${spring.profiles.active}")
    private String env;

    private String currentEndpoint = INTERNAL_ENDPOINT;

    @Value("${aliyun.access-key-id}")
    private String accessKeyId;

    @Value("${aliyun.access-key-secret}")
    private String accessKeySecret;


    @Override
    public String uploadImage(String path, byte[] imgBytes, CannedAccessControlList acl) {
        setEndpoint();
        OSS ossClient = new OSSClientBuilder().build(currentEndpoint, accessKeyId, accessKeySecret);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setObjectAcl(acl);

        try {
            ossClient.putObject(IMAGE_BUCKET_NAME, path, new ByteArrayInputStream(imgBytes), metadata);
        } catch (OSSException oe) {
            log.info("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            log.info("Error Message:" + oe.getErrorMessage());
            log.info("Error Code:" + oe.getErrorCode());
            log.info("Request ID:" + oe.getRequestId());
            log.info("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            log.info("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            log.info("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return "https://aigccafe." + INTERNAL_ENDPOINT + "/" + path;
    }

    @Override
    public String resizeImageInOOS(String sourceImage, String targetImage, String styleType) {
        setEndpoint();
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(currentEndpoint, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        String result = "";
        try {
            StringBuilder sbStyle = new StringBuilder();
            Formatter styleFormatter = new Formatter(sbStyle);
            styleFormatter.format("%s|sys/saveas,o_%s,b_%s", styleType,
                    BinaryUtil.toBase64String(targetImage.getBytes()),
                    BinaryUtil.toBase64String(IMAGE_BUCKET_NAME.getBytes()));
            //log.info(sbStyle.toString());
            ProcessObjectRequest request = new ProcessObjectRequest(IMAGE_BUCKET_NAME, sourceImage, sbStyle.toString());
            GenericResult processResult = ossClient.processObject(request);
            result = IOUtils.readStreamAsString(processResult.getResponse().getContent(), "UTF-8");
            processResult.getResponse().getContent().close();
        } catch (OSSException oe) {
            log.info("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            log.info("Error Message:" + oe.getErrorMessage());
            log.info("Error Code:" + oe.getErrorCode());
            log.info("Request ID:" + oe.getRequestId());
            log.info("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            log.info("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            log.info("Error Message:" + ce.getMessage());
        } catch (IOException ioException) {
            log.info("IOException:" + ioException.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return result;
    }

    @Override
    public void setFileACL(String imagePath, CannedAccessControlList acl) {
        setEndpoint();
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(currentEndpoint, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        try {
            // 创建SetObjectAclRequest对象，此示例中设置文件的访问权限为公共读。
            SetObjectAclRequest setObjectAclRequest = new SetObjectAclRequest(IMAGE_BUCKET_NAME, imagePath, acl);
            // 设置指定文件的权限。
            ossClient.setObjectAcl(setObjectAclRequest);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }


    @Override
    public String getPublicUrl(String imagePath) {
        return "https://aigccafe." + ETERNAL_ENDPOINT + "/" + imagePath;
    }

    @Override
    public String getSafeUrl(String imagePath) {
        setEndpoint();
        String saveUrl = imagePath;
        OSS ossClient = new OSSClientBuilder().build(currentEndpoint, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        try {
            // 指定生成的签名URL过期时间，单位为毫秒。
            Date expiration = new Date(new Date().getTime() + 1800 * 1000);
            // 生成签名URL。
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(IMAGE_BUCKET_NAME, imagePath, HttpMethod.GET);
            // 设置过期时间。
            request.setExpiration(expiration);
            Map<String, String> headers = new HashMap<String, String>();
            // 如果您希望实现浏览器访问时自动下载文件，并自定义下载后的文件名称，配置文件HTTP头中的Content-Disposition为attachment。
            //headers.put("content-disposition","attachment");
            // 如果您希望直接在浏览器中预览文件，配置文件HTTP头中的Content-Disposition为inline并使用Bucket绑定的自定义域名进行访问。
            headers.put("content-disposition","inline");
            request.setHeaders(headers);
            // 通过HTTP GET请求生成签名URL。
            URL signedUrl = ossClient.generatePresignedUrl(request);
//            log.info("signed url for getObject: " + signedUrl);
//            return signedUrl.toString();
            saveUrl = CDN_HOST + signedUrl.getPath() + "?" + signedUrl.getQuery();
        } catch (OSSException oe) {
            log.info("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            log.info("Error Message:" + oe.getErrorMessage());
            log.info("Error Code:" + oe.getErrorCode());
            log.info("Request ID:" + oe.getRequestId());
            log.info("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            log.info("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            log.info("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return saveUrl;
    }

    private void setEndpoint() {
        if ("prod".equals(env)) {
            this.currentEndpoint = INTERNAL_ENDPOINT;
        } else {
            this.currentEndpoint = ETERNAL_ENDPOINT;
        }
    }
}
