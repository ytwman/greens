/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/18 下午2:50
 * Description: 
 */
package com.ytwman.greens.manager.model.param;

import com.ytwman.greens.commons.entity.GoodsCategoryEntity;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class GoodsCategoryParam extends GoodsCategoryEntity implements Serializable {

    @NotEmpty(message = "商品类目名称不能为空")
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
