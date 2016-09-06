/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/9/6 上午2:56
 * Description: 
 */
package com.ytwman.greens.manager.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/goods_categories")
public class GoodsCategoryController {

    /**
     * 商品类目列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public Object index() {
        return null;
    }

    /**
     * 商品类目信息
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{categoryId}")
    public Object show(@PathVariable("categoryId") Long categoryId) {
        return null;
    }

    /**
     * 添加商品类目
     */
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public void create() {
    }

    /**
     * 修改商品类目
     */
    @RequestMapping(method = RequestMethod.PUT)
    public void modify() {
    }

    /**
     * 删除商品类目
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{goodsId}")
    public void delete(@PathVariable("categoryId") Long categoryId) {
    }
}
