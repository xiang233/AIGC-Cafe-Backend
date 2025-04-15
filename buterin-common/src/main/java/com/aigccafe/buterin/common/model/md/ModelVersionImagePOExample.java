package com.aigccafe.buterin.common.model.md;

import java.util.ArrayList;
import java.util.List;

public class ModelVersionImagePOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModelVersionImagePOExample() {
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

        public Criteria andVersionIdIsNull() {
            addCriterion("version_id is null");
            return (Criteria) this;
        }

        public Criteria andVersionIdIsNotNull() {
            addCriterion("version_id is not null");
            return (Criteria) this;
        }

        public Criteria andVersionIdEqualTo(Long value) {
            addCriterion("version_id =", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdNotEqualTo(Long value) {
            addCriterion("version_id <>", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdGreaterThan(Long value) {
            addCriterion("version_id >", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("version_id >=", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdLessThan(Long value) {
            addCriterion("version_id <", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdLessThanOrEqualTo(Long value) {
            addCriterion("version_id <=", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdIn(List<Long> values) {
            addCriterion("version_id in", values, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdNotIn(List<Long> values) {
            addCriterion("version_id not in", values, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdBetween(Long value1, Long value2) {
            addCriterion("version_id between", value1, value2, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdNotBetween(Long value1, Long value2) {
            addCriterion("version_id not between", value1, value2, "versionId");
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

        public Criteria andOriImageIdIsNull() {
            addCriterion("ori_image_id is null");
            return (Criteria) this;
        }

        public Criteria andOriImageIdIsNotNull() {
            addCriterion("ori_image_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriImageIdEqualTo(Long value) {
            addCriterion("ori_image_id =", value, "oriImageId");
            return (Criteria) this;
        }

        public Criteria andOriImageIdNotEqualTo(Long value) {
            addCriterion("ori_image_id <>", value, "oriImageId");
            return (Criteria) this;
        }

        public Criteria andOriImageIdGreaterThan(Long value) {
            addCriterion("ori_image_id >", value, "oriImageId");
            return (Criteria) this;
        }

        public Criteria andOriImageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ori_image_id >=", value, "oriImageId");
            return (Criteria) this;
        }

        public Criteria andOriImageIdLessThan(Long value) {
            addCriterion("ori_image_id <", value, "oriImageId");
            return (Criteria) this;
        }

        public Criteria andOriImageIdLessThanOrEqualTo(Long value) {
            addCriterion("ori_image_id <=", value, "oriImageId");
            return (Criteria) this;
        }

        public Criteria andOriImageIdIn(List<Long> values) {
            addCriterion("ori_image_id in", values, "oriImageId");
            return (Criteria) this;
        }

        public Criteria andOriImageIdNotIn(List<Long> values) {
            addCriterion("ori_image_id not in", values, "oriImageId");
            return (Criteria) this;
        }

        public Criteria andOriImageIdBetween(Long value1, Long value2) {
            addCriterion("ori_image_id between", value1, value2, "oriImageId");
            return (Criteria) this;
        }

        public Criteria andOriImageIdNotBetween(Long value1, Long value2) {
            addCriterion("ori_image_id not between", value1, value2, "oriImageId");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
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

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(Integer value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(Integer value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(Integer value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(Integer value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(Integer value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<Integer> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<Integer> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(Integer value1, Integer value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Integer value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Integer value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Integer value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Integer value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Integer value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Integer> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Integer> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Integer value1, Integer value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andMimetypeIsNull() {
            addCriterion("mimeType is null");
            return (Criteria) this;
        }

        public Criteria andMimetypeIsNotNull() {
            addCriterion("mimeType is not null");
            return (Criteria) this;
        }

        public Criteria andMimetypeEqualTo(String value) {
            addCriterion("mimeType =", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeNotEqualTo(String value) {
            addCriterion("mimeType <>", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeGreaterThan(String value) {
            addCriterion("mimeType >", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeGreaterThanOrEqualTo(String value) {
            addCriterion("mimeType >=", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeLessThan(String value) {
            addCriterion("mimeType <", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeLessThanOrEqualTo(String value) {
            addCriterion("mimeType <=", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeLike(String value) {
            addCriterion("mimeType like", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeNotLike(String value) {
            addCriterion("mimeType not like", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeIn(List<String> values) {
            addCriterion("mimeType in", values, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeNotIn(List<String> values) {
            addCriterion("mimeType not in", values, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeBetween(String value1, String value2) {
            addCriterion("mimeType between", value1, value2, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeNotBetween(String value1, String value2) {
            addCriterion("mimeType not between", value1, value2, "mimetype");
            return (Criteria) this;
        }

        public Criteria andRawPathIsNull() {
            addCriterion("raw_path is null");
            return (Criteria) this;
        }

        public Criteria andRawPathIsNotNull() {
            addCriterion("raw_path is not null");
            return (Criteria) this;
        }

        public Criteria andRawPathEqualTo(String value) {
            addCriterion("raw_path =", value, "rawPath");
            return (Criteria) this;
        }

        public Criteria andRawPathNotEqualTo(String value) {
            addCriterion("raw_path <>", value, "rawPath");
            return (Criteria) this;
        }

        public Criteria andRawPathGreaterThan(String value) {
            addCriterion("raw_path >", value, "rawPath");
            return (Criteria) this;
        }

        public Criteria andRawPathGreaterThanOrEqualTo(String value) {
            addCriterion("raw_path >=", value, "rawPath");
            return (Criteria) this;
        }

        public Criteria andRawPathLessThan(String value) {
            addCriterion("raw_path <", value, "rawPath");
            return (Criteria) this;
        }

        public Criteria andRawPathLessThanOrEqualTo(String value) {
            addCriterion("raw_path <=", value, "rawPath");
            return (Criteria) this;
        }

        public Criteria andRawPathLike(String value) {
            addCriterion("raw_path like", value, "rawPath");
            return (Criteria) this;
        }

        public Criteria andRawPathNotLike(String value) {
            addCriterion("raw_path not like", value, "rawPath");
            return (Criteria) this;
        }

        public Criteria andRawPathIn(List<String> values) {
            addCriterion("raw_path in", values, "rawPath");
            return (Criteria) this;
        }

        public Criteria andRawPathNotIn(List<String> values) {
            addCriterion("raw_path not in", values, "rawPath");
            return (Criteria) this;
        }

        public Criteria andRawPathBetween(String value1, String value2) {
            addCriterion("raw_path between", value1, value2, "rawPath");
            return (Criteria) this;
        }

        public Criteria andRawPathNotBetween(String value1, String value2) {
            addCriterion("raw_path not between", value1, value2, "rawPath");
            return (Criteria) this;
        }

        public Criteria andNormalPathIsNull() {
            addCriterion("normal_path is null");
            return (Criteria) this;
        }

        public Criteria andNormalPathIsNotNull() {
            addCriterion("normal_path is not null");
            return (Criteria) this;
        }

        public Criteria andNormalPathEqualTo(String value) {
            addCriterion("normal_path =", value, "normalPath");
            return (Criteria) this;
        }

        public Criteria andNormalPathNotEqualTo(String value) {
            addCriterion("normal_path <>", value, "normalPath");
            return (Criteria) this;
        }

        public Criteria andNormalPathGreaterThan(String value) {
            addCriterion("normal_path >", value, "normalPath");
            return (Criteria) this;
        }

        public Criteria andNormalPathGreaterThanOrEqualTo(String value) {
            addCriterion("normal_path >=", value, "normalPath");
            return (Criteria) this;
        }

        public Criteria andNormalPathLessThan(String value) {
            addCriterion("normal_path <", value, "normalPath");
            return (Criteria) this;
        }

        public Criteria andNormalPathLessThanOrEqualTo(String value) {
            addCriterion("normal_path <=", value, "normalPath");
            return (Criteria) this;
        }

        public Criteria andNormalPathLike(String value) {
            addCriterion("normal_path like", value, "normalPath");
            return (Criteria) this;
        }

        public Criteria andNormalPathNotLike(String value) {
            addCriterion("normal_path not like", value, "normalPath");
            return (Criteria) this;
        }

        public Criteria andNormalPathIn(List<String> values) {
            addCriterion("normal_path in", values, "normalPath");
            return (Criteria) this;
        }

        public Criteria andNormalPathNotIn(List<String> values) {
            addCriterion("normal_path not in", values, "normalPath");
            return (Criteria) this;
        }

        public Criteria andNormalPathBetween(String value1, String value2) {
            addCriterion("normal_path between", value1, value2, "normalPath");
            return (Criteria) this;
        }

        public Criteria andNormalPathNotBetween(String value1, String value2) {
            addCriterion("normal_path not between", value1, value2, "normalPath");
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