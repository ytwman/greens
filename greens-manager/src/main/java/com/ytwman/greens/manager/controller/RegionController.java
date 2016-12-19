/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/18 下午6:12
 * Description: 
 */
package com.ytwman.greens.manager.controller;

import com.ytwman.greens.manager.service.CommunityService;
import com.ytwman.greens.manager.service.RegionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 地区
 *
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/regions")
public class RegionController {

    @Resource
    RegionService regionService;

    @Resource
    CommunityService communityService;

    @RequestMapping("/provinces")
    public Object provinces() {
        return regionService.provinces();
    }

    @RequestMapping("/{id}/childrens")
    public Object subset(@PathVariable("id") Long id) {
        return regionService.getSubset(id);
    }

    @RequestMapping("/{regionId}/communities")
    public Object communities(@PathVariable("regionId") Long regionId, String keywords) {
        return communityService.getByRegion(regionId, keywords);
    }
}
