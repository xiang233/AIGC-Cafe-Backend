package com.aigccafe.buterin.common.model.md;

import java.io.Serializable;

public class ModelDetailPOWithBLOBs extends ModelDetailPO implements Serializable {
    private String description;

    private String chnDescription;

    private static final long serialVersionUID = 1L;

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
        ModelDetailPOWithBLOBs other = (ModelDetailPOWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getOriModelId() == null ? other.getOriModelId() == null : this.getOriModelId().equals(other.getOriModelId()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getChnModelName() == null ? other.getChnModelName() == null : this.getChnModelName().equals(other.getChnModelName()))
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
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getChnDescription() == null ? other.getChnDescription() == null : this.getChnDescription().equals(other.getChnDescription()));
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
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getChnDescription() == null) ? 0 : getChnDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", description=").append(description);
        sb.append(", chnDescription=").append(chnDescription);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}