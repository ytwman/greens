package com.ytwman.greens.commons.repo;

import com.ytwman.greens.commons.entity.PurchaseOrderEntity;
import com.ytwman.greens.commons.model.PurchaseOrderSearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ytwman on 16/12/23.
 */
public interface PurchaseOrderMapper {

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    PurchaseOrderEntity findById(@Param("id") Long id);

    /**
     * 根据关键字模糊查询
     *
     * @param search
     * @return
     */
    List<PurchaseOrderEntity> findAll(PurchaseOrderSearch search);
}
