/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 上午2:22
 * Description: 
 */
package com.ytwman.greens.manager.controller;

import com.ytwman.greens.commons.Pagination;
import com.ytwman.greens.manager.service.GoodsInfoService;
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
@RequestMapping("/goods_info")
public class GoodsInfoController {

    @Resource
    GoodsInfoService goodsInfoService;

    @RequestMapping(method = RequestMethod.GET)
    public Object index(Pagination pagination) {
        return goodsInfoService.getAll(pagination);
    }

    @RequestMapping("/{goodsId}")
    public Object show(@PathVariable("goodsId") Long goodsId) {
        return goodsInfoService.get(goodsId);
    }
}
