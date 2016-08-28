/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/8/28 下午5:08
 * Description: 
 */
package com.ytwman.greens.ups.support;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface HttpExtend {

    interface Header {
        /**
         * 用户会话 ID
         */
        String SessionId = "X-SessionId";
    }

    interface Session {
        /**
         * OPENID
         */
        String OpenId = "OpenId";
        /**
         * 用户主键
         */
        String UserId = "UserId";
        /**
         * 用户角色
         */
        String UpsUserRole = "UpsUserRole";
    }
}
