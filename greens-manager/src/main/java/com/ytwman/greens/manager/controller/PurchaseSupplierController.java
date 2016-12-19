/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/13 下午11:34
 * Description: 
 */
package com.ytwman.greens.manager.controller;

import com.ytwman.greens.commons.entity.PurchaseSupplierEntity;
import com.ytwman.greens.manager.service.PurchaseSupplierService;
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
@RequestMapping("/suppliers")
public class PurchaseSupplierController {

    @Resource
    PurchaseSupplierService purchaseSupplierService;

    @RequestMapping(method = RequestMethod.GET)
    public Object index(String keywords) {
        return purchaseSupplierService.getAll(keywords);
    }

    @RequestMapping("/{supplierId}")
    public Object show(@PathVariable("supplierId") Long supplierId) {
        return purchaseSupplierService.get(supplierId);
    }

    @RequestMapping("/save_or_update")
    public void saveOrUpdate(@Valid PurchaseSupplierEntity entity) {
        purchaseSupplierService.saveOrUpdate(entity);
    }

    @RequestMapping("/delete/{supplierId}")
    public void delete(@PathVariable("supplierId") Long supplierId) {
        purchaseSupplierService.delete(supplierId);
    }
}
