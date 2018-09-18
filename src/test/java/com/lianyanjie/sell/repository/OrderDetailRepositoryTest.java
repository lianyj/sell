package com.lianyanjie.sell.repository;

import com.lianyanjie.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: lyj
 * @since: 2018/9/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("22222");
        orderDetail.setOrderId("123457");
        orderDetail.setProductId("12345");
        orderDetail.setProductName("肉底料");
        orderDetail.setProductPrice(BigDecimal.valueOf(18));
        orderDetail.setProductQuantity(1);
        orderDetail.setProductIcon("www.baidu.com");

        OrderDetail rest =  orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(rest);
    }

    @Test
    public void findByOrderIdTest() {
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId("123457");
        Assert.assertNotEquals(0,orderDetails.size());
    }
}