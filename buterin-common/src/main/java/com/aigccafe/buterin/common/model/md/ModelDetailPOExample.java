package com.aigccafe.buterin.common.model.md;

import java.util.ArrayList;
import java.util.List;

public class ModelDetailPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModelDetailPOExample() {
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

        public Criteria andChnModelNameIsNull() {
            addCriterion("chn_model_name is null");
            return (Criteria) this;
        }

        public Criteria andChnModelNameIsNotNull() {
            addCriterion("chn_model_name is not null");
            return (Criteria) this;
        }

        public Criteria andChnModelNameEqualTo(String value) {
            addCriterion("chn_model_name =", value, "chnModelName");
            return (Criteria) this;
        }

        public Criteria andChnModelNameNotEqualTo(String value) {
            addCriterion("chn_model_name <>", value, "chnModelName");
            return (Criteria) this;
        }

        public Criteria andChnModelNameGreaterThan(String value) {
            addCriterion("chn_model_name >", value, "chnModelName");
            return (Criteria) this;
        }

        public Criteria andChnModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("chn_model_name >=", value, "chnModelName");
            return (Criteria) this;
        }

        public Criteria andChnModelNameLessThan(String value) {
            addCriterion("chn_model_name <", value, "chnModelName");
            return (Criteria) this;
        }

        public Criteria andChnModelNameLessThanOrEqualTo(String value) {
            addCriterion("chn_model_name <=", value, "chnModelName");
            return (Criteria) this;
        }

        public Criteria andChnModelNameLike(String value) {
            addCriterion("chn_model_name like", value, "chnModelName");
            return (Criteria) this;
        }

        public Criteria andChnModelNameNotLike(String value) {
            addCriterion("chn_model_name not like", value, "chnModelName");
            return (Criteria) this;
        }

        public Criteria andChnModelNameIn(List<String> values) {
            addCriterion("chn_model_name in", values, "chnModelName");
            return (Criteria) this;
        }

        public Criteria andChnModelNameNotIn(List<String> values) {
            addCriterion("chn_model_name not in", values, "chnModelName");
            return (Criteria) this;
        }

        public Criteria andChnModelNameBetween(String value1, String value2) {
            addCriterion("chn_model_name between", value1, value2, "chnModelName");
            return (Criteria) this;
        }

        public Criteria andChnModelNameNotBetween(String value1, String value2) {
            addCriterion("chn_model_name not between", value1, value2, "chnModelName");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andChnDescriptionIsNull() {
            addCriterion("chn_description is null");
            return (Criteria) this;
        }

        public Criteria andChnDescriptionIsNotNull() {
            addCriterion("chn_description is not null");
            return (Criteria) this;
        }

        public Criteria andChnDescriptionEqualTo(String value) {
            addCriterion("chn_description =", value, "chnDescription");
            return (Criteria) this;
        }

        public Criteria andChnDescriptionNotEqualTo(String value) {
            addCriterion("chn_description <>", value, "chnDescription");
            return (Criteria) this;
        }

        public Criteria andChnDescriptionGreaterThan(String value) {
            addCriterion("chn_description >", value, "chnDescription");
            return (Criteria) this;
        }

        public Criteria andChnDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("chn_description >=", value, "chnDescription");
            return (Criteria) this;
        }

        public Criteria andChnDescriptionLessThan(String value) {
            addCriterion("chn_description <", value, "chnDescription");
            return (Criteria) this;
        }

        public Criteria andChnDescriptionLessThanOrEqualTo(String value) {
            addCriterion("chn_description <=", value, "chnDescription");
            return (Criteria) this;
        }

        public Criteria andChnDescriptionLike(String value) {
            addCriterion("chn_description like", value, "chnDescription");
            return (Criteria) this;
        }

        public Criteria andChnDescriptionNotLike(String value) {
            addCriterion("chn_description not like", value, "chnDescription");
            return (Criteria) this;
        }

        public Criteria andChnDescriptionIn(List<String> values) {
            addCriterion("chn_description in", values, "chnDescription");
            return (Criteria) this;
        }

        public Criteria andChnDescriptionNotIn(List<String> values) {
            addCriterion("chn_description not in", values, "chnDescription");
            return (Criteria) this;
        }

        public Criteria andChnDescriptionBetween(String value1, String value2) {
            addCriterion("chn_description between", value1, value2, "chnDescription");
            return (Criteria) this;
        }

        public Criteria andChnDescriptionNotBetween(String value1, String value2) {
            addCriterion("chn_description not between", value1, value2, "chnDescription");
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

        public Criteria andAuthorNameIsNull() {
            addCriterion("author_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthorNameIsNotNull() {
            addCriterion("author_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorNameEqualTo(String value) {
            addCriterion("author_name =", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotEqualTo(String value) {
            addCriterion("author_name <>", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameGreaterThan(String value) {
            addCriterion("author_name >", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameGreaterThanOrEqualTo(String value) {
            addCriterion("author_name >=", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameLessThan(String value) {
            addCriterion("author_name <", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameLessThanOrEqualTo(String value) {
            addCriterion("author_name <=", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameLike(String value) {
            addCriterion("author_name like", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotLike(String value) {
            addCriterion("author_name not like", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameIn(List<String> values) {
            addCriterion("author_name in", values, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotIn(List<String> values) {
            addCriterion("author_name not in", values, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameBetween(String value1, String value2) {
            addCriterion("author_name between", value1, value2, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotBetween(String value1, String value2) {
            addCriterion("author_name not between", value1, value2, "authorName");
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

        public Criteria andTagsIsNull() {
            addCriterion("tags is null");
            return (Criteria) this;
        }

        public Criteria andTagsIsNotNull() {
            addCriterion("tags is not null");
            return (Criteria) this;
        }

        public Criteria andTagsEqualTo(String value) {
            addCriterion("tags =", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotEqualTo(String value) {
            addCriterion("tags <>", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThan(String value) {
            addCriterion("tags >", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThanOrEqualTo(String value) {
            addCriterion("tags >=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThan(String value) {
            addCriterion("tags <", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThanOrEqualTo(String value) {
            addCriterion("tags <=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLike(String value) {
            addCriterion("tags like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotLike(String value) {
            addCriterion("tags not like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsIn(List<String> values) {
            addCriterion("tags in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotIn(List<String> values) {
            addCriterion("tags not in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsBetween(String value1, String value2) {
            addCriterion("tags between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotBetween(String value1, String value2) {
            addCriterion("tags not between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andManualTagsIsNull() {
            addCriterion("manual_tags is null");
            return (Criteria) this;
        }

        public Criteria andManualTagsIsNotNull() {
            addCriterion("manual_tags is not null");
            return (Criteria) this;
        }

        public Criteria andManualTagsEqualTo(String value) {
            addCriterion("manual_tags =", value, "manualTags");
            return (Criteria) this;
        }

        public Criteria andManualTagsNotEqualTo(String value) {
            addCriterion("manual_tags <>", value, "manualTags");
            return (Criteria) this;
        }

        public Criteria andManualTagsGreaterThan(String value) {
            addCriterion("manual_tags >", value, "manualTags");
            return (Criteria) this;
        }

        public Criteria andManualTagsGreaterThanOrEqualTo(String value) {
            addCriterion("manual_tags >=", value, "manualTags");
            return (Criteria) this;
        }

        public Criteria andManualTagsLessThan(String value) {
            addCriterion("manual_tags <", value, "manualTags");
            return (Criteria) this;
        }

        public Criteria andManualTagsLessThanOrEqualTo(String value) {
            addCriterion("manual_tags <=", value, "manualTags");
            return (Criteria) this;
        }

        public Criteria andManualTagsLike(String value) {
            addCriterion("manual_tags like", value, "manualTags");
            return (Criteria) this;
        }

        public Criteria andManualTagsNotLike(String value) {
            addCriterion("manual_tags not like", value, "manualTags");
            return (Criteria) this;
        }

        public Criteria andManualTagsIn(List<String> values) {
            addCriterion("manual_tags in", values, "manualTags");
            return (Criteria) this;
        }

        public Criteria andManualTagsNotIn(List<String> values) {
            addCriterion("manual_tags not in", values, "manualTags");
            return (Criteria) this;
        }

        public Criteria andManualTagsBetween(String value1, String value2) {
            addCriterion("manual_tags between", value1, value2, "manualTags");
            return (Criteria) this;
        }

        public Criteria andManualTagsNotBetween(String value1, String value2) {
            addCriterion("manual_tags not between", value1, value2, "manualTags");
            return (Criteria) this;
        }

        public Criteria andCoverPathIsNull() {
            addCriterion("cover_path is null");
            return (Criteria) this;
        }

        public Criteria andCoverPathIsNotNull() {
            addCriterion("cover_path is not null");
            return (Criteria) this;
        }

        public Criteria andCoverPathEqualTo(String value) {
            addCriterion("cover_path =", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotEqualTo(String value) {
            addCriterion("cover_path <>", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathGreaterThan(String value) {
            addCriterion("cover_path >", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathGreaterThanOrEqualTo(String value) {
            addCriterion("cover_path >=", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathLessThan(String value) {
            addCriterion("cover_path <", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathLessThanOrEqualTo(String value) {
            addCriterion("cover_path <=", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathLike(String value) {
            addCriterion("cover_path like", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotLike(String value) {
            addCriterion("cover_path not like", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathIn(List<String> values) {
            addCriterion("cover_path in", values, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotIn(List<String> values) {
            addCriterion("cover_path not in", values, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathBetween(String value1, String value2) {
            addCriterion("cover_path between", value1, value2, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotBetween(String value1, String value2) {
            addCriterion("cover_path not between", value1, value2, "coverPath");
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