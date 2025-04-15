package com.aigccafe.buterin.common.model.cvt;

import java.io.Serializable;

public class CvtModelDetailPO implements Serializable {
    private Long id;

    private Long modelId;

    private String modelName;

    private Boolean nsfw;

    private String type;

    private String checkpointtype;

    private String userInfo;

    private String lastUpdatedAt;

    private Boolean versionImageUpdate;

    private Boolean postImageUpdate;

    private Boolean merged;

    private Boolean needCheckUpdate;

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

    public Boolean getNsfw() {
        return nsfw;
    }

    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCheckpointtype() {
        return checkpointtype;
    }

    public void setCheckpointtype(String checkpointtype) {
        this.checkpointtype = checkpointtype == null ? null : checkpointtype.trim();
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo == null ? null : userInfo.trim();
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt == null ? null : lastUpdatedAt.trim();
    }

    public Boolean getVersionImageUpdate() {
        return versionImageUpdate;
    }

    public void setVersionImageUpdate(Boolean versionImageUpdate) {
        this.versionImageUpdate = versionImageUpdate;
    }

    public Boolean getPostImageUpdate() {
        return postImageUpdate;
    }

    public void setPostImageUpdate(Boolean postImageUpdate) {
        this.postImageUpdate = postImageUpdate;
    }

    public Boolean getMerged() {
        return merged;
    }

    public void setMerged(Boolean merged) {
        this.merged = merged;
    }

    public Boolean getNeedCheckUpdate() {
        return needCheckUpdate;
    }

    public void setNeedCheckUpdate(Boolean needCheckUpdate) {
        this.needCheckUpdate = needCheckUpdate;
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
        CvtModelDetailPO other = (CvtModelDetailPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getNsfw() == null ? other.getNsfw() == null : this.getNsfw().equals(other.getNsfw()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCheckpointtype() == null ? other.getCheckpointtype() == null : this.getCheckpointtype().equals(other.getCheckpointtype()))
            && (this.getUserInfo() == null ? other.getUserInfo() == null : this.getUserInfo().equals(other.getUserInfo()))
            && (this.getLastUpdatedAt() == null ? other.getLastUpdatedAt() == null : this.getLastUpdatedAt().equals(other.getLastUpdatedAt()))
            && (this.getVersionImageUpdate() == null ? other.getVersionImageUpdate() == null : this.getVersionImageUpdate().equals(other.getVersionImageUpdate()))
            && (this.getPostImageUpdate() == null ? other.getPostImageUpdate() == null : this.getPostImageUpdate().equals(other.getPostImageUpdate()))
            && (this.getMerged() == null ? other.getMerged() == null : this.getMerged().equals(other.getMerged()))
            && (this.getNeedCheckUpdate() == null ? other.getNeedCheckUpdate() == null : this.getNeedCheckUpdate().equals(other.getNeedCheckUpdate()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
        result = prime * result + ((getNsfw() == null) ? 0 : getNsfw().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCheckpointtype() == null) ? 0 : getCheckpointtype().hashCode());
        result = prime * result + ((getUserInfo() == null) ? 0 : getUserInfo().hashCode());
        result = prime * result + ((getLastUpdatedAt() == null) ? 0 : getLastUpdatedAt().hashCode());
        result = prime * result + ((getVersionImageUpdate() == null) ? 0 : getVersionImageUpdate().hashCode());
        result = prime * result + ((getPostImageUpdate() == null) ? 0 : getPostImageUpdate().hashCode());
        result = prime * result + ((getMerged() == null) ? 0 : getMerged().hashCode());
        result = prime * result + ((getNeedCheckUpdate() == null) ? 0 : getNeedCheckUpdate().hashCode());
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
        sb.append(", modelId=").append(modelId);
        sb.append(", modelName=").append(modelName);
        sb.append(", nsfw=").append(nsfw);
        sb.append(", type=").append(type);
        sb.append(", checkpointtype=").append(checkpointtype);
        sb.append(", userInfo=").append(userInfo);
        sb.append(", lastUpdatedAt=").append(lastUpdatedAt);
        sb.append(", versionImageUpdate=").append(versionImageUpdate);
        sb.append(", postImageUpdate=").append(postImageUpdate);
        sb.append(", merged=").append(merged);
        sb.append(", needCheckUpdate=").append(needCheckUpdate);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}