package com.ytwman.greens.manager.model.param;

import com.ytwman.greens.commons.entity.PurchaseOrderItemEntity;

import java.io.Serializable;

/**
 * Created by ytwman on 16/12/25.
 */
public class PurchaseOrderItemParam extends PurchaseOrderItemEntity implements Serializable {

    private Long goodsId;

    private Integer amount;

    @Override
    public Long getGoodsId() {
        return goodsId;
    }

    @Override
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public Integer getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
