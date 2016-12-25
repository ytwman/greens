package com.ytwman.greens.manager.model.param;

import com.ytwman.greens.commons.entity.PurchaseOrderEntity;
import com.ytwman.greens.manager.validation.DateRange;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by ytwman on 16/12/25.
 */
public class PurchaseOrderParam extends PurchaseOrderEntity implements Serializable {

    @DateRange(min = "", message = "采购时间不能小于10天")
    @NotNull(message = "采购时间不能为空")
    private Date purchaseDate;

    @NotNull(message = "采购人主键不能为空")
    private Long purchaserId;

    @NotEmpty(message = "采购商品不能为空")
    private List<PurchaseOrderItemParam> orderItemParams;

    @Override
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public Long getPurchaserId() {
        return purchaserId;
    }

    @Override
    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public List<PurchaseOrderItemParam> getOrderItemParams() {
        return orderItemParams;
    }

    public void setOrderItemParams(List<PurchaseOrderItemParam> orderItemParams) {
        this.orderItemParams = orderItemParams;
    }
}
