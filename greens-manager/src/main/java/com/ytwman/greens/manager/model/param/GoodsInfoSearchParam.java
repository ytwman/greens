package com.ytwman.greens.manager.model.param;

import com.ytwman.greens.commons.core.web.Pagination;

import java.io.Serializable;

/**
 * Created by ytwman on 16/12/20.
 */
public class GoodsInfoSearchParam extends Pagination implements Serializable {

    private String keywords;
    private Long categoryId;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
