/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/8/29 上午4:04
 * Description: 
 */
package com.ytwman.greens.manager.controller;

import com.ytwman.greens.ups.support.Permission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class IndexController {

    @Permission
    @RequestMapping(method = RequestMethod.GET)
    public Object index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
