/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/16 上午12:18
 * Description: 
 */
package com.ytwman.greens.manager.controller;

import com.ytwman.greens.commons.entity.UserInfoEntity;
import com.ytwman.greens.manager.service.UserInfoService;
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
@RequestMapping("/users")
public class UserInfoController {

    @Resource
    UserInfoService userInfoService;

    @RequestMapping(method = RequestMethod.GET)
    public Object index(String keywords, Long communityId) {
        return userInfoService.getAll(keywords, communityId);
    }

    @RequestMapping("/{id}")
    public Object show(@PathVariable("id") Long id) {
        return userInfoService.get(id);
    }

    @RequestMapping("/save_or_update")
    public void saveOrUpdate(@Valid UserInfoEntity entity) {
        userInfoService.saveOrUpdate(entity);
    }

    @RequestMapping("/delete/{categoryId}")
    public void delete(@PathVariable("categoryId") Long categoryId) {
        userInfoService.delete(categoryId);
    }
}
