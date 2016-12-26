package com.ytwman.greens.manager.service;

import com.ytwman.greens.commons.entity.PurchaseOrderEntity;
import com.ytwman.greens.commons.repo.PurchaseOrderMapper;
import com.ytwman.greens.manager.model.param.PurchaseOrderParam;
import com.ytwman.greens.manager.model.param.PurchaseOrderSearchParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ytwman on 16/12/23.
 */
@Service
public class PurchaseOrderService {

    @Resource
    PurchaseOrderMapper purchaseOrderMapper;

    public List<PurchaseOrderEntity> getAll(PurchaseOrderSearchParam param) {
        return purchaseOrderMapper.findAll();
    }

    public void saveOrUpdate(PurchaseOrderParam param) {

    }
}
