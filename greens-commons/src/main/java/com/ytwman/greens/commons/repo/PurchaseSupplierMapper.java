/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/13 下午11:36
 * Description: 
 */
package com.ytwman.greens.commons.repo;

import com.ytwman.greens.commons.entity.PurchaseSupplierEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface PurchaseSupplierMapper {

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    PurchaseSupplierEntity findById(@Param("id") Long id);

    /**
     * 根据关键字模糊查询供应商(供应商名称\联系人\手机号码)
     *
     * @param keywords
     * @return
     */
    List<PurchaseSupplierEntity> findAll(@Param("keywords") String keywords);
}
