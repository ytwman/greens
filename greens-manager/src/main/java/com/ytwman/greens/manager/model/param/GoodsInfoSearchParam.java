package com.ytwman.greens.manager.model.param;

import com.ytwman.greens.commons.core.Like;
import com.ytwman.greens.commons.model.GoodsInfoSearch;

import java.io.Serializable;

/**
 * Created by ytwman on 16/12/20.
 */
public class GoodsInfoSearchParam extends GoodsInfoSearch implements Serializable {

    @Override
    public String getKeywords() {
        return Like.right(super.getKeywords());
    }
}
