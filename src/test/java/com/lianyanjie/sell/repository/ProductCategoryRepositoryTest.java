package com.lianyanjie.sell.repository;

import com.lianyanjie.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: lyj
 * @since: 2018/9/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest() {

        ProductCategory productCategory = productCategoryRepository.findByCategoryId(2);
//        productCategory.setCategoryType(3);
//        productCategory.setCategoryName("男生最爱");
//        productCategoryRepository.save(productCategory);
        System.out.println(productCategory.toString());
    }


    @Test
    @Transactional  // 4)测试类中的@Transaction不同与service中的，测试方法中的数据会完全回滚
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("女生最爱", 3);
        ProductCategory result = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null, result);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(1,3,5,6);

        List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }
}