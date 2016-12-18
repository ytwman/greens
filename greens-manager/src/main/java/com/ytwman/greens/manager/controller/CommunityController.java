/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/15 上午9:43
 * Description:
 */
package com.ytwman.greens.manager.controller;

import com.ytwman.greens.commons.entity.CommunityEntity;
import com.ytwman.greens.manager.service.CommunityService;
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
@RequestMapping("/communities")
public class CommunityController {

    @Resource
    CommunityService communityService;

    @RequestMapping(method = RequestMethod.GET)
    public Object index(String keywords) {
        return communityService.getAll(keywords);
    }

    @RequestMapping("/{communityId}")
    public Object show(@PathVariable("communityId") Long communityId) {
        return communityService.get(communityId);
    }

    @RequestMapping("/add")
    public void add(@Valid CommunityEntity entity) {
        communityService.save(entity);
    }

    @RequestMapping("/update")
    public void update(CommunityEntity entity) {
        communityService.update(entity);
    }

    @RequestMapping("/delete/{communityId}")
    public void delete(@PathVariable("communityId") Long communityId) {
        communityService.delete(communityId);
    }
}
