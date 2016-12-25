package com.ytwman.greens.manager.controller;

import com.ytwman.greens.manager.model.param.PurchaseOrderParam;
import com.ytwman.greens.manager.model.param.PurchaseOrderSearchParam;
import com.ytwman.greens.manager.service.PurchaseOrderService;
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
@RequestMapping("/purchase_order")
public class PurchaseOrderController {

    @Resource
    PurchaseOrderService purchaseOrderService;

    @RequestMapping(method = RequestMethod.GET)
    public Object index(PurchaseOrderSearchParam param) {
        // 查询条件 采购单号，采购人，审核状态，采购日期


        return null;
    }

    @RequestMapping("/{purchaseId}")
    public Object show(@PathVariable("purchaseId") Long purchaseId) {
        return null;
    }

    @RequestMapping("/save_or_update")
    public void saveOrUpdate(@Valid PurchaseOrderParam param) {

    }

    @RequestMapping("/delete/{purchaseId}")
    public void delete(@PathVariable("purchaseId") Long purchaseId) {
        // 删除前，确定采购单是否已审核，审核过的采购单不允许删除
    }


}
