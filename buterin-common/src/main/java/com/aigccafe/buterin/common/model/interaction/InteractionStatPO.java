package com.aigccafe.buterin.common.model.interaction;

import java.io.Serializable;

public class InteractionStatPO implements Serializable {
    private Long id;

    private String targetType;

    private Long targetId;

    private Long likeCount;

    private Long storeCount;

    private Long commentCount;

    private Long downloadCount;

    private Long scoreCount;

    private Double scoreSum;

    private Long agreeCount;

    private Long disagreeCount;

    private Long supportCount;

    private Long unSupportCount;

    private Long viewCount;

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

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType == null ? null : targetType.trim();
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getStoreCount() {
        return storeCount;
    }

    public void setStoreCount(Long storeCount) {
        this.storeCount = storeCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Long getScoreCount() {
        return scoreCount;
    }

    public void setScoreCount(Long scoreCount) {
        this.scoreCount = scoreCount;
    }

    public Double getScoreSum() {
        return scoreSum;
    }

    public void setScoreSum(Double scoreSum) {
        this.scoreSum = scoreSum;
    }

    public Long getAgreeCount() {
        return agreeCount;
    }

    public void setAgreeCount(Long agreeCount) {
        this.agreeCount = agreeCount;
    }

    public Long getDisagreeCount() {
        return disagreeCount;
    }

    public void setDisagreeCount(Long disagreeCount) {
        this.disagreeCount = disagreeCount;
    }

    public Long getSupportCount() {
        return supportCount;
    }

    public void setSupportCount(Long supportCount) {
        this.supportCount = supportCount;
    }

    public Long getUnSupportCount() {
        return unSupportCount;
    }

    public void setUnSupportCount(Long unSupportCount) {
        this.unSupportCount = unSupportCount;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
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
        InteractionStatPO other = (InteractionStatPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTargetType() == null ? other.getTargetType() == null : this.getTargetType().equals(other.getTargetType()))
            && (this.getTargetId() == null ? other.getTargetId() == null : this.getTargetId().equals(other.getTargetId()))
            && (this.getLikeCount() == null ? other.getLikeCount() == null : this.getLikeCount().equals(other.getLikeCount()))
            && (this.getStoreCount() == null ? other.getStoreCount() == null : this.getStoreCount().equals(other.getStoreCount()))
            && (this.getCommentCount() == null ? other.getCommentCount() == null : this.getCommentCount().equals(other.getCommentCount()))
            && (this.getDownloadCount() == null ? other.getDownloadCount() == null : this.getDownloadCount().equals(other.getDownloadCount()))
            && (this.getScoreCount() == null ? other.getScoreCount() == null : this.getScoreCount().equals(other.getScoreCount()))
            && (this.getScoreSum() == null ? other.getScoreSum() == null : this.getScoreSum().equals(other.getScoreSum()))
            && (this.getAgreeCount() == null ? other.getAgreeCount() == null : this.getAgreeCount().equals(other.getAgreeCount()))
            && (this.getDisagreeCount() == null ? other.getDisagreeCount() == null : this.getDisagreeCount().equals(other.getDisagreeCount()))
            && (this.getSupportCount() == null ? other.getSupportCount() == null : this.getSupportCount().equals(other.getSupportCount()))
            && (this.getUnSupportCount() == null ? other.getUnSupportCount() == null : this.getUnSupportCount().equals(other.getUnSupportCount()))
            && (this.getViewCount() == null ? other.getViewCount() == null : this.getViewCount().equals(other.getViewCount()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTargetType() == null) ? 0 : getTargetType().hashCode());
        result = prime * result + ((getTargetId() == null) ? 0 : getTargetId().hashCode());
        result = prime * result + ((getLikeCount() == null) ? 0 : getLikeCount().hashCode());
        result = prime * result + ((getStoreCount() == null) ? 0 : getStoreCount().hashCode());
        result = prime * result + ((getCommentCount() == null) ? 0 : getCommentCount().hashCode());
        result = prime * result + ((getDownloadCount() == null) ? 0 : getDownloadCount().hashCode());
        result = prime * result + ((getScoreCount() == null) ? 0 : getScoreCount().hashCode());
        result = prime * result + ((getScoreSum() == null) ? 0 : getScoreSum().hashCode());
        result = prime * result + ((getAgreeCount() == null) ? 0 : getAgreeCount().hashCode());
        result = prime * result + ((getDisagreeCount() == null) ? 0 : getDisagreeCount().hashCode());
        result = prime * result + ((getSupportCount() == null) ? 0 : getSupportCount().hashCode());
        result = prime * result + ((getUnSupportCount() == null) ? 0 : getUnSupportCount().hashCode());
        result = prime * result + ((getViewCount() == null) ? 0 : getViewCount().hashCode());
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
        sb.append(", targetType=").append(targetType);
        sb.append(", targetId=").append(targetId);
        sb.append(", likeCount=").append(likeCount);
        sb.append(", storeCount=").append(storeCount);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", downloadCount=").append(downloadCount);
        sb.append(", scoreCount=").append(scoreCount);
        sb.append(", scoreSum=").append(scoreSum);
        sb.append(", agreeCount=").append(agreeCount);
        sb.append(", disagreeCount=").append(disagreeCount);
        sb.append(", supportCount=").append(supportCount);
        sb.append(", unSupportCount=").append(unSupportCount);
        sb.append(", viewCount=").append(viewCount);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}