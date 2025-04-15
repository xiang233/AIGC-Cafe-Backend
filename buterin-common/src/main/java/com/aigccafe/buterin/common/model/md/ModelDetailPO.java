package com.aigccafe.buterin.common.model.md;

import java.io.Serializable;

public class ModelDetailPO implements Serializable {
    private Long id;

    private String platform;

    private Long oriModelId;

    private String modelName;

    private String chnModelName;

    private String description;

    private String chnDescription;

    private Boolean nsfw;

    private String status;

    private String authorName;

    private Long downloadCnt;

    private String baseModel;

    private String type;

    private String checkpointType;

    private String tags;

    private Long userId;

    private String manualTags;

    private String coverPath;

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

    public Long getOriModelId() {
        return oriModelId;
    }

    public void setOriModelId(Long oriModelId) {
        this.oriModelId = oriModelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getChnModelName() {
        return chnModelName;
    }

    public void setChnModelName(String chnModelName) {
        this.chnModelName = chnModelName == null ? null : chnModelName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getChnDescription() {
        return chnDescription;
    }

    public void setChnDescription(String chnDescription) {
        this.chnDescription = chnDescription == null ? null : chnDescription.trim();
    }

    public Boolean getNsfw() {
        return nsfw;
    }

    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public Long getDownloadCnt() {
        return downloadCnt;
    }

    public void setDownloadCnt(Long downloadCnt) {
        this.downloadCnt = downloadCnt;
    }

    public String getBaseModel() {
        return baseModel;
    }

    public void setBaseModel(String baseModel) {
        this.baseModel = baseModel == null ? null : baseModel.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCheckpointType() {
        return checkpointType;
    }

    public void setCheckpointType(String checkpointType) {
        this.checkpointType = checkpointType == null ? null : checkpointType.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getManualTags() {
        return manualTags;
    }

    public void setManualTags(String manualTags) {
        this.manualTags = manualTags == null ? null : manualTags.trim();
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath == null ? null : coverPath.trim();
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
        ModelDetailPO other = (ModelDetailPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getOriModelId() == null ? other.getOriModelId() == null : this.getOriModelId().equals(other.getOriModelId()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getChnModelName() == null ? other.getChnModelName() == null : this.getChnModelName().equals(other.getChnModelName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getChnDescription() == null ? other.getChnDescription() == null : this.getChnDescription().equals(other.getChnDescription()))
            && (this.getNsfw() == null ? other.getNsfw() == null : this.getNsfw().equals(other.getNsfw()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAuthorName() == null ? other.getAuthorName() == null : this.getAuthorName().equals(other.getAuthorName()))
            && (this.getDownloadCnt() == null ? other.getDownloadCnt() == null : this.getDownloadCnt().equals(other.getDownloadCnt()))
            && (this.getBaseModel() == null ? other.getBaseModel() == null : this.getBaseModel().equals(other.getBaseModel()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCheckpointType() == null ? other.getCheckpointType() == null : this.getCheckpointType().equals(other.getCheckpointType()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getManualTags() == null ? other.getManualTags() == null : this.getManualTags().equals(other.getManualTags()))
            && (this.getCoverPath() == null ? other.getCoverPath() == null : this.getCoverPath().equals(other.getCoverPath()))
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
        result = prime * result + ((getOriModelId() == null) ? 0 : getOriModelId().hashCode());
        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
        result = prime * result + ((getChnModelName() == null) ? 0 : getChnModelName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getChnDescription() == null) ? 0 : getChnDescription().hashCode());
        result = prime * result + ((getNsfw() == null) ? 0 : getNsfw().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAuthorName() == null) ? 0 : getAuthorName().hashCode());
        result = prime * result + ((getDownloadCnt() == null) ? 0 : getDownloadCnt().hashCode());
        result = prime * result + ((getBaseModel() == null) ? 0 : getBaseModel().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCheckpointType() == null) ? 0 : getCheckpointType().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getManualTags() == null) ? 0 : getManualTags().hashCode());
        result = prime * result + ((getCoverPath() == null) ? 0 : getCoverPath().hashCode());
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
        sb.append(", oriModelId=").append(oriModelId);
        sb.append(", modelName=").append(modelName);
        sb.append(", chnModelName=").append(chnModelName);
        sb.append(", description=").append(description);
        sb.append(", chnDescription=").append(chnDescription);
        sb.append(", nsfw=").append(nsfw);
        sb.append(", status=").append(status);
        sb.append(", authorName=").append(authorName);
        sb.append(", downloadCnt=").append(downloadCnt);
        sb.append(", baseModel=").append(baseModel);
        sb.append(", type=").append(type);
        sb.append(", checkpointType=").append(checkpointType);
        sb.append(", tags=").append(tags);
        sb.append(", userId=").append(userId);
        sb.append(", manualTags=").append(manualTags);
        sb.append(", coverPath=").append(coverPath);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}