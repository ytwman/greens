package com.ytwman.greens.manager.model.param;

import com.ytwman.greens.commons.entity.GoodsInfoEntity;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by ytwman on 16/12/20.
 */
public class GoodsInfoParam extends GoodsInfoEntity implements Serializable {

    @NotEmpty(message = "未填写商品名称")
    private String name;

    @NotEmpty(message = "未填写商品拼音")
    private String spell;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSpell() {
        return spell;
    }

    @Override
    public void setSpell(String spell) {
        this.spell = spell;
    }
}
