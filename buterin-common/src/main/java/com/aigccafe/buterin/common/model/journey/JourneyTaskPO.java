package com.aigccafe.buterin.common.model.journey;

import java.io.Serializable;

public class JourneyTaskPO implements Serializable {
    private Long id;

    private Long sessionId;

    private Long userId;

    private String taskType;

    private String referImageList;

    private Integer imageIndex;

    private String prompt;

    private Long fatherTaskId;

    private String oriTaskId;

    private String dimensions;

    private String status;

    private String progress;

    private String failReason;

    private String dImageUrl;

    private String midImageUrl;

    private String midSubImageList;

    private String imagePath;

    private String rawImagePath;

    private String subImagePathList;

    private String rawSubImagePathList;

    private Long submitTime;

    private Long startTime;

    private Long finishTime;

    private String taskResp;

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

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getReferImageList() {
        return referImageList;
    }

    public void setReferImageList(String referImageList) {
        this.referImageList = referImageList == null ? null : referImageList.trim();
    }

    public Integer getImageIndex() {
        return imageIndex;
    }

    public void setImageIndex(Integer imageIndex) {
        this.imageIndex = imageIndex;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt == null ? null : prompt.trim();
    }

    public Long getFatherTaskId() {
        return fatherTaskId;
    }

    public void setFatherTaskId(Long fatherTaskId) {
        this.fatherTaskId = fatherTaskId;
    }

    public String getOriTaskId() {
        return oriTaskId;
    }

    public void setOriTaskId(String oriTaskId) {
        this.oriTaskId = oriTaskId == null ? null : oriTaskId.trim();
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions == null ? null : dimensions.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress == null ? null : progress.trim();
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    public String getdImageUrl() {
        return dImageUrl;
    }

    public void setdImageUrl(String dImageUrl) {
        this.dImageUrl = dImageUrl == null ? null : dImageUrl.trim();
    }

    public String getMidImageUrl() {
        return midImageUrl;
    }

    public void setMidImageUrl(String midImageUrl) {
        this.midImageUrl = midImageUrl == null ? null : midImageUrl.trim();
    }

    public String getMidSubImageList() {
        return midSubImageList;
    }

    public void setMidSubImageList(String midSubImageList) {
        this.midSubImageList = midSubImageList == null ? null : midSubImageList.trim();
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public String getRawImagePath() {
        return rawImagePath;
    }

    public void setRawImagePath(String rawImagePath) {
        this.rawImagePath = rawImagePath == null ? null : rawImagePath.trim();
    }

    public String getSubImagePathList() {
        return subImagePathList;
    }

    public void setSubImagePathList(String subImagePathList) {
        this.subImagePathList = subImagePathList == null ? null : subImagePathList.trim();
    }

    public String getRawSubImagePathList() {
        return rawSubImagePathList;
    }

    public void setRawSubImagePathList(String rawSubImagePathList) {
        this.rawSubImagePathList = rawSubImagePathList == null ? null : rawSubImagePathList.trim();
    }

    public Long getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Long submitTime) {
        this.submitTime = submitTime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }

    public String getTaskResp() {
        return taskResp;
    }

    public void setTaskResp(String taskResp) {
        this.taskResp = taskResp == null ? null : taskResp.trim();
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
        JourneyTaskPO other = (JourneyTaskPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSessionId() == null ? other.getSessionId() == null : this.getSessionId().equals(other.getSessionId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTaskType() == null ? other.getTaskType() == null : this.getTaskType().equals(other.getTaskType()))
            && (this.getReferImageList() == null ? other.getReferImageList() == null : this.getReferImageList().equals(other.getReferImageList()))
            && (this.getImageIndex() == null ? other.getImageIndex() == null : this.getImageIndex().equals(other.getImageIndex()))
            && (this.getPrompt() == null ? other.getPrompt() == null : this.getPrompt().equals(other.getPrompt()))
            && (this.getFatherTaskId() == null ? other.getFatherTaskId() == null : this.getFatherTaskId().equals(other.getFatherTaskId()))
            && (this.getOriTaskId() == null ? other.getOriTaskId() == null : this.getOriTaskId().equals(other.getOriTaskId()))
            && (this.getDimensions() == null ? other.getDimensions() == null : this.getDimensions().equals(other.getDimensions()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getProgress() == null ? other.getProgress() == null : this.getProgress().equals(other.getProgress()))
            && (this.getFailReason() == null ? other.getFailReason() == null : this.getFailReason().equals(other.getFailReason()))
            && (this.getdImageUrl() == null ? other.getdImageUrl() == null : this.getdImageUrl().equals(other.getdImageUrl()))
            && (this.getMidImageUrl() == null ? other.getMidImageUrl() == null : this.getMidImageUrl().equals(other.getMidImageUrl()))
            && (this.getMidSubImageList() == null ? other.getMidSubImageList() == null : this.getMidSubImageList().equals(other.getMidSubImageList()))
            && (this.getImagePath() == null ? other.getImagePath() == null : this.getImagePath().equals(other.getImagePath()))
            && (this.getRawImagePath() == null ? other.getRawImagePath() == null : this.getRawImagePath().equals(other.getRawImagePath()))
            && (this.getSubImagePathList() == null ? other.getSubImagePathList() == null : this.getSubImagePathList().equals(other.getSubImagePathList()))
            && (this.getRawSubImagePathList() == null ? other.getRawSubImagePathList() == null : this.getRawSubImagePathList().equals(other.getRawSubImagePathList()))
            && (this.getSubmitTime() == null ? other.getSubmitTime() == null : this.getSubmitTime().equals(other.getSubmitTime()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getTaskResp() == null ? other.getTaskResp() == null : this.getTaskResp().equals(other.getTaskResp()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSessionId() == null) ? 0 : getSessionId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTaskType() == null) ? 0 : getTaskType().hashCode());
        result = prime * result + ((getReferImageList() == null) ? 0 : getReferImageList().hashCode());
        result = prime * result + ((getImageIndex() == null) ? 0 : getImageIndex().hashCode());
        result = prime * result + ((getPrompt() == null) ? 0 : getPrompt().hashCode());
        result = prime * result + ((getFatherTaskId() == null) ? 0 : getFatherTaskId().hashCode());
        result = prime * result + ((getOriTaskId() == null) ? 0 : getOriTaskId().hashCode());
        result = prime * result + ((getDimensions() == null) ? 0 : getDimensions().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getProgress() == null) ? 0 : getProgress().hashCode());
        result = prime * result + ((getFailReason() == null) ? 0 : getFailReason().hashCode());
        result = prime * result + ((getdImageUrl() == null) ? 0 : getdImageUrl().hashCode());
        result = prime * result + ((getMidImageUrl() == null) ? 0 : getMidImageUrl().hashCode());
        result = prime * result + ((getMidSubImageList() == null) ? 0 : getMidSubImageList().hashCode());
        result = prime * result + ((getImagePath() == null) ? 0 : getImagePath().hashCode());
        result = prime * result + ((getRawImagePath() == null) ? 0 : getRawImagePath().hashCode());
        result = prime * result + ((getSubImagePathList() == null) ? 0 : getSubImagePathList().hashCode());
        result = prime * result + ((getRawSubImagePathList() == null) ? 0 : getRawSubImagePathList().hashCode());
        result = prime * result + ((getSubmitTime() == null) ? 0 : getSubmitTime().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getTaskResp() == null) ? 0 : getTaskResp().hashCode());
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
        sb.append(", sessionId=").append(sessionId);
        sb.append(", userId=").append(userId);
        sb.append(", taskType=").append(taskType);
        sb.append(", referImageList=").append(referImageList);
        sb.append(", imageIndex=").append(imageIndex);
        sb.append(", prompt=").append(prompt);
        sb.append(", fatherTaskId=").append(fatherTaskId);
        sb.append(", oriTaskId=").append(oriTaskId);
        sb.append(", dimensions=").append(dimensions);
        sb.append(", status=").append(status);
        sb.append(", progress=").append(progress);
        sb.append(", failReason=").append(failReason);
        sb.append(", dImageUrl=").append(dImageUrl);
        sb.append(", midImageUrl=").append(midImageUrl);
        sb.append(", midSubImageList=").append(midSubImageList);
        sb.append(", imagePath=").append(imagePath);
        sb.append(", rawImagePath=").append(rawImagePath);
        sb.append(", subImagePathList=").append(subImagePathList);
        sb.append(", rawSubImagePathList=").append(rawSubImagePathList);
        sb.append(", submitTime=").append(submitTime);
        sb.append(", startTime=").append(startTime);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", taskResp=").append(taskResp);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}