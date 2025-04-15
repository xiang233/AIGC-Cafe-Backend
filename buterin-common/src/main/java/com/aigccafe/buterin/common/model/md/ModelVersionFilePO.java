package com.aigccafe.buterin.common.model.md;

import java.io.Serializable;

public class ModelVersionFilePO implements Serializable {
    private Long id;

    private String platform;

    private Long modelId;

    private String modelName;

    private Long versionId;

    private String versionName;

    private Long oriModelId;

    private Long oriVersionId;

    private Long oriFileId;

    private Double sizekb;

    private String type;

    private String name;

    private String metadata;

    private String url;

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

    public Long getOriFileId() {
        return oriFileId;
    }

    public void setOriFileId(Long oriFileId) {
        this.oriFileId = oriFileId;
    }

    public Double getSizekb() {
        return sizekb;
    }

    public void setSizekb(Double sizekb) {
        this.sizekb = sizekb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata == null ? null : metadata.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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
        ModelVersionFilePO other = (ModelVersionFilePO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getVersionId() == null ? other.getVersionId() == null : this.getVersionId().equals(other.getVersionId()))
            && (this.getVersionName() == null ? other.getVersionName() == null : this.getVersionName().equals(other.getVersionName()))
            && (this.getOriModelId() == null ? other.getOriModelId() == null : this.getOriModelId().equals(other.getOriModelId()))
            && (this.getOriVersionId() == null ? other.getOriVersionId() == null : this.getOriVersionId().equals(other.getOriVersionId()))
            && (this.getOriFileId() == null ? other.getOriFileId() == null : this.getOriFileId().equals(other.getOriFileId()))
            && (this.getSizekb() == null ? other.getSizekb() == null : this.getSizekb().equals(other.getSizekb()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMetadata() == null ? other.getMetadata() == null : this.getMetadata().equals(other.getMetadata()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
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
        result = prime * result + ((getOriFileId() == null) ? 0 : getOriFileId().hashCode());
        result = prime * result + ((getSizekb() == null) ? 0 : getSizekb().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMetadata() == null) ? 0 : getMetadata().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
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
        sb.append(", oriFileId=").append(oriFileId);
        sb.append(", sizekb=").append(sizekb);
        sb.append(", type=").append(type);
        sb.append(", name=").append(name);
        sb.append(", metadata=").append(metadata);
        sb.append(", url=").append(url);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}