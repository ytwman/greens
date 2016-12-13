package com.ytwman.greens.commons.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderOfferEntity implements Serializable {
    private Long id;

    private Long orderId;

    private BigDecimal payment;

    private BigDecimal payable;

    private BigDecimal balance;

    private Integer paidMethod;

    private Date paidTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public BigDecimal getPayable() {
        return payable;
    }

    public void setPayable(BigDecimal payable) {
        this.payable = payable;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getPaidMethod() {
        return paidMethod;
    }

    public void setPaidMethod(Integer paidMethod) {
        this.paidMethod = paidMethod;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", payment=").append(payment);
        sb.append(", payable=").append(payable);
        sb.append(", balance=").append(balance);
        sb.append(", paidMethod=").append(paidMethod);
        sb.append(", paidTime=").append(paidTime);
        sb.append("]");
        return sb.toString();
    }
}