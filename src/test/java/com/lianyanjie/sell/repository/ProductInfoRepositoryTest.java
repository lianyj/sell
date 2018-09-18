package com.lianyanjie.sell.repository;

import com.lianyanjie.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author: lyj
 * @since: 2018/9/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private  ProductInfoRepository productInfoRepository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("熊掌");
        productInfo.setProductPrice(BigDecimal.valueOf(1001));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("美味的");
        productInfo.setProductStatus(0);
        productInfo.setProductIcon("http://www.baidu.com");
        productInfo.setCategoryType(12345);
        ProductInfo result =productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);

    }


    @Test
    public void findByProductStatus() {

        List<ProductInfo> result = productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0, result.size());
    }
}