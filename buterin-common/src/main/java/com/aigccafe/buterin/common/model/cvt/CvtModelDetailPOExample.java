package com.aigccafe.buterin.common.model.cvt;

import java.util.ArrayList;
import java.util.List;

public class CvtModelDetailPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CvtModelDetailPOExample() {
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

        public Criteria andNsfwIsNull() {
            addCriterion("nsfw is null");
            return (Criteria) this;
        }

        public Criteria andNsfwIsNotNull() {
            addCriterion("nsfw is not null");
            return (Criteria) this;
        }

        public Criteria andNsfwEqualTo(Boolean value) {
            addCriterion("nsfw =", value, "nsfw");
            return (Criteria) this;
        }

        public Criteria andNsfwNotEqualTo(Boolean value) {
            addCriterion("nsfw <>", value, "nsfw");
            return (Criteria) this;
        }

        public Criteria andNsfwGreaterThan(Boolean value) {
            addCriterion("nsfw >", value, "nsfw");
            return (Criteria) this;
        }

        public Criteria andNsfwGreaterThanOrEqualTo(Boolean value) {
            addCriterion("nsfw >=", value, "nsfw");
            return (Criteria) this;
        }

        public Criteria andNsfwLessThan(Boolean value) {
            addCriterion("nsfw <", value, "nsfw");
            return (Criteria) this;
        }

        public Criteria andNsfwLessThanOrEqualTo(Boolean value) {
            addCriterion("nsfw <=", value, "nsfw");
            return (Criteria) this;
        }

        public Criteria andNsfwIn(List<Boolean> values) {
            addCriterion("nsfw in", values, "nsfw");
            return (Criteria) this;
        }

        public Criteria andNsfwNotIn(List<Boolean> values) {
            addCriterion("nsfw not in", values, "nsfw");
            return (Criteria) this;
        }

        public Criteria andNsfwBetween(Boolean value1, Boolean value2) {
            addCriterion("nsfw between", value1, value2, "nsfw");
            return (Criteria) this;
        }

        public Criteria andNsfwNotBetween(Boolean value1, Boolean value2) {
            addCriterion("nsfw not between", value1, value2, "nsfw");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCheckpointtypeIsNull() {
            addCriterion("checkpointType is null");
            return (Criteria) this;
        }

        public Criteria andCheckpointtypeIsNotNull() {
            addCriterion("checkpointType is not null");
            return (Criteria) this;
        }

        public Criteria andCheckpointtypeEqualTo(String value) {
            addCriterion("checkpointType =", value, "checkpointtype");
            return (Criteria) this;
        }

        public Criteria andCheckpointtypeNotEqualTo(String value) {
            addCriterion("checkpointType <>", value, "checkpointtype");
            return (Criteria) this;
        }

        public Criteria andCheckpointtypeGreaterThan(String value) {
            addCriterion("checkpointType >", value, "checkpointtype");
            return (Criteria) this;
        }

        public Criteria andCheckpointtypeGreaterThanOrEqualTo(String value) {
            addCriterion("checkpointType >=", value, "checkpointtype");
            return (Criteria) this;
        }

        public Criteria andCheckpointtypeLessThan(String value) {
            addCriterion("checkpointType <", value, "checkpointtype");
            return (Criteria) this;
        }

        public Criteria andCheckpointtypeLessThanOrEqualTo(String value) {
            addCriterion("checkpointType <=", value, "checkpointtype");
            return (Criteria) this;
        }

        public Criteria andCheckpointtypeLike(String value) {
            addCriterion("checkpointType like", value, "checkpointtype");
            return (Criteria) this;
        }

        public Criteria andCheckpointtypeNotLike(String value) {
            addCriterion("checkpointType not like", value, "checkpointtype");
            return (Criteria) this;
        }

        public Criteria andCheckpointtypeIn(List<String> values) {
            addCriterion("checkpointType in", values, "checkpointtype");
            return (Criteria) this;
        }

        public Criteria andCheckpointtypeNotIn(List<String> values) {
            addCriterion("checkpointType not in", values, "checkpointtype");
            return (Criteria) this;
        }

        public Criteria andCheckpointtypeBetween(String value1, String value2) {
            addCriterion("checkpointType between", value1, value2, "checkpointtype");
            return (Criteria) this;
        }

        public Criteria andCheckpointtypeNotBetween(String value1, String value2) {
            addCriterion("checkpointType not between", value1, value2, "checkpointtype");
            return (Criteria) this;
        }

        public Criteria andUserInfoIsNull() {
            addCriterion("user_info is null");
            return (Criteria) this;
        }

        public Criteria andUserInfoIsNotNull() {
            addCriterion("user_info is not null");
            return (Criteria) this;
        }

        public Criteria andUserInfoEqualTo(String value) {
            addCriterion("user_info =", value, "userInfo");
            return (Criteria) this;
        }

        public Criteria andUserInfoNotEqualTo(String value) {
            addCriterion("user_info <>", value, "userInfo");
            return (Criteria) this;
        }

        public Criteria andUserInfoGreaterThan(String value) {
            addCriterion("user_info >", value, "userInfo");
            return (Criteria) this;
        }

        public Criteria andUserInfoGreaterThanOrEqualTo(String value) {
            addCriterion("user_info >=", value, "userInfo");
            return (Criteria) this;
        }

        public Criteria andUserInfoLessThan(String value) {
            addCriterion("user_info <", value, "userInfo");
            return (Criteria) this;
        }

        public Criteria andUserInfoLessThanOrEqualTo(String value) {
            addCriterion("user_info <=", value, "userInfo");
            return (Criteria) this;
        }

        public Criteria andUserInfoLike(String value) {
            addCriterion("user_info like", value, "userInfo");
            return (Criteria) this;
        }

        public Criteria andUserInfoNotLike(String value) {
            addCriterion("user_info not like", value, "userInfo");
            return (Criteria) this;
        }

        public Criteria andUserInfoIn(List<String> values) {
            addCriterion("user_info in", values, "userInfo");
            return (Criteria) this;
        }

        public Criteria andUserInfoNotIn(List<String> values) {
            addCriterion("user_info not in", values, "userInfo");
            return (Criteria) this;
        }

        public Criteria andUserInfoBetween(String value1, String value2) {
            addCriterion("user_info between", value1, value2, "userInfo");
            return (Criteria) this;
        }

        public Criteria andUserInfoNotBetween(String value1, String value2) {
            addCriterion("user_info not between", value1, value2, "userInfo");
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

        public Criteria andVersionImageUpdateIsNull() {
            addCriterion("version_image_update is null");
            return (Criteria) this;
        }

        public Criteria andVersionImageUpdateIsNotNull() {
            addCriterion("version_image_update is not null");
            return (Criteria) this;
        }

        public Criteria andVersionImageUpdateEqualTo(Boolean value) {
            addCriterion("version_image_update =", value, "versionImageUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionImageUpdateNotEqualTo(Boolean value) {
            addCriterion("version_image_update <>", value, "versionImageUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionImageUpdateGreaterThan(Boolean value) {
            addCriterion("version_image_update >", value, "versionImageUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionImageUpdateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("version_image_update >=", value, "versionImageUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionImageUpdateLessThan(Boolean value) {
            addCriterion("version_image_update <", value, "versionImageUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionImageUpdateLessThanOrEqualTo(Boolean value) {
            addCriterion("version_image_update <=", value, "versionImageUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionImageUpdateIn(List<Boolean> values) {
            addCriterion("version_image_update in", values, "versionImageUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionImageUpdateNotIn(List<Boolean> values) {
            addCriterion("version_image_update not in", values, "versionImageUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionImageUpdateBetween(Boolean value1, Boolean value2) {
            addCriterion("version_image_update between", value1, value2, "versionImageUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionImageUpdateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("version_image_update not between", value1, value2, "versionImageUpdate");
            return (Criteria) this;
        }

        public Criteria andPostImageUpdateIsNull() {
            addCriterion("post_image_update is null");
            return (Criteria) this;
        }

        public Criteria andPostImageUpdateIsNotNull() {
            addCriterion("post_image_update is not null");
            return (Criteria) this;
        }

        public Criteria andPostImageUpdateEqualTo(Boolean value) {
            addCriterion("post_image_update =", value, "postImageUpdate");
            return (Criteria) this;
        }

        public Criteria andPostImageUpdateNotEqualTo(Boolean value) {
            addCriterion("post_image_update <>", value, "postImageUpdate");
            return (Criteria) this;
        }

        public Criteria andPostImageUpdateGreaterThan(Boolean value) {
            addCriterion("post_image_update >", value, "postImageUpdate");
            return (Criteria) this;
        }

        public Criteria andPostImageUpdateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("post_image_update >=", value, "postImageUpdate");
            return (Criteria) this;
        }

        public Criteria andPostImageUpdateLessThan(Boolean value) {
            addCriterion("post_image_update <", value, "postImageUpdate");
            return (Criteria) this;
        }

        public Criteria andPostImageUpdateLessThanOrEqualTo(Boolean value) {
            addCriterion("post_image_update <=", value, "postImageUpdate");
            return (Criteria) this;
        }

        public Criteria andPostImageUpdateIn(List<Boolean> values) {
            addCriterion("post_image_update in", values, "postImageUpdate");
            return (Criteria) this;
        }

        public Criteria andPostImageUpdateNotIn(List<Boolean> values) {
            addCriterion("post_image_update not in", values, "postImageUpdate");
            return (Criteria) this;
        }

        public Criteria andPostImageUpdateBetween(Boolean value1, Boolean value2) {
            addCriterion("post_image_update between", value1, value2, "postImageUpdate");
            return (Criteria) this;
        }

        public Criteria andPostImageUpdateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("post_image_update not between", value1, value2, "postImageUpdate");
            return (Criteria) this;
        }

        public Criteria andMergedIsNull() {
            addCriterion("merged is null");
            return (Criteria) this;
        }

        public Criteria andMergedIsNotNull() {
            addCriterion("merged is not null");
            return (Criteria) this;
        }

        public Criteria andMergedEqualTo(Boolean value) {
            addCriterion("merged =", value, "merged");
            return (Criteria) this;
        }

        public Criteria andMergedNotEqualTo(Boolean value) {
            addCriterion("merged <>", value, "merged");
            return (Criteria) this;
        }

        public Criteria andMergedGreaterThan(Boolean value) {
            addCriterion("merged >", value, "merged");
            return (Criteria) this;
        }

        public Criteria andMergedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("merged >=", value, "merged");
            return (Criteria) this;
        }

        public Criteria andMergedLessThan(Boolean value) {
            addCriterion("merged <", value, "merged");
            return (Criteria) this;
        }

        public Criteria andMergedLessThanOrEqualTo(Boolean value) {
            addCriterion("merged <=", value, "merged");
            return (Criteria) this;
        }

        public Criteria andMergedIn(List<Boolean> values) {
            addCriterion("merged in", values, "merged");
            return (Criteria) this;
        }

        public Criteria andMergedNotIn(List<Boolean> values) {
            addCriterion("merged not in", values, "merged");
            return (Criteria) this;
        }

        public Criteria andMergedBetween(Boolean value1, Boolean value2) {
            addCriterion("merged between", value1, value2, "merged");
            return (Criteria) this;
        }

        public Criteria andMergedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("merged not between", value1, value2, "merged");
            return (Criteria) this;
        }

        public Criteria andNeedCheckUpdateIsNull() {
            addCriterion("need_check_update is null");
            return (Criteria) this;
        }

        public Criteria andNeedCheckUpdateIsNotNull() {
            addCriterion("need_check_update is not null");
            return (Criteria) this;
        }

        public Criteria andNeedCheckUpdateEqualTo(Boolean value) {
            addCriterion("need_check_update =", value, "needCheckUpdate");
            return (Criteria) this;
        }

        public Criteria andNeedCheckUpdateNotEqualTo(Boolean value) {
            addCriterion("need_check_update <>", value, "needCheckUpdate");
            return (Criteria) this;
        }

        public Criteria andNeedCheckUpdateGreaterThan(Boolean value) {
            addCriterion("need_check_update >", value, "needCheckUpdate");
            return (Criteria) this;
        }

        public Criteria andNeedCheckUpdateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_check_update >=", value, "needCheckUpdate");
            return (Criteria) this;
        }

        public Criteria andNeedCheckUpdateLessThan(Boolean value) {
            addCriterion("need_check_update <", value, "needCheckUpdate");
            return (Criteria) this;
        }

        public Criteria andNeedCheckUpdateLessThanOrEqualTo(Boolean value) {
            addCriterion("need_check_update <=", value, "needCheckUpdate");
            return (Criteria) this;
        }

        public Criteria andNeedCheckUpdateIn(List<Boolean> values) {
            addCriterion("need_check_update in", values, "needCheckUpdate");
            return (Criteria) this;
        }

        public Criteria andNeedCheckUpdateNotIn(List<Boolean> values) {
            addCriterion("need_check_update not in", values, "needCheckUpdate");
            return (Criteria) this;
        }

        public Criteria andNeedCheckUpdateBetween(Boolean value1, Boolean value2) {
            addCriterion("need_check_update between", value1, value2, "needCheckUpdate");
            return (Criteria) this;
        }

        public Criteria andNeedCheckUpdateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_check_update not between", value1, value2, "needCheckUpdate");
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