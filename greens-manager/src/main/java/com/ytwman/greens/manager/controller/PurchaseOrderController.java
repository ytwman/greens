package com.ytwman.greens.manager.controller;

import com.ytwman.greens.commons.entity.PurchaseSupplierEntity;
import com.ytwman.greens.manager.service.PurchaseService;
import com.ytwman.greens.manager.service.PurchaseSupplierService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 采购单
 * Created by ytwman on 16/12/23.
 */
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Resource
    PurchaseService purchaseService;

    @RequestMapping(method = RequestMethod.GET)
    public Object index(String keywords) {
        return null;
    }

    @RequestMapping("/{purchaseId}")
    public Object show(@PathVariable("purchaseId") Long purchaseId) {
        return null;
    }

    @RequestMapping("/save_or_update")
    public void saveOrUpdate(@Valid PurchaseSupplierEntity entity) {

    }

    @RequestMapping("/delete/{purchaseId}")
    public void delete(@PathVariable("purchaseId") Long purchaseId) {

    }
}
