package com.lianyanjie.sell.repository;

import com.lianyanjie.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author: lyj
 * @since: 2018/9/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("888");
        orderMaster.setBuyerName("测试2");
        orderMaster.setBuyerPhone("10123456789");
        orderMaster.setBuyerAddress("云发大水");
        orderMaster.setBuyerOpenid("abcd");
        orderMaster.setOrderAmount(BigDecimal.valueOf(2.5));

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenidTest() {
        PageRequest pageable = new PageRequest(0,10);
        Page<OrderMaster> orderMasters = orderMasterRepository.findByBuyerOpenid("abcd",pageable);
        Assert.assertNotEquals(0,orderMasters.getTotalElements());
    }
}