/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/9/18 下午10:03
 * Description: 
 */
package com.ytwman.greens.manager.controller;

import com.ytwman.greens.commons.entity.GoodsCategoryEntity;
import com.ytwman.greens.manager.service.GoodsCategoryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/goods_category")
public class GoodsCategoryController {

    @Resource
    GoodsCategoryService goodsCategoryService;

    @RequestMapping(method = RequestMethod.GET)
    public Object index(String keywords) {
        return goodsCategoryService.getAll(keywords);
    }

    @RequestMapping("/{categoryId}")
    public Object show(@PathVariable("categoryId") Long categoryId) {
        return goodsCategoryService.get(categoryId);
    }

    @RequestMapping("/create")
    public void create(GoodsCategoryEntity entity) {
        goodsCategoryService.save(entity);
    }

    @RequestMapping("update")
    public void update(GoodsCategoryEntity entity) {
        goodsCategoryService.update(entity);
    }
}
