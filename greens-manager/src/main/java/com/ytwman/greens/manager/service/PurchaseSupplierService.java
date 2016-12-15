/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/13 下午11:35
 * Description: 
 */
package com.ytwman.greens.manager.service;

import com.ytwman.greens.commons.core.Like;
import com.ytwman.greens.commons.entity.PurchaseSupplierEntity;
import com.ytwman.greens.commons.entity.mapper.base.PurchaseSupplierEntityMapper;
import com.ytwman.greens.commons.repo.PurchaseSupplierMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class PurchaseSupplierService {

    @Resource
    PurchaseSupplierMapper purchaseSupplierMapper;

    @Resource
    PurchaseSupplierEntityMapper purchaseSupplierEntityMapper;

    public List<PurchaseSupplierEntity> getAll(String keywords) {
        return purchaseSupplierMapper.findAll(Like.right(keywords));
    }

    public PurchaseSupplierEntity get(Long categoryId) {
        return purchaseSupplierMapper.findById(categoryId);
    }

    public void saveOrUpdate(PurchaseSupplierEntity entity) {
        if (entity.getId() == null) {
            purchaseSupplierEntityMapper.insertSelective(entity);
        } else {
            purchaseSupplierEntityMapper.updateByPrimaryKeySelective(entity);
        }
    }

    public void delete(Long categoryId) {
        PurchaseSupplierEntity entity = new PurchaseSupplierEntity();
        entity.setId(categoryId);
        entity.setIsDelete(1);
        purchaseSupplierEntityMapper.updateByPrimaryKeySelective(entity);
    }
}
