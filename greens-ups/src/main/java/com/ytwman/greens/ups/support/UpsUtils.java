/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/8/28 下午5:26
 * Description: 
 */
package com.ytwman.greens.ups.support;

import com.ytwman.greens.commons.cache.HttpExtend;
import com.ytwman.greens.ups.entity.UpsUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UpsUtils {
    /**
     * 获取用户主键
     */
    public static Long getUserId(HttpSession httpSession) {
        return (Long) httpSession.getAttribute(HttpExtend.Session.UserId);
    }

    /**
     * 返回服务端 IP
     */
    public static String getServerIp() {
        String ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }

    /**
     * 返回客户端 IP
     */
    public static String getClientIp(HttpServletRequest request) {
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
     * 清空所有用户 session
     */
    public static void cleanSession(HttpSession httpSession) {
        httpSession.removeAttribute(HttpExtend.Session.UserId);
        httpSession.removeAttribute(HttpExtend.Session.OpenId);
        httpSession.removeAttribute(HttpExtend.Session.UpsUserRole);
    }

    /**
     * 是否管理员
     */
    public static boolean isAdmin(UpsUser upsUser) {
        return UpsUser.Type.Admin.getCode().equals(upsUser.getType());
    }
}
