package com.ytwman.greens.commons.model;

import com.ytwman.greens.commons.core.web.Pagination;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ytwman on 16/12/26.
 */
public class PurchaseOrderSearch extends Pagination implements Serializable {
    // 采购单号
    private String keywords;

    // 采购日期
    private Date purchaseDate;

    // 采购人主键
    private Long purchaserId;

    // 核对状态
    private Integer audit;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
}
