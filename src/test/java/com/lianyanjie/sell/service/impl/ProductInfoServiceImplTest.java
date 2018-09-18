package com.lianyanjie.sell.service.impl;

import com.lianyanjie.sell.dataobject.ProductCategory;
import com.lianyanjie.sell.dataobject.ProductInfo;
import com.lianyanjie.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: lyj
 * @since: 2018/9/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findOne() {

        ProductInfo productInfo = productInfoService.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }


    @Test
    public void findUpAll() {
        List<ProductInfo> productInfos = productInfoService.findUpAll();
        Assert.assertNotEquals(0,productInfos.size());
    }

    @Test
    public void findAll() {
        PageRequest pageable = new PageRequest(0,2);
        Page<ProductInfo> productInfos = productInfoService.findAll(pageable);
        System.out.println(productInfos.getTotalElements());

    }


    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("888");
        productInfo.setProductName("鱼");
        productInfo.setProductPrice(BigDecimal.valueOf(8));
        productInfo.setProductStock(10);
        productInfo.setProductDescription("新鲜的");
        productInfo.setProductStatus(1);
        productInfo.setProductIcon("http://www.baidu.com");
        productInfo.setCategoryType(888);
        ProductInfo result =productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }



}