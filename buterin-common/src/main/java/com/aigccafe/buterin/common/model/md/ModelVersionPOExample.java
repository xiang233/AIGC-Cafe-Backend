package com.aigccafe.buterin.common.model.md;

import java.util.ArrayList;
import java.util.List;

public class ModelVersionPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModelVersionPOExample() {
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

        public Criteria andPlatformIsNull() {
            addCriterion("platform is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("platform is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(String value) {
            addCriterion("platform =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(String value) {
            addCriterion("platform <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(String value) {
            addCriterion("platform >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(String value) {
            addCriterion("platform >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(String value) {
            addCriterion("platform <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(String value) {
            addCriterion("platform <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLike(String value) {
            addCriterion("platform like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotLike(String value) {
            addCriterion("platform not like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<String> values) {
            addCriterion("platform in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<String> values) {
            addCriterion("platform not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(String value1, String value2) {
            addCriterion("platform between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(String value1, String value2) {
            addCriterion("platform not between", value1, value2, "platform");
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

        public Criteria andOriModelIdIsNull() {
            addCriterion("ori_model_id is null");
            return (Criteria) this;
        }

        public Criteria andOriModelIdIsNotNull() {
            addCriterion("ori_model_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriModelIdEqualTo(Long value) {
            addCriterion("ori_model_id =", value, "oriModelId");
            return (Criteria) this;
        }

        public Criteria andOriModelIdNotEqualTo(Long value) {
            addCriterion("ori_model_id <>", value, "oriModelId");
            return (Criteria) this;
        }

        public Criteria andOriModelIdGreaterThan(Long value) {
            addCriterion("ori_model_id >", value, "oriModelId");
            return (Criteria) this;
        }

        public Criteria andOriModelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ori_model_id >=", value, "oriModelId");
            return (Criteria) this;
        }

        public Criteria andOriModelIdLessThan(Long value) {
            addCriterion("ori_model_id <", value, "oriModelId");
            return (Criteria) this;
        }

        public Criteria andOriModelIdLessThanOrEqualTo(Long value) {
            addCriterion("ori_model_id <=", value, "oriModelId");
            return (Criteria) this;
        }

        public Criteria andOriModelIdIn(List<Long> values) {
            addCriterion("ori_model_id in", values, "oriModelId");
            return (Criteria) this;
        }

        public Criteria andOriModelIdNotIn(List<Long> values) {
            addCriterion("ori_model_id not in", values, "oriModelId");
            return (Criteria) this;
        }

        public Criteria andOriModelIdBetween(Long value1, Long value2) {
            addCriterion("ori_model_id between", value1, value2, "oriModelId");
            return (Criteria) this;
        }

        public Criteria andOriModelIdNotBetween(Long value1, Long value2) {
            addCriterion("ori_model_id not between", value1, value2, "oriModelId");
            return (Criteria) this;
        }

        public Criteria andOriVersionIdIsNull() {
            addCriterion("ori_version_id is null");
            return (Criteria) this;
        }

        public Criteria andOriVersionIdIsNotNull() {
            addCriterion("ori_version_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriVersionIdEqualTo(Long value) {
            addCriterion("ori_version_id =", value, "oriVersionId");
            return (Criteria) this;
        }

        public Criteria andOriVersionIdNotEqualTo(Long value) {
            addCriterion("ori_version_id <>", value, "oriVersionId");
            return (Criteria) this;
        }

        public Criteria andOriVersionIdGreaterThan(Long value) {
            addCriterion("ori_version_id >", value, "oriVersionId");
            return (Criteria) this;
        }

        public Criteria andOriVersionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ori_version_id >=", value, "oriVersionId");
            return (Criteria) this;
        }

        public Criteria andOriVersionIdLessThan(Long value) {
            addCriterion("ori_version_id <", value, "oriVersionId");
            return (Criteria) this;
        }

        public Criteria andOriVersionIdLessThanOrEqualTo(Long value) {
            addCriterion("ori_version_id <=", value, "oriVersionId");
            return (Criteria) this;
        }

        public Criteria andOriVersionIdIn(List<Long> values) {
            addCriterion("ori_version_id in", values, "oriVersionId");
            return (Criteria) this;
        }

        public Criteria andOriVersionIdNotIn(List<Long> values) {
            addCriterion("ori_version_id not in", values, "oriVersionId");
            return (Criteria) this;
        }

        public Criteria andOriVersionIdBetween(Long value1, Long value2) {
            addCriterion("ori_version_id between", value1, value2, "oriVersionId");
            return (Criteria) this;
        }

        public Criteria andOriVersionIdNotBetween(Long value1, Long value2) {
            addCriterion("ori_version_id not between", value1, value2, "oriVersionId");
            return (Criteria) this;
        }

        public Criteria andVersionNameIsNull() {
            addCriterion("version_name is null");
            return (Criteria) this;
        }

        public Criteria andVersionNameIsNotNull() {
            addCriterion("version_name is not null");
            return (Criteria) this;
        }

        public Criteria andVersionNameEqualTo(String value) {
            addCriterion("version_name =", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameNotEqualTo(String value) {
            addCriterion("version_name <>", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameGreaterThan(String value) {
            addCriterion("version_name >", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameGreaterThanOrEqualTo(String value) {
            addCriterion("version_name >=", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameLessThan(String value) {
            addCriterion("version_name <", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameLessThanOrEqualTo(String value) {
            addCriterion("version_name <=", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameLike(String value) {
            addCriterion("version_name like", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameNotLike(String value) {
            addCriterion("version_name not like", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameIn(List<String> values) {
            addCriterion("version_name in", values, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameNotIn(List<String> values) {
            addCriterion("version_name not in", values, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameBetween(String value1, String value2) {
            addCriterion("version_name between", value1, value2, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameNotBetween(String value1, String value2) {
            addCriterion("version_name not between", value1, value2, "versionName");
            return (Criteria) this;
        }

        public Criteria andBaseModelIsNull() {
            addCriterion("base_model is null");
            return (Criteria) this;
        }

        public Criteria andBaseModelIsNotNull() {
            addCriterion("base_model is not null");
            return (Criteria) this;
        }

        public Criteria andBaseModelEqualTo(String value) {
            addCriterion("base_model =", value, "baseModel");
            return (Criteria) this;
        }

        public Criteria andBaseModelNotEqualTo(String value) {
            addCriterion("base_model <>", value, "baseModel");
            return (Criteria) this;
        }

        public Criteria andBaseModelGreaterThan(String value) {
            addCriterion("base_model >", value, "baseModel");
            return (Criteria) this;
        }

        public Criteria andBaseModelGreaterThanOrEqualTo(String value) {
            addCriterion("base_model >=", value, "baseModel");
            return (Criteria) this;
        }

        public Criteria andBaseModelLessThan(String value) {
            addCriterion("base_model <", value, "baseModel");
            return (Criteria) this;
        }

        public Criteria andBaseModelLessThanOrEqualTo(String value) {
            addCriterion("base_model <=", value, "baseModel");
            return (Criteria) this;
        }

        public Criteria andBaseModelLike(String value) {
            addCriterion("base_model like", value, "baseModel");
            return (Criteria) this;
        }

        public Criteria andBaseModelNotLike(String value) {
            addCriterion("base_model not like", value, "baseModel");
            return (Criteria) this;
        }

        public Criteria andBaseModelIn(List<String> values) {
            addCriterion("base_model in", values, "baseModel");
            return (Criteria) this;
        }

        public Criteria andBaseModelNotIn(List<String> values) {
            addCriterion("base_model not in", values, "baseModel");
            return (Criteria) this;
        }

        public Criteria andBaseModelBetween(String value1, String value2) {
            addCriterion("base_model between", value1, value2, "baseModel");
            return (Criteria) this;
        }

        public Criteria andBaseModelNotBetween(String value1, String value2) {
            addCriterion("base_model not between", value1, value2, "baseModel");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDownloadCntIsNull() {
            addCriterion("download_cnt is null");
            return (Criteria) this;
        }

        public Criteria andDownloadCntIsNotNull() {
            addCriterion("download_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadCntEqualTo(Long value) {
            addCriterion("download_cnt =", value, "downloadCnt");
            return (Criteria) this;
        }

        public Criteria andDownloadCntNotEqualTo(Long value) {
            addCriterion("download_cnt <>", value, "downloadCnt");
            return (Criteria) this;
        }

        public Criteria andDownloadCntGreaterThan(Long value) {
            addCriterion("download_cnt >", value, "downloadCnt");
            return (Criteria) this;
        }

        public Criteria andDownloadCntGreaterThanOrEqualTo(Long value) {
            addCriterion("download_cnt >=", value, "downloadCnt");
            return (Criteria) this;
        }

        public Criteria andDownloadCntLessThan(Long value) {
            addCriterion("download_cnt <", value, "downloadCnt");
            return (Criteria) this;
        }

        public Criteria andDownloadCntLessThanOrEqualTo(Long value) {
            addCriterion("download_cnt <=", value, "downloadCnt");
            return (Criteria) this;
        }

        public Criteria andDownloadCntIn(List<Long> values) {
            addCriterion("download_cnt in", values, "downloadCnt");
            return (Criteria) this;
        }

        public Criteria andDownloadCntNotIn(List<Long> values) {
            addCriterion("download_cnt not in", values, "downloadCnt");
            return (Criteria) this;
        }

        public Criteria andDownloadCntBetween(Long value1, Long value2) {
            addCriterion("download_cnt between", value1, value2, "downloadCnt");
            return (Criteria) this;
        }

        public Criteria andDownloadCntNotBetween(Long value1, Long value2) {
            addCriterion("download_cnt not between", value1, value2, "downloadCnt");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedAtIsNull() {
            addCriterion("last_updated_at is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedAtIsNotNull() {
            addCriterion("last_updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedAtEqualTo(String value) {
            addCriterion("last_updated_at =", value, "lastUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedAtNotEqualTo(String value) {
            addCriterion("last_updated_at <>", value, "lastUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedAtGreaterThan(String value) {
            addCriterion("last_updated_at >", value, "lastUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedAtGreaterThanOrEqualTo(String value) {
            addCriterion("last_updated_at >=", value, "lastUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedAtLessThan(String value) {
            addCriterion("last_updated_at <", value, "lastUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedAtLessThanOrEqualTo(String value) {
            addCriterion("last_updated_at <=", value, "lastUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedAtLike(String value) {
            addCriterion("last_updated_at like", value, "lastUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedAtNotLike(String value) {
            addCriterion("last_updated_at not like", value, "lastUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedAtIn(List<String> values) {
            addCriterion("last_updated_at in", values, "lastUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedAtNotIn(List<String> values) {
            addCriterion("last_updated_at not in", values, "lastUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedAtBetween(String value1, String value2) {
            addCriterion("last_updated_at between", value1, value2, "lastUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedAtNotBetween(String value1, String value2) {
            addCriterion("last_updated_at not between", value1, value2, "lastUpdatedAt");
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