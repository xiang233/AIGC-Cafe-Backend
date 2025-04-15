package com.aigccafe.buterin.repository;

import com.aliyun.oss.model.CannedAccessControlList;

public interface OOSRepository {
    String uploadImage(String localPath, byte[] imgBytes, CannedAccessControlList acl);

    String resizeImageInOOS(String sourceImage, String targetImage, String styleType);

    void setFileACL(String imagePath, CannedAccessControlList acl);

    String getSafeUrl(String imagePath);

    String getPublicUrl(String imagePath);
}
