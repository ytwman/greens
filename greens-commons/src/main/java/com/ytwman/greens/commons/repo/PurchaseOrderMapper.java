package com.ytwman.greens.commons.repo;

import com.ytwman.greens.commons.entity.PurchaseOrderEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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
     * @param keywords      采购单号
     * @param purchaserId   采购人
     * @param purchaserDate 采购时间
     * @return
     */
    List<PurchaseOrderEntity> findAll(@Param("keywords") String keywords,
                                      @Param("purchaserId") Long purchaserId,
                                      @Param("purchaserDate") Date purchaserDate);
}
