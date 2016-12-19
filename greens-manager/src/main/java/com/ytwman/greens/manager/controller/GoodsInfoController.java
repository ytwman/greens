/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 上午2:22
 * Description: 
 */
package com.ytwman.greens.manager.controller;

import com.ytwman.greens.manager.model.param.GoodsInfoParam;
import com.ytwman.greens.manager.model.param.GoodsInfoSearchParam;
import com.ytwman.greens.manager.service.GoodsInfoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

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
    public Object index(GoodsInfoSearchParam searchParam) {
        return goodsInfoService.getAll(searchParam);
    }

    @RequestMapping("/{goodsId}")
    public Object show(@PathVariable("goodsId") Long goodsId) {
        return goodsInfoService.get(goodsId);
    }

    @RequestMapping("/save_or_update")
    public void saveOrUpdate(@Valid GoodsInfoParam param) {
        goodsInfoService.saveOrUpdate(param);
    }

    @RequestMapping("/delete/{goodsId}")
    public void delete(@PathVariable("goodsId") Long goodsId) {
        goodsInfoService.delete(goodsId);
    }
}
