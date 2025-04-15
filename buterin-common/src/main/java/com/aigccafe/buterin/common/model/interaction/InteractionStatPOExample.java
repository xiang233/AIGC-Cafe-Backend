package com.aigccafe.buterin.common.model.interaction;

import java.util.ArrayList;
import java.util.List;

public class InteractionStatPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InteractionStatPOExample() {
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

        public Criteria andTargetTypeIsNull() {
            addCriterion("target_type is null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIsNotNull() {
            addCriterion("target_type is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeEqualTo(String value) {
            addCriterion("target_type =", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotEqualTo(String value) {
            addCriterion("target_type <>", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThan(String value) {
            addCriterion("target_type >", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("target_type >=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThan(String value) {
            addCriterion("target_type <", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThanOrEqualTo(String value) {
            addCriterion("target_type <=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLike(String value) {
            addCriterion("target_type like", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotLike(String value) {
            addCriterion("target_type not like", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIn(List<String> values) {
            addCriterion("target_type in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotIn(List<String> values) {
            addCriterion("target_type not in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeBetween(String value1, String value2) {
            addCriterion("target_type between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotBetween(String value1, String value2) {
            addCriterion("target_type not between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNull() {
            addCriterion("target_id is null");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNotNull() {
            addCriterion("target_id is not null");
            return (Criteria) this;
        }

        public Criteria andTargetIdEqualTo(Long value) {
            addCriterion("target_id =", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotEqualTo(Long value) {
            addCriterion("target_id <>", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThan(Long value) {
            addCriterion("target_id >", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThanOrEqualTo(Long value) {
            addCriterion("target_id >=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThan(Long value) {
            addCriterion("target_id <", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThanOrEqualTo(Long value) {
            addCriterion("target_id <=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdIn(List<Long> values) {
            addCriterion("target_id in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotIn(List<Long> values) {
            addCriterion("target_id not in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdBetween(Long value1, Long value2) {
            addCriterion("target_id between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotBetween(Long value1, Long value2) {
            addCriterion("target_id not between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNull() {
            addCriterion("like_count is null");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNotNull() {
            addCriterion("like_count is not null");
            return (Criteria) this;
        }

        public Criteria andLikeCountEqualTo(Long value) {
            addCriterion("like_count =", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotEqualTo(Long value) {
            addCriterion("like_count <>", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThan(Long value) {
            addCriterion("like_count >", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThanOrEqualTo(Long value) {
            addCriterion("like_count >=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThan(Long value) {
            addCriterion("like_count <", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThanOrEqualTo(Long value) {
            addCriterion("like_count <=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountIn(List<Long> values) {
            addCriterion("like_count in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotIn(List<Long> values) {
            addCriterion("like_count not in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountBetween(Long value1, Long value2) {
            addCriterion("like_count between", value1, value2, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotBetween(Long value1, Long value2) {
            addCriterion("like_count not between", value1, value2, "likeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountIsNull() {
            addCriterion("store_count is null");
            return (Criteria) this;
        }

        public Criteria andStoreCountIsNotNull() {
            addCriterion("store_count is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCountEqualTo(Long value) {
            addCriterion("store_count =", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountNotEqualTo(Long value) {
            addCriterion("store_count <>", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountGreaterThan(Long value) {
            addCriterion("store_count >", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountGreaterThanOrEqualTo(Long value) {
            addCriterion("store_count >=", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountLessThan(Long value) {
            addCriterion("store_count <", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountLessThanOrEqualTo(Long value) {
            addCriterion("store_count <=", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountIn(List<Long> values) {
            addCriterion("store_count in", values, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountNotIn(List<Long> values) {
            addCriterion("store_count not in", values, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountBetween(Long value1, Long value2) {
            addCriterion("store_count between", value1, value2, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountNotBetween(Long value1, Long value2) {
            addCriterion("store_count not between", value1, value2, "storeCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Long value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Long value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Long value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Long value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Long value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Long> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Long> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Long value1, Long value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Long value1, Long value2) {
            addCriterion("comment_count not between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountIsNull() {
            addCriterion("download_count is null");
            return (Criteria) this;
        }

        public Criteria andDownloadCountIsNotNull() {
            addCriterion("download_count is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadCountEqualTo(Long value) {
            addCriterion("download_count =", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountNotEqualTo(Long value) {
            addCriterion("download_count <>", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountGreaterThan(Long value) {
            addCriterion("download_count >", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountGreaterThanOrEqualTo(Long value) {
            addCriterion("download_count >=", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountLessThan(Long value) {
            addCriterion("download_count <", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountLessThanOrEqualTo(Long value) {
            addCriterion("download_count <=", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountIn(List<Long> values) {
            addCriterion("download_count in", values, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountNotIn(List<Long> values) {
            addCriterion("download_count not in", values, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountBetween(Long value1, Long value2) {
            addCriterion("download_count between", value1, value2, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountNotBetween(Long value1, Long value2) {
            addCriterion("download_count not between", value1, value2, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andScoreCountIsNull() {
            addCriterion("score_count is null");
            return (Criteria) this;
        }

        public Criteria andScoreCountIsNotNull() {
            addCriterion("score_count is not null");
            return (Criteria) this;
        }

        public Criteria andScoreCountEqualTo(Long value) {
            addCriterion("score_count =", value, "scoreCount");
            return (Criteria) this;
        }

        public Criteria andScoreCountNotEqualTo(Long value) {
            addCriterion("score_count <>", value, "scoreCount");
            return (Criteria) this;
        }

        public Criteria andScoreCountGreaterThan(Long value) {
            addCriterion("score_count >", value, "scoreCount");
            return (Criteria) this;
        }

        public Criteria andScoreCountGreaterThanOrEqualTo(Long value) {
            addCriterion("score_count >=", value, "scoreCount");
            return (Criteria) this;
        }

        public Criteria andScoreCountLessThan(Long value) {
            addCriterion("score_count <", value, "scoreCount");
            return (Criteria) this;
        }

        public Criteria andScoreCountLessThanOrEqualTo(Long value) {
            addCriterion("score_count <=", value, "scoreCount");
            return (Criteria) this;
        }

        public Criteria andScoreCountIn(List<Long> values) {
            addCriterion("score_count in", values, "scoreCount");
            return (Criteria) this;
        }

        public Criteria andScoreCountNotIn(List<Long> values) {
            addCriterion("score_count not in", values, "scoreCount");
            return (Criteria) this;
        }

        public Criteria andScoreCountBetween(Long value1, Long value2) {
            addCriterion("score_count between", value1, value2, "scoreCount");
            return (Criteria) this;
        }

        public Criteria andScoreCountNotBetween(Long value1, Long value2) {
            addCriterion("score_count not between", value1, value2, "scoreCount");
            return (Criteria) this;
        }

        public Criteria andScoreSumIsNull() {
            addCriterion("score_sum is null");
            return (Criteria) this;
        }

        public Criteria andScoreSumIsNotNull() {
            addCriterion("score_sum is not null");
            return (Criteria) this;
        }

        public Criteria andScoreSumEqualTo(Double value) {
            addCriterion("score_sum =", value, "scoreSum");
            return (Criteria) this;
        }

        public Criteria andScoreSumNotEqualTo(Double value) {
            addCriterion("score_sum <>", value, "scoreSum");
            return (Criteria) this;
        }

        public Criteria andScoreSumGreaterThan(Double value) {
            addCriterion("score_sum >", value, "scoreSum");
            return (Criteria) this;
        }

        public Criteria andScoreSumGreaterThanOrEqualTo(Double value) {
            addCriterion("score_sum >=", value, "scoreSum");
            return (Criteria) this;
        }

        public Criteria andScoreSumLessThan(Double value) {
            addCriterion("score_sum <", value, "scoreSum");
            return (Criteria) this;
        }

        public Criteria andScoreSumLessThanOrEqualTo(Double value) {
            addCriterion("score_sum <=", value, "scoreSum");
            return (Criteria) this;
        }

        public Criteria andScoreSumIn(List<Double> values) {
            addCriterion("score_sum in", values, "scoreSum");
            return (Criteria) this;
        }

        public Criteria andScoreSumNotIn(List<Double> values) {
            addCriterion("score_sum not in", values, "scoreSum");
            return (Criteria) this;
        }

        public Criteria andScoreSumBetween(Double value1, Double value2) {
            addCriterion("score_sum between", value1, value2, "scoreSum");
            return (Criteria) this;
        }

        public Criteria andScoreSumNotBetween(Double value1, Double value2) {
            addCriterion("score_sum not between", value1, value2, "scoreSum");
            return (Criteria) this;
        }

        public Criteria andAgreeCountIsNull() {
            addCriterion("agree_count is null");
            return (Criteria) this;
        }

        public Criteria andAgreeCountIsNotNull() {
            addCriterion("agree_count is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeCountEqualTo(Long value) {
            addCriterion("agree_count =", value, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountNotEqualTo(Long value) {
            addCriterion("agree_count <>", value, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountGreaterThan(Long value) {
            addCriterion("agree_count >", value, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountGreaterThanOrEqualTo(Long value) {
            addCriterion("agree_count >=", value, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountLessThan(Long value) {
            addCriterion("agree_count <", value, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountLessThanOrEqualTo(Long value) {
            addCriterion("agree_count <=", value, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountIn(List<Long> values) {
            addCriterion("agree_count in", values, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountNotIn(List<Long> values) {
            addCriterion("agree_count not in", values, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountBetween(Long value1, Long value2) {
            addCriterion("agree_count between", value1, value2, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountNotBetween(Long value1, Long value2) {
            addCriterion("agree_count not between", value1, value2, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andDisagreeCountIsNull() {
            addCriterion("disagree_count is null");
            return (Criteria) this;
        }

        public Criteria andDisagreeCountIsNotNull() {
            addCriterion("disagree_count is not null");
            return (Criteria) this;
        }

        public Criteria andDisagreeCountEqualTo(Long value) {
            addCriterion("disagree_count =", value, "disagreeCount");
            return (Criteria) this;
        }

        public Criteria andDisagreeCountNotEqualTo(Long value) {
            addCriterion("disagree_count <>", value, "disagreeCount");
            return (Criteria) this;
        }

        public Criteria andDisagreeCountGreaterThan(Long value) {
            addCriterion("disagree_count >", value, "disagreeCount");
            return (Criteria) this;
        }

        public Criteria andDisagreeCountGreaterThanOrEqualTo(Long value) {
            addCriterion("disagree_count >=", value, "disagreeCount");
            return (Criteria) this;
        }

        public Criteria andDisagreeCountLessThan(Long value) {
            addCriterion("disagree_count <", value, "disagreeCount");
            return (Criteria) this;
        }

        public Criteria andDisagreeCountLessThanOrEqualTo(Long value) {
            addCriterion("disagree_count <=", value, "disagreeCount");
            return (Criteria) this;
        }

        public Criteria andDisagreeCountIn(List<Long> values) {
            addCriterion("disagree_count in", values, "disagreeCount");
            return (Criteria) this;
        }

        public Criteria andDisagreeCountNotIn(List<Long> values) {
            addCriterion("disagree_count not in", values, "disagreeCount");
            return (Criteria) this;
        }

        public Criteria andDisagreeCountBetween(Long value1, Long value2) {
            addCriterion("disagree_count between", value1, value2, "disagreeCount");
            return (Criteria) this;
        }

        public Criteria andDisagreeCountNotBetween(Long value1, Long value2) {
            addCriterion("disagree_count not between", value1, value2, "disagreeCount");
            return (Criteria) this;
        }

        public Criteria andSupportCountIsNull() {
            addCriterion("support_count is null");
            return (Criteria) this;
        }

        public Criteria andSupportCountIsNotNull() {
            addCriterion("support_count is not null");
            return (Criteria) this;
        }

        public Criteria andSupportCountEqualTo(Long value) {
            addCriterion("support_count =", value, "supportCount");
            return (Criteria) this;
        }

        public Criteria andSupportCountNotEqualTo(Long value) {
            addCriterion("support_count <>", value, "supportCount");
            return (Criteria) this;
        }

        public Criteria andSupportCountGreaterThan(Long value) {
            addCriterion("support_count >", value, "supportCount");
            return (Criteria) this;
        }

        public Criteria andSupportCountGreaterThanOrEqualTo(Long value) {
            addCriterion("support_count >=", value, "supportCount");
            return (Criteria) this;
        }

        public Criteria andSupportCountLessThan(Long value) {
            addCriterion("support_count <", value, "supportCount");
            return (Criteria) this;
        }

        public Criteria andSupportCountLessThanOrEqualTo(Long value) {
            addCriterion("support_count <=", value, "supportCount");
            return (Criteria) this;
        }

        public Criteria andSupportCountIn(List<Long> values) {
            addCriterion("support_count in", values, "supportCount");
            return (Criteria) this;
        }

        public Criteria andSupportCountNotIn(List<Long> values) {
            addCriterion("support_count not in", values, "supportCount");
            return (Criteria) this;
        }

        public Criteria andSupportCountBetween(Long value1, Long value2) {
            addCriterion("support_count between", value1, value2, "supportCount");
            return (Criteria) this;
        }

        public Criteria andSupportCountNotBetween(Long value1, Long value2) {
            addCriterion("support_count not between", value1, value2, "supportCount");
            return (Criteria) this;
        }

        public Criteria andUnSupportCountIsNull() {
            addCriterion("un_support_count is null");
            return (Criteria) this;
        }

        public Criteria andUnSupportCountIsNotNull() {
            addCriterion("un_support_count is not null");
            return (Criteria) this;
        }

        public Criteria andUnSupportCountEqualTo(Long value) {
            addCriterion("un_support_count =", value, "unSupportCount");
            return (Criteria) this;
        }

        public Criteria andUnSupportCountNotEqualTo(Long value) {
            addCriterion("un_support_count <>", value, "unSupportCount");
            return (Criteria) this;
        }

        public Criteria andUnSupportCountGreaterThan(Long value) {
            addCriterion("un_support_count >", value, "unSupportCount");
            return (Criteria) this;
        }

        public Criteria andUnSupportCountGreaterThanOrEqualTo(Long value) {
            addCriterion("un_support_count >=", value, "unSupportCount");
            return (Criteria) this;
        }

        public Criteria andUnSupportCountLessThan(Long value) {
            addCriterion("un_support_count <", value, "unSupportCount");
            return (Criteria) this;
        }

        public Criteria andUnSupportCountLessThanOrEqualTo(Long value) {
            addCriterion("un_support_count <=", value, "unSupportCount");
            return (Criteria) this;
        }

        public Criteria andUnSupportCountIn(List<Long> values) {
            addCriterion("un_support_count in", values, "unSupportCount");
            return (Criteria) this;
        }

        public Criteria andUnSupportCountNotIn(List<Long> values) {
            addCriterion("un_support_count not in", values, "unSupportCount");
            return (Criteria) this;
        }

        public Criteria andUnSupportCountBetween(Long value1, Long value2) {
            addCriterion("un_support_count between", value1, value2, "unSupportCount");
            return (Criteria) this;
        }

        public Criteria andUnSupportCountNotBetween(Long value1, Long value2) {
            addCriterion("un_support_count not between", value1, value2, "unSupportCount");
            return (Criteria) this;
        }

        public Criteria andViewCountIsNull() {
            addCriterion("view_count is null");
            return (Criteria) this;
        }

        public Criteria andViewCountIsNotNull() {
            addCriterion("view_count is not null");
            return (Criteria) this;
        }

        public Criteria andViewCountEqualTo(Long value) {
            addCriterion("view_count =", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotEqualTo(Long value) {
            addCriterion("view_count <>", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThan(Long value) {
            addCriterion("view_count >", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThanOrEqualTo(Long value) {
            addCriterion("view_count >=", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThan(Long value) {
            addCriterion("view_count <", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThanOrEqualTo(Long value) {
            addCriterion("view_count <=", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountIn(List<Long> values) {
            addCriterion("view_count in", values, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotIn(List<Long> values) {
            addCriterion("view_count not in", values, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountBetween(Long value1, Long value2) {
            addCriterion("view_count between", value1, value2, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotBetween(Long value1, Long value2) {
            addCriterion("view_count not between", value1, value2, "viewCount");
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