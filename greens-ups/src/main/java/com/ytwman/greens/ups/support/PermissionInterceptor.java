/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/8/28 下午4:15
 * Description: 
 */
package com.ytwman.greens.ups.support;

import com.ytwman.greens.ups.entity.UpsPermission;
import com.ytwman.greens.ups.entity.UpsUser;
import com.ytwman.greens.ups.entity.UpsUserRole;
import com.ytwman.greens.ups.service.UpsOperationLogService;
import com.ytwman.greens.ups.service.UpsUserService;
import com.ytwman.greens.ups.service.model.UpsPermissionExtend;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    @Resource
    UpsUserService upsUserService;

    @Resource
    UpsOperationLogService upsOperationLogService;

    /**
     * 不拦截的 path 地址
     */
    private List<String> filterPath;

    public PermissionInterceptor() {
        this.filterPath = new ArrayList<>();

        this.filterPath.add("/login");
        this.filterPath.add("/");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        // 获取请求方法的权限拦截器, 如果没有注解则默认规则
        Permission permission = (Permission) handlerMethod.getMethodAnnotation(Permission.class);
        if (permission == null) {
            permission = (Permission) handlerMethod.getBeanType().getAnnotation(Permission.class);
        }

        // 不需要登录直接跳过
        if (permission == null || !permission.login()) {
            return true;
        }

        HttpSession httpSession = request.getSession();

        if (!doLogin(httpSession)) {
            return redirectLogin(request, response);
        }

        // 如果设置为不需要权限直接跳过
        if (permission.auth() && !doPermission(request)) {
            throw new Exception("没有足够权限访问");
        }

        // 记录操作日志
        UpsUser upsUser = null;
        UpsPermission upsPermission = null;
        String clientIp = UpsUtils.getClientIp(request);
        String serverIp = UpsUtils.getServerIp();

        upsOperationLogService.logger(upsUser, upsPermission, clientIp, serverIp);

        return super.preHandle(request, response, handler);
    }

    /**
     * 是否登录
     *
     * @param httpSession
     * @return
     */
    public boolean doLogin(HttpSession httpSession) {
        return UpsUtils.getUserId(httpSession) != null;
    }

    /**
     * 是否有权限访问
     *
     * @param request
     * @return
     */
    public boolean doPermission(HttpServletRequest request) {

        String path = request.getContextPath();
        if (doFilter(path)) {
            return true;
        }

        // 验证权限
        Long userId = UpsUtils.getUserId(request.getSession());
        List<UpsUserRole> upsUserRoles = upsUserService.getUpsUserRole(userId);
        if (CollectionUtils.isEmpty(upsUserRoles)) {
            throw new RuntimeException("当前登录用户未设置角色");
        }

        List<UpsPermissionExtend> upsPermissionExtends = upsUserService.allRoleAndPermission();
        for (UpsUserRole upsUserRole : upsUserRoles) {
            for (UpsPermissionExtend upsPermission : upsPermissionExtends) {
                if (upsPermission.getRoleId().equals(upsUserRole.getRoleId())
                        && upsPermission.getPath().equals(path)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 跳过不需要拦截的路径,例如:登录页面\退出页面等
     *
     * @param path
     * @return
     */
    public boolean doFilter(String path) {
        return filterPath.contains(path);
    }

    /**
     * 未登录跳转到登录页面
     *
     * @param request
     * @param response
     * @return
     */
    public boolean redirectLogin(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;

        try {
            if (RequestType.HTML.equals(RequestType.get(request))) {
                response.sendRedirect("/ups/login");
            }
            if (RequestType.JSON.equals(RequestType.get(request))) {
                out = response.getWriter();
                out.print(StringUtils.join("<script>top.location.href='/ups/login';</script>"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }

        return false;
    }

    public void setFilterPath(List<String> filterPath) {
        if (filterPath != null && !filterPath.isEmpty()) {
            this.filterPath.addAll(filterPath);
        }
    }

    public enum RequestType {
        JSON,
        HTML;

        public static RequestType get(HttpServletRequest request) {
            String accept = request.getHeader("accept");
            if (StringUtils.isNotBlank(accept)) {
                if (StringUtils.contains(accept, "json")) {
                    return RequestType.JSON;
                }

                if (StringUtils.contains(accept, "html") || StringUtils.equals(accept, "*/*")) {
                    return RequestType.HTML;
                }
            }
            return HTML;
        }
    }
}
