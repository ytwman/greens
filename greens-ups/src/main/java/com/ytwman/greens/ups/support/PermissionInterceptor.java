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
import com.ytwman.greens.ups.service.UpsRoleService;
import com.ytwman.greens.ups.service.UpsUserService;
import com.ytwman.greens.ups.service.model.UpsPermissionExtend;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    UpsUserService upsUserService;

    @Resource
    UpsRoleService upsRoleService;

    @Resource
    UpsOperationLogService upsOperationLogService;

    /**
     * 不拦截的 path 地址
     */
    private List<String> filterPath;

    /**
     * 是否开启拦截模式
     */
    private boolean enable;

    public PermissionInterceptor() {
        this.filterPath = new ArrayList<>();

//        this.filterPath.add("/login");
//        this.filterPath.add("/");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        // 如果开启则跳过
        if (enable) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        // 获取请求方法的权限拦截器, 如果没有注解则默认规则
        Permission permission = handlerMethod.getMethodAnnotation(Permission.class);
        if (permission == null) {
            permission = handlerMethod.getBeanType().getAnnotation(Permission.class);
        }

        // 未设置或者不需要登录直接跳过
        if (permission == null || !permission.login()) {
            return true;
        }

        HttpSession httpSession = request.getSession();

        // 需要登录访问, 如果未登录先登录
        if (!doLogin(httpSession)) {
            return doRedirectLogin(request, response);
        }

        // 需要授权访问, 如果没有权限访问抛出异常提醒用户
        if (permission.auth() && !doPermission(request)) {
            throw new Exception("没有足够权限访问");
        }

        return super.preHandle(request, response, handler);
    }

    public void loggerOperator(HttpServletRequest request, UpsUser upsUser) throws Exception {
        UpsPermission upsPermission = null;

        List<UpsPermissionExtend> upsPermissionExtends = upsRoleService.allRoleAndPermission();
        for (UpsPermissionExtend upsPermissionExtend : upsPermissionExtends) {
            if (modelCompare(request, upsPermissionExtend)) {
                upsPermission = upsPermissionExtend;
                break;
            }
        }

        if (upsPermission == null) {
            throw new Exception(String.format("没有找到此路径对应的权限, [%s]", request.getServletPath()));
        }

        String clientIp = UpsUtils.getClientIp(request);
        String serverIp = UpsUtils.getServerIp();

        upsOperationLogService.logger(upsUser, upsPermission, clientIp, serverIp);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);

        // 如果已经登录, 返回用户实体
        Long userId = UpsUtils.getUserId(request.getSession());
        if (userId == null) {
            return;
        }

        UpsUser upsUser = upsUserService.getUpsUser(userId);
        if (modelAndView != null) {
            modelAndView.addObject("upsUser", upsUser);
        }

        // 记录操作日志
        // TODO 当执行过程中异常了,那么还会进入 postHandle 么. 这样就无法记录到操作日志了.
        loggerOperator(request, upsUser);
    }

    /**
     * 是否登录
     */
    public boolean doLogin(HttpSession httpSession) {
        return UpsUtils.getUserId(httpSession) != null;
    }

    /**
     * 是否有权限访问
     */
    public boolean doPermission(HttpServletRequest request) {

        // 默认跳过的一些请求
        if (doSkipFilter(request.getServletPath())) {
            return true;
        }

        // 验证权限
        Long userId = UpsUtils.getUserId(request.getSession());

        // 如果是管理员直接跳过
        UpsUser upsUser = upsUserService.getUpsUser(userId);
        if (UpsUtils.isAdmin(upsUser)) {
            return true;
        }

        List<UpsUserRole> upsUserRoles = upsUserService.getUpsUserRole(userId);
        if (CollectionUtils.isEmpty(upsUserRoles)) {
            throw new RuntimeException("当前登录用户未设置角色");
        }

        // 匹配请求路径对应的功能权限
        UpsPermissionExtend upsPermissionExtend = null;
        List<UpsPermissionExtend> upsPermissionExtends = upsRoleService.allRoleAndPermission();
        for (UpsPermissionExtend upsPermission : upsPermissionExtends) {
            if (modelCompare(request, upsPermission)) {
                upsPermissionExtend = upsPermission;
                break;
            }
        }

        // 如果配有匹配到对应路径的权限
        if (upsPermissionExtend == null) {
            throw new RuntimeException(String.format("没有找到此路径对应的权限, [%s]", request.getServletPath()));
        }

        // 匹配用户角色是否和对应的权限相同, 如果有相同的就放行
        for (UpsUserRole upsUserRole : upsUserRoles) {
            if (upsUserRole.getRoleId().equals(upsPermissionExtend.getRoleId())) {
                return true;
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
    public boolean doSkipFilter(String path) {
        return filterPath.contains(path);
    }

    /**
     * 未登录跳转到登录页面
     *
     * @param request
     * @param response
     * @return
     */
    public boolean doRedirectLogin(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;

        RequestType requestType = RequestType.get(request);

        try {
            if (RequestType.HTML.equals(requestType)) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            if (RequestType.JSON.equals(requestType)) {
                out = response.getWriter();
                out.print(StringUtils.join("<script>top.location.href='/login';</script>"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null)
                out.close();
        }

        return false;
    }

    public boolean modelCompare(HttpServletRequest request, UpsPermissionExtend upsPermissionExtend) {
        // 实际请求 -> 配置项目
        // /test/ -> /test
        // /test  -> /test
        // /test  -> /
        // 针对以上三种情况, 如果当前访问的是  首页 "/" 那么直接相等匹配,如果不是

        // /test/1 -> /test/*

        String requestPath = request.getServletPath();
        String path = upsPermissionExtend.getPath();

        if (path.equals("/")) {
            return requestPath.equals(path);
        }

        // 判断路径和动作相符合
        path = "^" + path.replace("*", "[a-zA-Z_0-9]+/?");
        Pattern pattern = Pattern.compile(path, Pattern.CASE_INSENSITIVE);

        logger.debug("验证权限, 请求路径:{}, 动作:{}, 权限路径:{}, 动作:{}",
                requestPath, request.getMethod(), path, upsPermissionExtend.getAction());

        return request.getMethod().equals(upsPermissionExtend.getAction()) && pattern.matcher(requestPath).matches();
    }

    public void setFilterPath(List<String> filterPath) {
        if (filterPath != null && !filterPath.isEmpty()) {
            this.filterPath.addAll(filterPath);
        }
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
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
