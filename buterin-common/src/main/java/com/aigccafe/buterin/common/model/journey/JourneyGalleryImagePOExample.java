package com.aigccafe.buterin.common.model.journey;

import java.util.ArrayList;
import java.util.List;

public class JourneyGalleryImagePOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JourneyGalleryImagePOExample() {
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

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNull() {
            addCriterion("image_id is null");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNotNull() {
            addCriterion("image_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageIdEqualTo(String value) {
            addCriterion("image_id =", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotEqualTo(String value) {
            addCriterion("image_id <>", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThan(String value) {
            addCriterion("image_id >", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThanOrEqualTo(String value) {
            addCriterion("image_id >=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThan(String value) {
            addCriterion("image_id <", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThanOrEqualTo(String value) {
            addCriterion("image_id <=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLike(String value) {
            addCriterion("image_id like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotLike(String value) {
            addCriterion("image_id not like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdIn(List<String> values) {
            addCriterion("image_id in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotIn(List<String> values) {
            addCriterion("image_id not in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdBetween(String value1, String value2) {
            addCriterion("image_id between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotBetween(String value1, String value2) {
            addCriterion("image_id not between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andPromptIsNull() {
            addCriterion("prompt is null");
            return (Criteria) this;
        }

        public Criteria andPromptIsNotNull() {
            addCriterion("prompt is not null");
            return (Criteria) this;
        }

        public Criteria andPromptEqualTo(String value) {
            addCriterion("prompt =", value, "prompt");
            return (Criteria) this;
        }

        public Criteria andPromptNotEqualTo(String value) {
            addCriterion("prompt <>", value, "prompt");
            return (Criteria) this;
        }

        public Criteria andPromptGreaterThan(String value) {
            addCriterion("prompt >", value, "prompt");
            return (Criteria) this;
        }

        public Criteria andPromptGreaterThanOrEqualTo(String value) {
            addCriterion("prompt >=", value, "prompt");
            return (Criteria) this;
        }

        public Criteria andPromptLessThan(String value) {
            addCriterion("prompt <", value, "prompt");
            return (Criteria) this;
        }

        public Criteria andPromptLessThanOrEqualTo(String value) {
            addCriterion("prompt <=", value, "prompt");
            return (Criteria) this;
        }

        public Criteria andPromptLike(String value) {
            addCriterion("prompt like", value, "prompt");
            return (Criteria) this;
        }

        public Criteria andPromptNotLike(String value) {
            addCriterion("prompt not like", value, "prompt");
            return (Criteria) this;
        }

        public Criteria andPromptIn(List<String> values) {
            addCriterion("prompt in", values, "prompt");
            return (Criteria) this;
        }

        public Criteria andPromptNotIn(List<String> values) {
            addCriterion("prompt not in", values, "prompt");
            return (Criteria) this;
        }

        public Criteria andPromptBetween(String value1, String value2) {
            addCriterion("prompt between", value1, value2, "prompt");
            return (Criteria) this;
        }

        public Criteria andPromptNotBetween(String value1, String value2) {
            addCriterion("prompt not between", value1, value2, "prompt");
            return (Criteria) this;
        }

        public Criteria andCnPromptIsNull() {
            addCriterion("cn_prompt is null");
            return (Criteria) this;
        }

        public Criteria andCnPromptIsNotNull() {
            addCriterion("cn_prompt is not null");
            return (Criteria) this;
        }

        public Criteria andCnPromptEqualTo(String value) {
            addCriterion("cn_prompt =", value, "cnPrompt");
            return (Criteria) this;
        }

        public Criteria andCnPromptNotEqualTo(String value) {
            addCriterion("cn_prompt <>", value, "cnPrompt");
            return (Criteria) this;
        }

        public Criteria andCnPromptGreaterThan(String value) {
            addCriterion("cn_prompt >", value, "cnPrompt");
            return (Criteria) this;
        }

        public Criteria andCnPromptGreaterThanOrEqualTo(String value) {
            addCriterion("cn_prompt >=", value, "cnPrompt");
            return (Criteria) this;
        }

        public Criteria andCnPromptLessThan(String value) {
            addCriterion("cn_prompt <", value, "cnPrompt");
            return (Criteria) this;
        }

        public Criteria andCnPromptLessThanOrEqualTo(String value) {
            addCriterion("cn_prompt <=", value, "cnPrompt");
            return (Criteria) this;
        }

        public Criteria andCnPromptLike(String value) {
            addCriterion("cn_prompt like", value, "cnPrompt");
            return (Criteria) this;
        }

        public Criteria andCnPromptNotLike(String value) {
            addCriterion("cn_prompt not like", value, "cnPrompt");
            return (Criteria) this;
        }

        public Criteria andCnPromptIn(List<String> values) {
            addCriterion("cn_prompt in", values, "cnPrompt");
            return (Criteria) this;
        }

        public Criteria andCnPromptNotIn(List<String> values) {
            addCriterion("cn_prompt not in", values, "cnPrompt");
            return (Criteria) this;
        }

        public Criteria andCnPromptBetween(String value1, String value2) {
            addCriterion("cn_prompt between", value1, value2, "cnPrompt");
            return (Criteria) this;
        }

        public Criteria andCnPromptNotBetween(String value1, String value2) {
            addCriterion("cn_prompt not between", value1, value2, "cnPrompt");
            return (Criteria) this;
        }

        public Criteria andImagePathIsNull() {
            addCriterion("image_path is null");
            return (Criteria) this;
        }

        public Criteria andImagePathIsNotNull() {
            addCriterion("image_path is not null");
            return (Criteria) this;
        }

        public Criteria andImagePathEqualTo(String value) {
            addCriterion("image_path =", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotEqualTo(String value) {
            addCriterion("image_path <>", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThan(String value) {
            addCriterion("image_path >", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThanOrEqualTo(String value) {
            addCriterion("image_path >=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThan(String value) {
            addCriterion("image_path <", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThanOrEqualTo(String value) {
            addCriterion("image_path <=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLike(String value) {
            addCriterion("image_path like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotLike(String value) {
            addCriterion("image_path not like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathIn(List<String> values) {
            addCriterion("image_path in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotIn(List<String> values) {
            addCriterion("image_path not in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathBetween(String value1, String value2) {
            addCriterion("image_path between", value1, value2, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotBetween(String value1, String value2) {
            addCriterion("image_path not between", value1, value2, "imagePath");
            return (Criteria) this;
        }

        public Criteria andRawImagePathIsNull() {
            addCriterion("raw_image_path is null");
            return (Criteria) this;
        }

        public Criteria andRawImagePathIsNotNull() {
            addCriterion("raw_image_path is not null");
            return (Criteria) this;
        }

        public Criteria andRawImagePathEqualTo(String value) {
            addCriterion("raw_image_path =", value, "rawImagePath");
            return (Criteria) this;
        }

        public Criteria andRawImagePathNotEqualTo(String value) {
            addCriterion("raw_image_path <>", value, "rawImagePath");
            return (Criteria) this;
        }

        public Criteria andRawImagePathGreaterThan(String value) {
            addCriterion("raw_image_path >", value, "rawImagePath");
            return (Criteria) this;
        }

        public Criteria andRawImagePathGreaterThanOrEqualTo(String value) {
            addCriterion("raw_image_path >=", value, "rawImagePath");
            return (Criteria) this;
        }

        public Criteria andRawImagePathLessThan(String value) {
            addCriterion("raw_image_path <", value, "rawImagePath");
            return (Criteria) this;
        }

        public Criteria andRawImagePathLessThanOrEqualTo(String value) {
            addCriterion("raw_image_path <=", value, "rawImagePath");
            return (Criteria) this;
        }

        public Criteria andRawImagePathLike(String value) {
            addCriterion("raw_image_path like", value, "rawImagePath");
            return (Criteria) this;
        }

        public Criteria andRawImagePathNotLike(String value) {
            addCriterion("raw_image_path not like", value, "rawImagePath");
            return (Criteria) this;
        }

        public Criteria andRawImagePathIn(List<String> values) {
            addCriterion("raw_image_path in", values, "rawImagePath");
            return (Criteria) this;
        }

        public Criteria andRawImagePathNotIn(List<String> values) {
            addCriterion("raw_image_path not in", values, "rawImagePath");
            return (Criteria) this;
        }

        public Criteria andRawImagePathBetween(String value1, String value2) {
            addCriterion("raw_image_path between", value1, value2, "rawImagePath");
            return (Criteria) this;
        }

        public Criteria andRawImagePathNotBetween(String value1, String value2) {
            addCriterion("raw_image_path not between", value1, value2, "rawImagePath");
            return (Criteria) this;
        }

        public Criteria andMidImageUrlIsNull() {
            addCriterion("mid_image_url is null");
            return (Criteria) this;
        }

        public Criteria andMidImageUrlIsNotNull() {
            addCriterion("mid_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andMidImageUrlEqualTo(String value) {
            addCriterion("mid_image_url =", value, "midImageUrl");
            return (Criteria) this;
        }

        public Criteria andMidImageUrlNotEqualTo(String value) {
            addCriterion("mid_image_url <>", value, "midImageUrl");
            return (Criteria) this;
        }

        public Criteria andMidImageUrlGreaterThan(String value) {
            addCriterion("mid_image_url >", value, "midImageUrl");
            return (Criteria) this;
        }

        public Criteria andMidImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("mid_image_url >=", value, "midImageUrl");
            return (Criteria) this;
        }

        public Criteria andMidImageUrlLessThan(String value) {
            addCriterion("mid_image_url <", value, "midImageUrl");
            return (Criteria) this;
        }

        public Criteria andMidImageUrlLessThanOrEqualTo(String value) {
            addCriterion("mid_image_url <=", value, "midImageUrl");
            return (Criteria) this;
        }

        public Criteria andMidImageUrlLike(String value) {
            addCriterion("mid_image_url like", value, "midImageUrl");
            return (Criteria) this;
        }

        public Criteria andMidImageUrlNotLike(String value) {
            addCriterion("mid_image_url not like", value, "midImageUrl");
            return (Criteria) this;
        }

        public Criteria andMidImageUrlIn(List<String> values) {
            addCriterion("mid_image_url in", values, "midImageUrl");
            return (Criteria) this;
        }

        public Criteria andMidImageUrlNotIn(List<String> values) {
            addCriterion("mid_image_url not in", values, "midImageUrl");
            return (Criteria) this;
        }

        public Criteria andMidImageUrlBetween(String value1, String value2) {
            addCriterion("mid_image_url between", value1, value2, "midImageUrl");
            return (Criteria) this;
        }

        public Criteria andMidImageUrlNotBetween(String value1, String value2) {
            addCriterion("mid_image_url not between", value1, value2, "midImageUrl");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andViewCntIsNull() {
            addCriterion("view_cnt is null");
            return (Criteria) this;
        }

        public Criteria andViewCntIsNotNull() {
            addCriterion("view_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andViewCntEqualTo(Integer value) {
            addCriterion("view_cnt =", value, "viewCnt");
            return (Criteria) this;
        }

        public Criteria andViewCntNotEqualTo(Integer value) {
            addCriterion("view_cnt <>", value, "viewCnt");
            return (Criteria) this;
        }

        public Criteria andViewCntGreaterThan(Integer value) {
            addCriterion("view_cnt >", value, "viewCnt");
            return (Criteria) this;
        }

        public Criteria andViewCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("view_cnt >=", value, "viewCnt");
            return (Criteria) this;
        }

        public Criteria andViewCntLessThan(Integer value) {
            addCriterion("view_cnt <", value, "viewCnt");
            return (Criteria) this;
        }

        public Criteria andViewCntLessThanOrEqualTo(Integer value) {
            addCriterion("view_cnt <=", value, "viewCnt");
            return (Criteria) this;
        }

        public Criteria andViewCntIn(List<Integer> values) {
            addCriterion("view_cnt in", values, "viewCnt");
            return (Criteria) this;
        }

        public Criteria andViewCntNotIn(List<Integer> values) {
            addCriterion("view_cnt not in", values, "viewCnt");
            return (Criteria) this;
        }

        public Criteria andViewCntBetween(Integer value1, Integer value2) {
            addCriterion("view_cnt between", value1, value2, "viewCnt");
            return (Criteria) this;
        }

        public Criteria andViewCntNotBetween(Integer value1, Integer value2) {
            addCriterion("view_cnt not between", value1, value2, "viewCnt");
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