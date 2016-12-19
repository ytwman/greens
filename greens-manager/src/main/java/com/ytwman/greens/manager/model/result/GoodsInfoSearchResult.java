package com.ytwman.greens.manager.model.result;

import com.ytwman.greens.commons.entity.GoodsInfoEntity;

import java.io.Serializable;

/**
 * Created by ytwman on 16/12/20.
 */
public class GoodsInfoSearchResult extends GoodsInfoEntity implements Serializable {

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
