package com.lianyanjie.sell.repository;

import com.lianyanjie.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 功能描述: 订单主表Dao
 * @author: lyj
 * @since: 2018/9/17
 */
public interface OrderMasterRepository  extends JpaRepository<OrderMaster,String> {


    /**
     * 根据买家openid查询订单分页列表
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
