package com.aigccafe.buterin.common.model.md;

import java.io.Serializable;

public class ModelVersionImagePO implements Serializable {
    private Long id;

    private String platform;

    private Long modelId;

    private String modelName;

    private Long versionId;

    private String versionName;

    private Long oriModelId;

    private Long oriVersionId;

    private Long oriImageId;

    private String url;

    private Boolean nsfw;

    private Integer width;

    private Integer height;

    private String mimetype;

    private String rawPath;

    private String normalPath;

    private Long createdAt;

    private Long updatedAt;

    private Boolean isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName == null ? null : versionName.trim();
    }

    public Long getOriModelId() {
        return oriModelId;
    }

    public void setOriModelId(Long oriModelId) {
        this.oriModelId = oriModelId;
    }

    public Long getOriVersionId() {
        return oriVersionId;
    }

    public void setOriVersionId(Long oriVersionId) {
        this.oriVersionId = oriVersionId;
    }

    public Long getOriImageId() {
        return oriImageId;
    }

    public void setOriImageId(Long oriImageId) {
        this.oriImageId = oriImageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Boolean getNsfw() {
        return nsfw;
    }

    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype == null ? null : mimetype.trim();
    }

    public String getRawPath() {
        return rawPath;
    }

    public void setRawPath(String rawPath) {
        this.rawPath = rawPath == null ? null : rawPath.trim();
    }

    public String getNormalPath() {
        return normalPath;
    }

    public void setNormalPath(String normalPath) {
        this.normalPath = normalPath == null ? null : normalPath.trim();
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ModelVersionImagePO other = (ModelVersionImagePO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getVersionId() == null ? other.getVersionId() == null : this.getVersionId().equals(other.getVersionId()))
            && (this.getVersionName() == null ? other.getVersionName() == null : this.getVersionName().equals(other.getVersionName()))
            && (this.getOriModelId() == null ? other.getOriModelId() == null : this.getOriModelId().equals(other.getOriModelId()))
            && (this.getOriVersionId() == null ? other.getOriVersionId() == null : this.getOriVersionId().equals(other.getOriVersionId()))
            && (this.getOriImageId() == null ? other.getOriImageId() == null : this.getOriImageId().equals(other.getOriImageId()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getNsfw() == null ? other.getNsfw() == null : this.getNsfw().equals(other.getNsfw()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getMimetype() == null ? other.getMimetype() == null : this.getMimetype().equals(other.getMimetype()))
            && (this.getRawPath() == null ? other.getRawPath() == null : this.getRawPath().equals(other.getRawPath()))
            && (this.getNormalPath() == null ? other.getNormalPath() == null : this.getNormalPath().equals(other.getNormalPath()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
        result = prime * result + ((getVersionId() == null) ? 0 : getVersionId().hashCode());
        result = prime * result + ((getVersionName() == null) ? 0 : getVersionName().hashCode());
        result = prime * result + ((getOriModelId() == null) ? 0 : getOriModelId().hashCode());
        result = prime * result + ((getOriVersionId() == null) ? 0 : getOriVersionId().hashCode());
        result = prime * result + ((getOriImageId() == null) ? 0 : getOriImageId().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getNsfw() == null) ? 0 : getNsfw().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getMimetype() == null) ? 0 : getMimetype().hashCode());
        result = prime * result + ((getRawPath() == null) ? 0 : getRawPath().hashCode());
        result = prime * result + ((getNormalPath() == null) ? 0 : getNormalPath().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", platform=").append(platform);
        sb.append(", modelId=").append(modelId);
        sb.append(", modelName=").append(modelName);
        sb.append(", versionId=").append(versionId);
        sb.append(", versionName=").append(versionName);
        sb.append(", oriModelId=").append(oriModelId);
        sb.append(", oriVersionId=").append(oriVersionId);
        sb.append(", oriImageId=").append(oriImageId);
        sb.append(", url=").append(url);
        sb.append(", nsfw=").append(nsfw);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", mimetype=").append(mimetype);
        sb.append(", rawPath=").append(rawPath);
        sb.append(", normalPath=").append(normalPath);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}