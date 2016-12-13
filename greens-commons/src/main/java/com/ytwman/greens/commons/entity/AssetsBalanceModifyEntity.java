package com.ytwman.greens.commons.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AssetsBalanceModifyEntity implements Serializable {
    private Long id;

    private Long assetsId;

    private Long userId;

    private BigDecimal amount;

    private String reason;

    private Date createdTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(Long assetsId) {
        this.assetsId = assetsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", assetsId=").append(assetsId);
        sb.append(", userId=").append(userId);
        sb.append(", amount=").append(amount);
        sb.append(", reason=").append(reason);
        sb.append(", createdTime=").append(createdTime);
        sb.append("]");
        return sb.toString();
    }
}