package com.ytwman.greens.commons.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderOfferEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderOfferEntityExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNull() {
            addCriterion("payment is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNotNull() {
            addCriterion("payment is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentEqualTo(BigDecimal value) {
            addCriterion("payment =", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotEqualTo(BigDecimal value) {
            addCriterion("payment <>", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThan(BigDecimal value) {
            addCriterion("payment >", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payment >=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThan(BigDecimal value) {
            addCriterion("payment <", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("payment <=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentIn(List<BigDecimal> values) {
            addCriterion("payment in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotIn(List<BigDecimal> values) {
            addCriterion("payment not in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payment between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payment not between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andPayableIsNull() {
            addCriterion("payable is null");
            return (Criteria) this;
        }

        public Criteria andPayableIsNotNull() {
            addCriterion("payable is not null");
            return (Criteria) this;
        }

        public Criteria andPayableEqualTo(BigDecimal value) {
            addCriterion("payable =", value, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableNotEqualTo(BigDecimal value) {
            addCriterion("payable <>", value, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableGreaterThan(BigDecimal value) {
            addCriterion("payable >", value, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payable >=", value, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableLessThan(BigDecimal value) {
            addCriterion("payable <", value, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("payable <=", value, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableIn(List<BigDecimal> values) {
            addCriterion("payable in", values, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableNotIn(List<BigDecimal> values) {
            addCriterion("payable not in", values, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payable between", value1, value2, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payable not between", value1, value2, "payable");
            return (Criteria) this;
        }

        public Criteria andLossProfitIsNull() {
            addCriterion("loss_profit is null");
            return (Criteria) this;
        }

        public Criteria andLossProfitIsNotNull() {
            addCriterion("loss_profit is not null");
            return (Criteria) this;
        }

        public Criteria andLossProfitEqualTo(BigDecimal value) {
            addCriterion("loss_profit =", value, "lossProfit");
            return (Criteria) this;
        }

        public Criteria andLossProfitNotEqualTo(BigDecimal value) {
            addCriterion("loss_profit <>", value, "lossProfit");
            return (Criteria) this;
        }

        public Criteria andLossProfitGreaterThan(BigDecimal value) {
            addCriterion("loss_profit >", value, "lossProfit");
            return (Criteria) this;
        }

        public Criteria andLossProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loss_profit >=", value, "lossProfit");
            return (Criteria) this;
        }

        public Criteria andLossProfitLessThan(BigDecimal value) {
            addCriterion("loss_profit <", value, "lossProfit");
            return (Criteria) this;
        }

        public Criteria andLossProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loss_profit <=", value, "lossProfit");
            return (Criteria) this;
        }

        public Criteria andLossProfitIn(List<BigDecimal> values) {
            addCriterion("loss_profit in", values, "lossProfit");
            return (Criteria) this;
        }

        public Criteria andLossProfitNotIn(List<BigDecimal> values) {
            addCriterion("loss_profit not in", values, "lossProfit");
            return (Criteria) this;
        }

        public Criteria andLossProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loss_profit between", value1, value2, "lossProfit");
            return (Criteria) this;
        }

        public Criteria andLossProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loss_profit not between", value1, value2, "lossProfit");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andPaidMethodIsNull() {
            addCriterion("paid_method is null");
            return (Criteria) this;
        }

        public Criteria andPaidMethodIsNotNull() {
            addCriterion("paid_method is not null");
            return (Criteria) this;
        }

        public Criteria andPaidMethodEqualTo(Integer value) {
            addCriterion("paid_method =", value, "paidMethod");
            return (Criteria) this;
        }

        public Criteria andPaidMethodNotEqualTo(Integer value) {
            addCriterion("paid_method <>", value, "paidMethod");
            return (Criteria) this;
        }

        public Criteria andPaidMethodGreaterThan(Integer value) {
            addCriterion("paid_method >", value, "paidMethod");
            return (Criteria) this;
        }

        public Criteria andPaidMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("paid_method >=", value, "paidMethod");
            return (Criteria) this;
        }

        public Criteria andPaidMethodLessThan(Integer value) {
            addCriterion("paid_method <", value, "paidMethod");
            return (Criteria) this;
        }

        public Criteria andPaidMethodLessThanOrEqualTo(Integer value) {
            addCriterion("paid_method <=", value, "paidMethod");
            return (Criteria) this;
        }

        public Criteria andPaidMethodIn(List<Integer> values) {
            addCriterion("paid_method in", values, "paidMethod");
            return (Criteria) this;
        }

        public Criteria andPaidMethodNotIn(List<Integer> values) {
            addCriterion("paid_method not in", values, "paidMethod");
            return (Criteria) this;
        }

        public Criteria andPaidMethodBetween(Integer value1, Integer value2) {
            addCriterion("paid_method between", value1, value2, "paidMethod");
            return (Criteria) this;
        }

        public Criteria andPaidMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("paid_method not between", value1, value2, "paidMethod");
            return (Criteria) this;
        }

        public Criteria andPaidTimeIsNull() {
            addCriterion("paid_time is null");
            return (Criteria) this;
        }

        public Criteria andPaidTimeIsNotNull() {
            addCriterion("paid_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaidTimeEqualTo(Date value) {
            addCriterion("paid_time =", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeNotEqualTo(Date value) {
            addCriterion("paid_time <>", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeGreaterThan(Date value) {
            addCriterion("paid_time >", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("paid_time >=", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeLessThan(Date value) {
            addCriterion("paid_time <", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeLessThanOrEqualTo(Date value) {
            addCriterion("paid_time <=", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeIn(List<Date> values) {
            addCriterion("paid_time in", values, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeNotIn(List<Date> values) {
            addCriterion("paid_time not in", values, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeBetween(Date value1, Date value2) {
            addCriterion("paid_time between", value1, value2, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeNotBetween(Date value1, Date value2) {
            addCriterion("paid_time not between", value1, value2, "paidTime");
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