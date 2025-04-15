package com.aigccafe.buterin.common.model.cvt;

import java.io.Serializable;

public class CvtModelDetectPO implements Serializable {
    private Long id;

    private Long modelId;

    private String modelName;

    private String modelType;

    private String checkpointType;

    private String requestInfo;

    private String rankInfo;

    private String coverImageData;

    private String lastVersionAt;

    private Boolean detailUpdate;

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

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType == null ? null : modelType.trim();
    }

    public String getCheckpointType() {
        return checkpointType;
    }

    public void setCheckpointType(String checkpointType) {
        this.checkpointType = checkpointType == null ? null : checkpointType.trim();
    }

    public String getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(String requestInfo) {
        this.requestInfo = requestInfo == null ? null : requestInfo.trim();
    }

    public String getRankInfo() {
        return rankInfo;
    }

    public void setRankInfo(String rankInfo) {
        this.rankInfo = rankInfo == null ? null : rankInfo.trim();
    }

    public String getCoverImageData() {
        return coverImageData;
    }

    public void setCoverImageData(String coverImageData) {
        this.coverImageData = coverImageData == null ? null : coverImageData.trim();
    }

    public String getLastVersionAt() {
        return lastVersionAt;
    }

    public void setLastVersionAt(String lastVersionAt) {
        this.lastVersionAt = lastVersionAt == null ? null : lastVersionAt.trim();
    }

    public Boolean getDetailUpdate() {
        return detailUpdate;
    }

    public void setDetailUpdate(Boolean detailUpdate) {
        this.detailUpdate = detailUpdate;
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
        CvtModelDetectPO other = (CvtModelDetectPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getModelType() == null ? other.getModelType() == null : this.getModelType().equals(other.getModelType()))
            && (this.getCheckpointType() == null ? other.getCheckpointType() == null : this.getCheckpointType().equals(other.getCheckpointType()))
            && (this.getRequestInfo() == null ? other.getRequestInfo() == null : this.getRequestInfo().equals(other.getRequestInfo()))
            && (this.getRankInfo() == null ? other.getRankInfo() == null : this.getRankInfo().equals(other.getRankInfo()))
            && (this.getCoverImageData() == null ? other.getCoverImageData() == null : this.getCoverImageData().equals(other.getCoverImageData()))
            && (this.getLastVersionAt() == null ? other.getLastVersionAt() == null : this.getLastVersionAt().equals(other.getLastVersionAt()))
            && (this.getDetailUpdate() == null ? other.getDetailUpdate() == null : this.getDetailUpdate().equals(other.getDetailUpdate()))
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
        result = prime * result + ((getModelType() == null) ? 0 : getModelType().hashCode());
        result = prime * result + ((getCheckpointType() == null) ? 0 : getCheckpointType().hashCode());
        result = prime * result + ((getRequestInfo() == null) ? 0 : getRequestInfo().hashCode());
        result = prime * result + ((getRankInfo() == null) ? 0 : getRankInfo().hashCode());
        result = prime * result + ((getCoverImageData() == null) ? 0 : getCoverImageData().hashCode());
        result = prime * result + ((getLastVersionAt() == null) ? 0 : getLastVersionAt().hashCode());
        result = prime * result + ((getDetailUpdate() == null) ? 0 : getDetailUpdate().hashCode());
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
        sb.append(", modelType=").append(modelType);
        sb.append(", checkpointType=").append(checkpointType);
        sb.append(", requestInfo=").append(requestInfo);
        sb.append(", rankInfo=").append(rankInfo);
        sb.append(", coverImageData=").append(coverImageData);
        sb.append(", lastVersionAt=").append(lastVersionAt);
        sb.append(", detailUpdate=").append(detailUpdate);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}