package com.aigccafe.buterin.common.model.cvt;

import java.io.Serializable;

public class CvtModelDetailPOWithBLOBs extends CvtModelDetailPO implements Serializable {
    private String description;

    private String modelVersionList;

    private String rankInfo;

    private String tagsInfo;

    private static final long serialVersionUID = 1L;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getModelVersionList() {
        return modelVersionList;
    }

    public void setModelVersionList(String modelVersionList) {
        this.modelVersionList = modelVersionList == null ? null : modelVersionList.trim();
    }

    public String getRankInfo() {
        return rankInfo;
    }

    public void setRankInfo(String rankInfo) {
        this.rankInfo = rankInfo == null ? null : rankInfo.trim();
    }

    public String getTagsInfo() {
        return tagsInfo;
    }

    public void setTagsInfo(String tagsInfo) {
        this.tagsInfo = tagsInfo == null ? null : tagsInfo.trim();
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
        CvtModelDetailPOWithBLOBs other = (CvtModelDetailPOWithBLOBs) that;
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
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getModelVersionList() == null ? other.getModelVersionList() == null : this.getModelVersionList().equals(other.getModelVersionList()))
            && (this.getRankInfo() == null ? other.getRankInfo() == null : this.getRankInfo().equals(other.getRankInfo()))
            && (this.getTagsInfo() == null ? other.getTagsInfo() == null : this.getTagsInfo().equals(other.getTagsInfo()));
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
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getModelVersionList() == null) ? 0 : getModelVersionList().hashCode());
        result = prime * result + ((getRankInfo() == null) ? 0 : getRankInfo().hashCode());
        result = prime * result + ((getTagsInfo() == null) ? 0 : getTagsInfo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", description=").append(description);
        sb.append(", modelVersionList=").append(modelVersionList);
        sb.append(", rankInfo=").append(rankInfo);
        sb.append(", tagsInfo=").append(tagsInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}