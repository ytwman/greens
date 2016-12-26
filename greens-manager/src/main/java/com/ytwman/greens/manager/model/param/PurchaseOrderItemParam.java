package com.ytwman.greens.manager.model.param;

import com.ytwman.greens.commons.entity.PurchaseOrderItemEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by ytwman on 16/12/25.
 */
public class PurchaseOrderItemParam extends PurchaseOrderItemEntity implements Serializable {

    @NotNull(message = "商品主键为填写")
    private Long goodsId;

    @Min(value = 1, message = "下单数量不能小于1")
    @NotNull(message = "")
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
