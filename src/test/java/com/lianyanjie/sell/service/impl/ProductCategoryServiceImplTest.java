package com.lianyanjie.sell.service.impl;

import com.lianyanjie.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author: lyj
 * @since: 2018/9/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl productService;

    @Test
    public void findOne() {
        ProductCategory productCategory = productService.findOne(1);
        Assert.assertEquals(1,productCategory.getCategoryId().intValue());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productInfoList = productService.findAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1,3,5,6);
        List<ProductCategory> result = productService.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("女生最爱LYJ", 12345);
        ProductCategory result = productService.save(productCategory);
        Assert.assertNotNull(result);
    }
}