package com.aigccafe.buterin.common.model.md;

import java.io.Serializable;

public class ModelVersionImagePOWithBLOBs extends ModelVersionImagePO implements Serializable {
    private String meta;

    private String authorInfo;

    private static final long serialVersionUID = 1L;

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta == null ? null : meta.trim();
    }

    public String getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(String authorInfo) {
        this.authorInfo = authorInfo == null ? null : authorInfo.trim();
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
        ModelVersionImagePOWithBLOBs other = (ModelVersionImagePOWithBLOBs) that;
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
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getMeta() == null ? other.getMeta() == null : this.getMeta().equals(other.getMeta()))
            && (this.getAuthorInfo() == null ? other.getAuthorInfo() == null : this.getAuthorInfo().equals(other.getAuthorInfo()));
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
        result = prime * result + ((getMeta() == null) ? 0 : getMeta().hashCode());
        result = prime * result + ((getAuthorInfo() == null) ? 0 : getAuthorInfo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", meta=").append(meta);
        sb.append(", authorInfo=").append(authorInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}