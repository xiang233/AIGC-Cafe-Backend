package com.aigccafe.buterin.common.model.cvt;

import java.util.ArrayList;
import java.util.List;

public class CvtModelDetectPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CvtModelDetectPOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(Long value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(Long value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(Long value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(Long value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(Long value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<Long> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<Long> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(Long value1, Long value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(Long value1, Long value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNull() {
            addCriterion("model_name is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("model_name is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("model_name =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("model_name <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("model_name >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("model_name >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("model_name <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("model_name <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("model_name like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("model_name not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("model_name in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("model_name not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("model_name between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("model_name not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNull() {
            addCriterion("model_type is null");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNotNull() {
            addCriterion("model_type is not null");
            return (Criteria) this;
        }

        public Criteria andModelTypeEqualTo(String value) {
            addCriterion("model_type =", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotEqualTo(String value) {
            addCriterion("model_type <>", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThan(String value) {
            addCriterion("model_type >", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("model_type >=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThan(String value) {
            addCriterion("model_type <", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThanOrEqualTo(String value) {
            addCriterion("model_type <=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLike(String value) {
            addCriterion("model_type like", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotLike(String value) {
            addCriterion("model_type not like", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeIn(List<String> values) {
            addCriterion("model_type in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotIn(List<String> values) {
            addCriterion("model_type not in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeBetween(String value1, String value2) {
            addCriterion("model_type between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotBetween(String value1, String value2) {
            addCriterion("model_type not between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andCheckpointTypeIsNull() {
            addCriterion("checkpoint_type is null");
            return (Criteria) this;
        }

        public Criteria andCheckpointTypeIsNotNull() {
            addCriterion("checkpoint_type is not null");
            return (Criteria) this;
        }

        public Criteria andCheckpointTypeEqualTo(String value) {
            addCriterion("checkpoint_type =", value, "checkpointType");
            return (Criteria) this;
        }

        public Criteria andCheckpointTypeNotEqualTo(String value) {
            addCriterion("checkpoint_type <>", value, "checkpointType");
            return (Criteria) this;
        }

        public Criteria andCheckpointTypeGreaterThan(String value) {
            addCriterion("checkpoint_type >", value, "checkpointType");
            return (Criteria) this;
        }

        public Criteria andCheckpointTypeGreaterThanOrEqualTo(String value) {
            addCriterion("checkpoint_type >=", value, "checkpointType");
            return (Criteria) this;
        }

        public Criteria andCheckpointTypeLessThan(String value) {
            addCriterion("checkpoint_type <", value, "checkpointType");
            return (Criteria) this;
        }

        public Criteria andCheckpointTypeLessThanOrEqualTo(String value) {
            addCriterion("checkpoint_type <=", value, "checkpointType");
            return (Criteria) this;
        }

        public Criteria andCheckpointTypeLike(String value) {
            addCriterion("checkpoint_type like", value, "checkpointType");
            return (Criteria) this;
        }

        public Criteria andCheckpointTypeNotLike(String value) {
            addCriterion("checkpoint_type not like", value, "checkpointType");
            return (Criteria) this;
        }

        public Criteria andCheckpointTypeIn(List<String> values) {
            addCriterion("checkpoint_type in", values, "checkpointType");
            return (Criteria) this;
        }

        public Criteria andCheckpointTypeNotIn(List<String> values) {
            addCriterion("checkpoint_type not in", values, "checkpointType");
            return (Criteria) this;
        }

        public Criteria andCheckpointTypeBetween(String value1, String value2) {
            addCriterion("checkpoint_type between", value1, value2, "checkpointType");
            return (Criteria) this;
        }

        public Criteria andCheckpointTypeNotBetween(String value1, String value2) {
            addCriterion("checkpoint_type not between", value1, value2, "checkpointType");
            return (Criteria) this;
        }

        public Criteria andRequestInfoIsNull() {
            addCriterion("request_info is null");
            return (Criteria) this;
        }

        public Criteria andRequestInfoIsNotNull() {
            addCriterion("request_info is not null");
            return (Criteria) this;
        }

        public Criteria andRequestInfoEqualTo(String value) {
            addCriterion("request_info =", value, "requestInfo");
            return (Criteria) this;
        }

        public Criteria andRequestInfoNotEqualTo(String value) {
            addCriterion("request_info <>", value, "requestInfo");
            return (Criteria) this;
        }

        public Criteria andRequestInfoGreaterThan(String value) {
            addCriterion("request_info >", value, "requestInfo");
            return (Criteria) this;
        }

        public Criteria andRequestInfoGreaterThanOrEqualTo(String value) {
            addCriterion("request_info >=", value, "requestInfo");
            return (Criteria) this;
        }

        public Criteria andRequestInfoLessThan(String value) {
            addCriterion("request_info <", value, "requestInfo");
            return (Criteria) this;
        }

        public Criteria andRequestInfoLessThanOrEqualTo(String value) {
            addCriterion("request_info <=", value, "requestInfo");
            return (Criteria) this;
        }

        public Criteria andRequestInfoLike(String value) {
            addCriterion("request_info like", value, "requestInfo");
            return (Criteria) this;
        }

        public Criteria andRequestInfoNotLike(String value) {
            addCriterion("request_info not like", value, "requestInfo");
            return (Criteria) this;
        }

        public Criteria andRequestInfoIn(List<String> values) {
            addCriterion("request_info in", values, "requestInfo");
            return (Criteria) this;
        }

        public Criteria andRequestInfoNotIn(List<String> values) {
            addCriterion("request_info not in", values, "requestInfo");
            return (Criteria) this;
        }

        public Criteria andRequestInfoBetween(String value1, String value2) {
            addCriterion("request_info between", value1, value2, "requestInfo");
            return (Criteria) this;
        }

        public Criteria andRequestInfoNotBetween(String value1, String value2) {
            addCriterion("request_info not between", value1, value2, "requestInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoIsNull() {
            addCriterion("rank_info is null");
            return (Criteria) this;
        }

        public Criteria andRankInfoIsNotNull() {
            addCriterion("rank_info is not null");
            return (Criteria) this;
        }

        public Criteria andRankInfoEqualTo(String value) {
            addCriterion("rank_info =", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoNotEqualTo(String value) {
            addCriterion("rank_info <>", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoGreaterThan(String value) {
            addCriterion("rank_info >", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoGreaterThanOrEqualTo(String value) {
            addCriterion("rank_info >=", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoLessThan(String value) {
            addCriterion("rank_info <", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoLessThanOrEqualTo(String value) {
            addCriterion("rank_info <=", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoLike(String value) {
            addCriterion("rank_info like", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoNotLike(String value) {
            addCriterion("rank_info not like", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoIn(List<String> values) {
            addCriterion("rank_info in", values, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoNotIn(List<String> values) {
            addCriterion("rank_info not in", values, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoBetween(String value1, String value2) {
            addCriterion("rank_info between", value1, value2, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoNotBetween(String value1, String value2) {
            addCriterion("rank_info not between", value1, value2, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andCoverImageDataIsNull() {
            addCriterion("cover_image_data is null");
            return (Criteria) this;
        }

        public Criteria andCoverImageDataIsNotNull() {
            addCriterion("cover_image_data is not null");
            return (Criteria) this;
        }

        public Criteria andCoverImageDataEqualTo(String value) {
            addCriterion("cover_image_data =", value, "coverImageData");
            return (Criteria) this;
        }

        public Criteria andCoverImageDataNotEqualTo(String value) {
            addCriterion("cover_image_data <>", value, "coverImageData");
            return (Criteria) this;
        }

        public Criteria andCoverImageDataGreaterThan(String value) {
            addCriterion("cover_image_data >", value, "coverImageData");
            return (Criteria) this;
        }

        public Criteria andCoverImageDataGreaterThanOrEqualTo(String value) {
            addCriterion("cover_image_data >=", value, "coverImageData");
            return (Criteria) this;
        }

        public Criteria andCoverImageDataLessThan(String value) {
            addCriterion("cover_image_data <", value, "coverImageData");
            return (Criteria) this;
        }

        public Criteria andCoverImageDataLessThanOrEqualTo(String value) {
            addCriterion("cover_image_data <=", value, "coverImageData");
            return (Criteria) this;
        }

        public Criteria andCoverImageDataLike(String value) {
            addCriterion("cover_image_data like", value, "coverImageData");
            return (Criteria) this;
        }

        public Criteria andCoverImageDataNotLike(String value) {
            addCriterion("cover_image_data not like", value, "coverImageData");
            return (Criteria) this;
        }

        public Criteria andCoverImageDataIn(List<String> values) {
            addCriterion("cover_image_data in", values, "coverImageData");
            return (Criteria) this;
        }

        public Criteria andCoverImageDataNotIn(List<String> values) {
            addCriterion("cover_image_data not in", values, "coverImageData");
            return (Criteria) this;
        }

        public Criteria andCoverImageDataBetween(String value1, String value2) {
            addCriterion("cover_image_data between", value1, value2, "coverImageData");
            return (Criteria) this;
        }

        public Criteria andCoverImageDataNotBetween(String value1, String value2) {
            addCriterion("cover_image_data not between", value1, value2, "coverImageData");
            return (Criteria) this;
        }

        public Criteria andLastVersionAtIsNull() {
            addCriterion("last_version_at is null");
            return (Criteria) this;
        }

        public Criteria andLastVersionAtIsNotNull() {
            addCriterion("last_version_at is not null");
            return (Criteria) this;
        }

        public Criteria andLastVersionAtEqualTo(String value) {
            addCriterion("last_version_at =", value, "lastVersionAt");
            return (Criteria) this;
        }

        public Criteria andLastVersionAtNotEqualTo(String value) {
            addCriterion("last_version_at <>", value, "lastVersionAt");
            return (Criteria) this;
        }

        public Criteria andLastVersionAtGreaterThan(String value) {
            addCriterion("last_version_at >", value, "lastVersionAt");
            return (Criteria) this;
        }

        public Criteria andLastVersionAtGreaterThanOrEqualTo(String value) {
            addCriterion("last_version_at >=", value, "lastVersionAt");
            return (Criteria) this;
        }

        public Criteria andLastVersionAtLessThan(String value) {
            addCriterion("last_version_at <", value, "lastVersionAt");
            return (Criteria) this;
        }

        public Criteria andLastVersionAtLessThanOrEqualTo(String value) {
            addCriterion("last_version_at <=", value, "lastVersionAt");
            return (Criteria) this;
        }

        public Criteria andLastVersionAtLike(String value) {
            addCriterion("last_version_at like", value, "lastVersionAt");
            return (Criteria) this;
        }

        public Criteria andLastVersionAtNotLike(String value) {
            addCriterion("last_version_at not like", value, "lastVersionAt");
            return (Criteria) this;
        }

        public Criteria andLastVersionAtIn(List<String> values) {
            addCriterion("last_version_at in", values, "lastVersionAt");
            return (Criteria) this;
        }

        public Criteria andLastVersionAtNotIn(List<String> values) {
            addCriterion("last_version_at not in", values, "lastVersionAt");
            return (Criteria) this;
        }

        public Criteria andLastVersionAtBetween(String value1, String value2) {
            addCriterion("last_version_at between", value1, value2, "lastVersionAt");
            return (Criteria) this;
        }

        public Criteria andLastVersionAtNotBetween(String value1, String value2) {
            addCriterion("last_version_at not between", value1, value2, "lastVersionAt");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateIsNull() {
            addCriterion("detail_update is null");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateIsNotNull() {
            addCriterion("detail_update is not null");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateEqualTo(Boolean value) {
            addCriterion("detail_update =", value, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateNotEqualTo(Boolean value) {
            addCriterion("detail_update <>", value, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateGreaterThan(Boolean value) {
            addCriterion("detail_update >", value, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("detail_update >=", value, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateLessThan(Boolean value) {
            addCriterion("detail_update <", value, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateLessThanOrEqualTo(Boolean value) {
            addCriterion("detail_update <=", value, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateIn(List<Boolean> values) {
            addCriterion("detail_update in", values, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateNotIn(List<Boolean> values) {
            addCriterion("detail_update not in", values, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateBetween(Boolean value1, Boolean value2) {
            addCriterion("detail_update between", value1, value2, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("detail_update not between", value1, value2, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Long value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Long value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Long value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Long value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Long value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Long value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Long> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Long> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Long value1, Long value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Long value1, Long value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Long value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Long value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Long value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Long value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Long value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Long value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Long> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Long> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Long value1, Long value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Long value1, Long value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}