package com.aigccafe.buterin.common.model.journey;

import java.util.ArrayList;
import java.util.List;

public class JourneyTaskPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JourneyTaskPOExample() {
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

        public Criteria andSessionIdIsNull() {
            addCriterion("session_id is null");
            return (Criteria) this;
        }

        public Criteria andSessionIdIsNotNull() {
            addCriterion("session_id is not null");
            return (Criteria) this;
        }

        public Criteria andSessionIdEqualTo(Long value) {
            addCriterion("session_id =", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotEqualTo(Long value) {
            addCriterion("session_id <>", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdGreaterThan(Long value) {
            addCriterion("session_id >", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("session_id >=", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLessThan(Long value) {
            addCriterion("session_id <", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLessThanOrEqualTo(Long value) {
            addCriterion("session_id <=", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdIn(List<Long> values) {
            addCriterion("session_id in", values, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotIn(List<Long> values) {
            addCriterion("session_id not in", values, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdBetween(Long value1, Long value2) {
            addCriterion("session_id between", value1, value2, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotBetween(Long value1, Long value2) {
            addCriterion("session_id not between", value1, value2, "sessionId");
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

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(String value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(String value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(String value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(String value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(String value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(String value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLike(String value) {
            addCriterion("task_type like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotLike(String value) {
            addCriterion("task_type not like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<String> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<String> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(String value1, String value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(String value1, String value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andReferImageListIsNull() {
            addCriterion("refer_image_list is null");
            return (Criteria) this;
        }

        public Criteria andReferImageListIsNotNull() {
            addCriterion("refer_image_list is not null");
            return (Criteria) this;
        }

        public Criteria andReferImageListEqualTo(String value) {
            addCriterion("refer_image_list =", value, "referImageList");
            return (Criteria) this;
        }

        public Criteria andReferImageListNotEqualTo(String value) {
            addCriterion("refer_image_list <>", value, "referImageList");
            return (Criteria) this;
        }

        public Criteria andReferImageListGreaterThan(String value) {
            addCriterion("refer_image_list >", value, "referImageList");
            return (Criteria) this;
        }

        public Criteria andReferImageListGreaterThanOrEqualTo(String value) {
            addCriterion("refer_image_list >=", value, "referImageList");
            return (Criteria) this;
        }

        public Criteria andReferImageListLessThan(String value) {
            addCriterion("refer_image_list <", value, "referImageList");
            return (Criteria) this;
        }

        public Criteria andReferImageListLessThanOrEqualTo(String value) {
            addCriterion("refer_image_list <=", value, "referImageList");
            return (Criteria) this;
        }

        public Criteria andReferImageListLike(String value) {
            addCriterion("refer_image_list like", value, "referImageList");
            return (Criteria) this;
        }

        public Criteria andReferImageListNotLike(String value) {
            addCriterion("refer_image_list not like", value, "referImageList");
            return (Criteria) this;
        }

        public Criteria andReferImageListIn(List<String> values) {
            addCriterion("refer_image_list in", values, "referImageList");
            return (Criteria) this;
        }

        public Criteria andReferImageListNotIn(List<String> values) {
            addCriterion("refer_image_list not in", values, "referImageList");
            return (Criteria) this;
        }

        public Criteria andReferImageListBetween(String value1, String value2) {
            addCriterion("refer_image_list between", value1, value2, "referImageList");
            return (Criteria) this;
        }

        public Criteria andReferImageListNotBetween(String value1, String value2) {
            addCriterion("refer_image_list not between", value1, value2, "referImageList");
            return (Criteria) this;
        }

        public Criteria andImageIndexIsNull() {
            addCriterion("image_index is null");
            return (Criteria) this;
        }

        public Criteria andImageIndexIsNotNull() {
            addCriterion("image_index is not null");
            return (Criteria) this;
        }

        public Criteria andImageIndexEqualTo(Integer value) {
            addCriterion("image_index =", value, "imageIndex");
            return (Criteria) this;
        }

        public Criteria andImageIndexNotEqualTo(Integer value) {
            addCriterion("image_index <>", value, "imageIndex");
            return (Criteria) this;
        }

        public Criteria andImageIndexGreaterThan(Integer value) {
            addCriterion("image_index >", value, "imageIndex");
            return (Criteria) this;
        }

        public Criteria andImageIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_index >=", value, "imageIndex");
            return (Criteria) this;
        }

        public Criteria andImageIndexLessThan(Integer value) {
            addCriterion("image_index <", value, "imageIndex");
            return (Criteria) this;
        }

        public Criteria andImageIndexLessThanOrEqualTo(Integer value) {
            addCriterion("image_index <=", value, "imageIndex");
            return (Criteria) this;
        }

        public Criteria andImageIndexIn(List<Integer> values) {
            addCriterion("image_index in", values, "imageIndex");
            return (Criteria) this;
        }

        public Criteria andImageIndexNotIn(List<Integer> values) {
            addCriterion("image_index not in", values, "imageIndex");
            return (Criteria) this;
        }

        public Criteria andImageIndexBetween(Integer value1, Integer value2) {
            addCriterion("image_index between", value1, value2, "imageIndex");
            return (Criteria) this;
        }

        public Criteria andImageIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("image_index not between", value1, value2, "imageIndex");
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

        public Criteria andFatherTaskIdIsNull() {
            addCriterion("father_task_id is null");
            return (Criteria) this;
        }

        public Criteria andFatherTaskIdIsNotNull() {
            addCriterion("father_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andFatherTaskIdEqualTo(Long value) {
            addCriterion("father_task_id =", value, "fatherTaskId");
            return (Criteria) this;
        }

        public Criteria andFatherTaskIdNotEqualTo(Long value) {
            addCriterion("father_task_id <>", value, "fatherTaskId");
            return (Criteria) this;
        }

        public Criteria andFatherTaskIdGreaterThan(Long value) {
            addCriterion("father_task_id >", value, "fatherTaskId");
            return (Criteria) this;
        }

        public Criteria andFatherTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("father_task_id >=", value, "fatherTaskId");
            return (Criteria) this;
        }

        public Criteria andFatherTaskIdLessThan(Long value) {
            addCriterion("father_task_id <", value, "fatherTaskId");
            return (Criteria) this;
        }

        public Criteria andFatherTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("father_task_id <=", value, "fatherTaskId");
            return (Criteria) this;
        }

        public Criteria andFatherTaskIdIn(List<Long> values) {
            addCriterion("father_task_id in", values, "fatherTaskId");
            return (Criteria) this;
        }

        public Criteria andFatherTaskIdNotIn(List<Long> values) {
            addCriterion("father_task_id not in", values, "fatherTaskId");
            return (Criteria) this;
        }

        public Criteria andFatherTaskIdBetween(Long value1, Long value2) {
            addCriterion("father_task_id between", value1, value2, "fatherTaskId");
            return (Criteria) this;
        }

        public Criteria andFatherTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("father_task_id not between", value1, value2, "fatherTaskId");
            return (Criteria) this;
        }

        public Criteria andOriTaskIdIsNull() {
            addCriterion("ori_task_id is null");
            return (Criteria) this;
        }

        public Criteria andOriTaskIdIsNotNull() {
            addCriterion("ori_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriTaskIdEqualTo(String value) {
            addCriterion("ori_task_id =", value, "oriTaskId");
            return (Criteria) this;
        }

        public Criteria andOriTaskIdNotEqualTo(String value) {
            addCriterion("ori_task_id <>", value, "oriTaskId");
            return (Criteria) this;
        }

        public Criteria andOriTaskIdGreaterThan(String value) {
            addCriterion("ori_task_id >", value, "oriTaskId");
            return (Criteria) this;
        }

        public Criteria andOriTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("ori_task_id >=", value, "oriTaskId");
            return (Criteria) this;
        }

        public Criteria andOriTaskIdLessThan(String value) {
            addCriterion("ori_task_id <", value, "oriTaskId");
            return (Criteria) this;
        }

        public Criteria andOriTaskIdLessThanOrEqualTo(String value) {
            addCriterion("ori_task_id <=", value, "oriTaskId");
            return (Criteria) this;
        }

        public Criteria andOriTaskIdLike(String value) {
            addCriterion("ori_task_id like", value, "oriTaskId");
            return (Criteria) this;
        }

        public Criteria andOriTaskIdNotLike(String value) {
            addCriterion("ori_task_id not like", value, "oriTaskId");
            return (Criteria) this;
        }

        public Criteria andOriTaskIdIn(List<String> values) {
            addCriterion("ori_task_id in", values, "oriTaskId");
            return (Criteria) this;
        }

        public Criteria andOriTaskIdNotIn(List<String> values) {
            addCriterion("ori_task_id not in", values, "oriTaskId");
            return (Criteria) this;
        }

        public Criteria andOriTaskIdBetween(String value1, String value2) {
            addCriterion("ori_task_id between", value1, value2, "oriTaskId");
            return (Criteria) this;
        }

        public Criteria andOriTaskIdNotBetween(String value1, String value2) {
            addCriterion("ori_task_id not between", value1, value2, "oriTaskId");
            return (Criteria) this;
        }

        public Criteria andDimensionsIsNull() {
            addCriterion("dimensions is null");
            return (Criteria) this;
        }

        public Criteria andDimensionsIsNotNull() {
            addCriterion("dimensions is not null");
            return (Criteria) this;
        }

        public Criteria andDimensionsEqualTo(String value) {
            addCriterion("dimensions =", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsNotEqualTo(String value) {
            addCriterion("dimensions <>", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsGreaterThan(String value) {
            addCriterion("dimensions >", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsGreaterThanOrEqualTo(String value) {
            addCriterion("dimensions >=", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsLessThan(String value) {
            addCriterion("dimensions <", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsLessThanOrEqualTo(String value) {
            addCriterion("dimensions <=", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsLike(String value) {
            addCriterion("dimensions like", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsNotLike(String value) {
            addCriterion("dimensions not like", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsIn(List<String> values) {
            addCriterion("dimensions in", values, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsNotIn(List<String> values) {
            addCriterion("dimensions not in", values, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsBetween(String value1, String value2) {
            addCriterion("dimensions between", value1, value2, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsNotBetween(String value1, String value2) {
            addCriterion("dimensions not between", value1, value2, "dimensions");
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

        public Criteria andProgressIsNull() {
            addCriterion("progress is null");
            return (Criteria) this;
        }

        public Criteria andProgressIsNotNull() {
            addCriterion("progress is not null");
            return (Criteria) this;
        }

        public Criteria andProgressEqualTo(String value) {
            addCriterion("progress =", value, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressNotEqualTo(String value) {
            addCriterion("progress <>", value, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressGreaterThan(String value) {
            addCriterion("progress >", value, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressGreaterThanOrEqualTo(String value) {
            addCriterion("progress >=", value, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressLessThan(String value) {
            addCriterion("progress <", value, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressLessThanOrEqualTo(String value) {
            addCriterion("progress <=", value, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressLike(String value) {
            addCriterion("progress like", value, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressNotLike(String value) {
            addCriterion("progress not like", value, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressIn(List<String> values) {
            addCriterion("progress in", values, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressNotIn(List<String> values) {
            addCriterion("progress not in", values, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressBetween(String value1, String value2) {
            addCriterion("progress between", value1, value2, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressNotBetween(String value1, String value2) {
            addCriterion("progress not between", value1, value2, "progress");
            return (Criteria) this;
        }

        public Criteria andFailReasonIsNull() {
            addCriterion("fail_reason is null");
            return (Criteria) this;
        }

        public Criteria andFailReasonIsNotNull() {
            addCriterion("fail_reason is not null");
            return (Criteria) this;
        }

        public Criteria andFailReasonEqualTo(String value) {
            addCriterion("fail_reason =", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotEqualTo(String value) {
            addCriterion("fail_reason <>", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonGreaterThan(String value) {
            addCriterion("fail_reason >", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonGreaterThanOrEqualTo(String value) {
            addCriterion("fail_reason >=", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLessThan(String value) {
            addCriterion("fail_reason <", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLessThanOrEqualTo(String value) {
            addCriterion("fail_reason <=", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLike(String value) {
            addCriterion("fail_reason like", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotLike(String value) {
            addCriterion("fail_reason not like", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonIn(List<String> values) {
            addCriterion("fail_reason in", values, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotIn(List<String> values) {
            addCriterion("fail_reason not in", values, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonBetween(String value1, String value2) {
            addCriterion("fail_reason between", value1, value2, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotBetween(String value1, String value2) {
            addCriterion("fail_reason not between", value1, value2, "failReason");
            return (Criteria) this;
        }

        public Criteria andDImageUrlIsNull() {
            addCriterion("d_image_url is null");
            return (Criteria) this;
        }

        public Criteria andDImageUrlIsNotNull() {
            addCriterion("d_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andDImageUrlEqualTo(String value) {
            addCriterion("d_image_url =", value, "dImageUrl");
            return (Criteria) this;
        }

        public Criteria andDImageUrlNotEqualTo(String value) {
            addCriterion("d_image_url <>", value, "dImageUrl");
            return (Criteria) this;
        }

        public Criteria andDImageUrlGreaterThan(String value) {
            addCriterion("d_image_url >", value, "dImageUrl");
            return (Criteria) this;
        }

        public Criteria andDImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("d_image_url >=", value, "dImageUrl");
            return (Criteria) this;
        }

        public Criteria andDImageUrlLessThan(String value) {
            addCriterion("d_image_url <", value, "dImageUrl");
            return (Criteria) this;
        }

        public Criteria andDImageUrlLessThanOrEqualTo(String value) {
            addCriterion("d_image_url <=", value, "dImageUrl");
            return (Criteria) this;
        }

        public Criteria andDImageUrlLike(String value) {
            addCriterion("d_image_url like", value, "dImageUrl");
            return (Criteria) this;
        }

        public Criteria andDImageUrlNotLike(String value) {
            addCriterion("d_image_url not like", value, "dImageUrl");
            return (Criteria) this;
        }

        public Criteria andDImageUrlIn(List<String> values) {
            addCriterion("d_image_url in", values, "dImageUrl");
            return (Criteria) this;
        }

        public Criteria andDImageUrlNotIn(List<String> values) {
            addCriterion("d_image_url not in", values, "dImageUrl");
            return (Criteria) this;
        }

        public Criteria andDImageUrlBetween(String value1, String value2) {
            addCriterion("d_image_url between", value1, value2, "dImageUrl");
            return (Criteria) this;
        }

        public Criteria andDImageUrlNotBetween(String value1, String value2) {
            addCriterion("d_image_url not between", value1, value2, "dImageUrl");
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

        public Criteria andMidSubImageListIsNull() {
            addCriterion("mid_sub_image_list is null");
            return (Criteria) this;
        }

        public Criteria andMidSubImageListIsNotNull() {
            addCriterion("mid_sub_image_list is not null");
            return (Criteria) this;
        }

        public Criteria andMidSubImageListEqualTo(String value) {
            addCriterion("mid_sub_image_list =", value, "midSubImageList");
            return (Criteria) this;
        }

        public Criteria andMidSubImageListNotEqualTo(String value) {
            addCriterion("mid_sub_image_list <>", value, "midSubImageList");
            return (Criteria) this;
        }

        public Criteria andMidSubImageListGreaterThan(String value) {
            addCriterion("mid_sub_image_list >", value, "midSubImageList");
            return (Criteria) this;
        }

        public Criteria andMidSubImageListGreaterThanOrEqualTo(String value) {
            addCriterion("mid_sub_image_list >=", value, "midSubImageList");
            return (Criteria) this;
        }

        public Criteria andMidSubImageListLessThan(String value) {
            addCriterion("mid_sub_image_list <", value, "midSubImageList");
            return (Criteria) this;
        }

        public Criteria andMidSubImageListLessThanOrEqualTo(String value) {
            addCriterion("mid_sub_image_list <=", value, "midSubImageList");
            return (Criteria) this;
        }

        public Criteria andMidSubImageListLike(String value) {
            addCriterion("mid_sub_image_list like", value, "midSubImageList");
            return (Criteria) this;
        }

        public Criteria andMidSubImageListNotLike(String value) {
            addCriterion("mid_sub_image_list not like", value, "midSubImageList");
            return (Criteria) this;
        }

        public Criteria andMidSubImageListIn(List<String> values) {
            addCriterion("mid_sub_image_list in", values, "midSubImageList");
            return (Criteria) this;
        }

        public Criteria andMidSubImageListNotIn(List<String> values) {
            addCriterion("mid_sub_image_list not in", values, "midSubImageList");
            return (Criteria) this;
        }

        public Criteria andMidSubImageListBetween(String value1, String value2) {
            addCriterion("mid_sub_image_list between", value1, value2, "midSubImageList");
            return (Criteria) this;
        }

        public Criteria andMidSubImageListNotBetween(String value1, String value2) {
            addCriterion("mid_sub_image_list not between", value1, value2, "midSubImageList");
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

        public Criteria andSubImagePathListIsNull() {
            addCriterion("sub_image_path_list is null");
            return (Criteria) this;
        }

        public Criteria andSubImagePathListIsNotNull() {
            addCriterion("sub_image_path_list is not null");
            return (Criteria) this;
        }

        public Criteria andSubImagePathListEqualTo(String value) {
            addCriterion("sub_image_path_list =", value, "subImagePathList");
            return (Criteria) this;
        }

        public Criteria andSubImagePathListNotEqualTo(String value) {
            addCriterion("sub_image_path_list <>", value, "subImagePathList");
            return (Criteria) this;
        }

        public Criteria andSubImagePathListGreaterThan(String value) {
            addCriterion("sub_image_path_list >", value, "subImagePathList");
            return (Criteria) this;
        }

        public Criteria andSubImagePathListGreaterThanOrEqualTo(String value) {
            addCriterion("sub_image_path_list >=", value, "subImagePathList");
            return (Criteria) this;
        }

        public Criteria andSubImagePathListLessThan(String value) {
            addCriterion("sub_image_path_list <", value, "subImagePathList");
            return (Criteria) this;
        }

        public Criteria andSubImagePathListLessThanOrEqualTo(String value) {
            addCriterion("sub_image_path_list <=", value, "subImagePathList");
            return (Criteria) this;
        }

        public Criteria andSubImagePathListLike(String value) {
            addCriterion("sub_image_path_list like", value, "subImagePathList");
            return (Criteria) this;
        }

        public Criteria andSubImagePathListNotLike(String value) {
            addCriterion("sub_image_path_list not like", value, "subImagePathList");
            return (Criteria) this;
        }

        public Criteria andSubImagePathListIn(List<String> values) {
            addCriterion("sub_image_path_list in", values, "subImagePathList");
            return (Criteria) this;
        }

        public Criteria andSubImagePathListNotIn(List<String> values) {
            addCriterion("sub_image_path_list not in", values, "subImagePathList");
            return (Criteria) this;
        }

        public Criteria andSubImagePathListBetween(String value1, String value2) {
            addCriterion("sub_image_path_list between", value1, value2, "subImagePathList");
            return (Criteria) this;
        }

        public Criteria andSubImagePathListNotBetween(String value1, String value2) {
            addCriterion("sub_image_path_list not between", value1, value2, "subImagePathList");
            return (Criteria) this;
        }

        public Criteria andRawSubImagePathListIsNull() {
            addCriterion("raw_sub_image_path_list is null");
            return (Criteria) this;
        }

        public Criteria andRawSubImagePathListIsNotNull() {
            addCriterion("raw_sub_image_path_list is not null");
            return (Criteria) this;
        }

        public Criteria andRawSubImagePathListEqualTo(String value) {
            addCriterion("raw_sub_image_path_list =", value, "rawSubImagePathList");
            return (Criteria) this;
        }

        public Criteria andRawSubImagePathListNotEqualTo(String value) {
            addCriterion("raw_sub_image_path_list <>", value, "rawSubImagePathList");
            return (Criteria) this;
        }

        public Criteria andRawSubImagePathListGreaterThan(String value) {
            addCriterion("raw_sub_image_path_list >", value, "rawSubImagePathList");
            return (Criteria) this;
        }

        public Criteria andRawSubImagePathListGreaterThanOrEqualTo(String value) {
            addCriterion("raw_sub_image_path_list >=", value, "rawSubImagePathList");
            return (Criteria) this;
        }

        public Criteria andRawSubImagePathListLessThan(String value) {
            addCriterion("raw_sub_image_path_list <", value, "rawSubImagePathList");
            return (Criteria) this;
        }

        public Criteria andRawSubImagePathListLessThanOrEqualTo(String value) {
            addCriterion("raw_sub_image_path_list <=", value, "rawSubImagePathList");
            return (Criteria) this;
        }

        public Criteria andRawSubImagePathListLike(String value) {
            addCriterion("raw_sub_image_path_list like", value, "rawSubImagePathList");
            return (Criteria) this;
        }

        public Criteria andRawSubImagePathListNotLike(String value) {
            addCriterion("raw_sub_image_path_list not like", value, "rawSubImagePathList");
            return (Criteria) this;
        }

        public Criteria andRawSubImagePathListIn(List<String> values) {
            addCriterion("raw_sub_image_path_list in", values, "rawSubImagePathList");
            return (Criteria) this;
        }

        public Criteria andRawSubImagePathListNotIn(List<String> values) {
            addCriterion("raw_sub_image_path_list not in", values, "rawSubImagePathList");
            return (Criteria) this;
        }

        public Criteria andRawSubImagePathListBetween(String value1, String value2) {
            addCriterion("raw_sub_image_path_list between", value1, value2, "rawSubImagePathList");
            return (Criteria) this;
        }

        public Criteria andRawSubImagePathListNotBetween(String value1, String value2) {
            addCriterion("raw_sub_image_path_list not between", value1, value2, "rawSubImagePathList");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNull() {
            addCriterion("submit_time is null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNotNull() {
            addCriterion("submit_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeEqualTo(Long value) {
            addCriterion("submit_time =", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotEqualTo(Long value) {
            addCriterion("submit_time <>", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThan(Long value) {
            addCriterion("submit_time >", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("submit_time >=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThan(Long value) {
            addCriterion("submit_time <", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThanOrEqualTo(Long value) {
            addCriterion("submit_time <=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIn(List<Long> values) {
            addCriterion("submit_time in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotIn(List<Long> values) {
            addCriterion("submit_time not in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeBetween(Long value1, Long value2) {
            addCriterion("submit_time between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotBetween(Long value1, Long value2) {
            addCriterion("submit_time not between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Long value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Long value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Long value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Long value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Long value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Long> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Long> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Long value1, Long value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Long value1, Long value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Long value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Long value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Long value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Long value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Long value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Long> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Long> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Long value1, Long value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Long value1, Long value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andTaskRespIsNull() {
            addCriterion("task_resp is null");
            return (Criteria) this;
        }

        public Criteria andTaskRespIsNotNull() {
            addCriterion("task_resp is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRespEqualTo(String value) {
            addCriterion("task_resp =", value, "taskResp");
            return (Criteria) this;
        }

        public Criteria andTaskRespNotEqualTo(String value) {
            addCriterion("task_resp <>", value, "taskResp");
            return (Criteria) this;
        }

        public Criteria andTaskRespGreaterThan(String value) {
            addCriterion("task_resp >", value, "taskResp");
            return (Criteria) this;
        }

        public Criteria andTaskRespGreaterThanOrEqualTo(String value) {
            addCriterion("task_resp >=", value, "taskResp");
            return (Criteria) this;
        }

        public Criteria andTaskRespLessThan(String value) {
            addCriterion("task_resp <", value, "taskResp");
            return (Criteria) this;
        }

        public Criteria andTaskRespLessThanOrEqualTo(String value) {
            addCriterion("task_resp <=", value, "taskResp");
            return (Criteria) this;
        }

        public Criteria andTaskRespLike(String value) {
            addCriterion("task_resp like", value, "taskResp");
            return (Criteria) this;
        }

        public Criteria andTaskRespNotLike(String value) {
            addCriterion("task_resp not like", value, "taskResp");
            return (Criteria) this;
        }

        public Criteria andTaskRespIn(List<String> values) {
            addCriterion("task_resp in", values, "taskResp");
            return (Criteria) this;
        }

        public Criteria andTaskRespNotIn(List<String> values) {
            addCriterion("task_resp not in", values, "taskResp");
            return (Criteria) this;
        }

        public Criteria andTaskRespBetween(String value1, String value2) {
            addCriterion("task_resp between", value1, value2, "taskResp");
            return (Criteria) this;
        }

        public Criteria andTaskRespNotBetween(String value1, String value2) {
            addCriterion("task_resp not between", value1, value2, "taskResp");
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