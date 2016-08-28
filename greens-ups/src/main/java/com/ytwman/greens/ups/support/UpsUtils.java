/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/8/28 下午5:26
 * Description: 
 */
package com.ytwman.greens.ups.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UpsUtils {

    /**
     * 返回用户角色
     * @return
     */
    public static List<Object> getUserRoles(HttpSession httpSession) {
        List<Object> userRoles = (List<Object>) httpSession.getAttribute(HttpExtend.Session.UpsUserRole);
        return userRoles == null ? new ArrayList<>() : userRoles;
    }

    /**
     * 获取用户主键
     * @return
     */
    public static Long getUserId(HttpSession httpSession) {
        return (Long) httpSession.getAttribute(HttpExtend.Session.UserId);
    }

    /**
     * 返回服务端 IP
     *
     * @param request
     * @return
     */
    public static String getServerIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 返回客户端 IP
     *
     * @param request
     * @return
     */
    public static String getClientIp(HttpServletRequest request) {
        return null;
    }

    public static void cleanSession(HttpSession httpSession) {
        httpSession.removeAttribute(HttpExtend.Session.UserId);
        httpSession.removeAttribute(HttpExtend.Session.OpenId);
        httpSession.removeAttribute(HttpExtend.Session.UpsUserRole);
    }
}
