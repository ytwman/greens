/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/8/28 下午6:46
 * Description: 
 */
package com.ytwman.greens.ups.service;

import com.ytwman.greens.ups.entity.UpsOperationLog;
import com.ytwman.greens.ups.entity.UpsPermission;
import com.ytwman.greens.ups.entity.UpsUser;
import com.ytwman.greens.ups.entity.mapper.base.UpsOperationLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class UpsOperationLogService {

    @Resource
    UpsOperationLogMapper upsOperationLogMapper;

    /**
     * 记录用户访问日志
     *
     * @param upsUser
     * @param upsPermission
     * @param clientIp
     * @param serverIp
     */
    public void logger(UpsUser upsUser, UpsPermission upsPermission, String clientIp, String serverIp) {
        UpsOperationLog upsOperationLog = new UpsOperationLog();
        upsOperationLog.setOperatorId(upsUser.getId());
        upsOperationLog.setOperatorName(upsUser.getName());
        upsOperationLog.setPermissionId(upsPermission.getId());
        upsOperationLog.setPermissionName(upsPermission.getName());
        upsOperationLog.setServerIp(clientIp);
        upsOperationLog.setClientIp(serverIp);
        upsOperationLogMapper.insertSelective(upsOperationLog);
    }
}
