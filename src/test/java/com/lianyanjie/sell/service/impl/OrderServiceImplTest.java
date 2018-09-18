package com.lianyanjie.sell.service.impl;

import com.lianyanjie.sell.dataobject.OrderDetail;
import com.lianyanjie.sell.dto.OrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: lyj
 * @since: 2018/9/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void createTest() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("lianyj");
        orderDTO.setBuyerAddress("hangzhou");
        orderDTO.setBuyerPhone("123456789123");
        orderDTO.setBuyerOpenid("abcd");
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("12345");
        orderDetail1.setProductQuantity(10);
        orderDetails.add(orderDetail1);
        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("888");
        orderDetail2.setProductQuantity(5);
        orderDetails.add(orderDetail2);
        orderDTO.setOrderDetailList(orderDetails);
        OrderDTO rest = orderService.create(orderDTO);
        assertNotNull(rest);
    }

    @Test
    public void findOneTest() {
    }

    @Test
    public void findListTest() {
    }

    @Test
    public void cancelTest() {
    }

    @Test
    public void finishTest() {
    }

    @Test
    public void paidTest() {
    }

}