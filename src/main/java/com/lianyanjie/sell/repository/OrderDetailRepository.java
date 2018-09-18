package com.lianyanjie.sell.repository;

import com.lianyanjie.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 功能描述: 订单详情Dao
 * @author: lyj
 * @since: 2018/9/17
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    /**
     * 根据orderId查询订单详情信息
     */
    List<OrderDetail> findByOrderId(String orderId);
}
