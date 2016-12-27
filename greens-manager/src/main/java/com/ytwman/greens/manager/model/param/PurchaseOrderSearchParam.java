package com.ytwman.greens.manager.model.param;

import com.ytwman.greens.commons.helper.DateFormatter;
import com.ytwman.greens.commons.model.PurchaseOrderSearch;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ytwman on 16/12/25.
 */
public class PurchaseOrderSearchParam extends PurchaseOrderSearch implements Serializable {

    // 采购日期
    @DateTimeFormat(pattern = DateFormatter.FORMAT_DATETIME)
    private Date purchaseDate;

    @Override
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
