package com.lianyanjie.sell.service;

import com.lianyanjie.sell.dataobject.ProductCategory;

import java.util.List;

/**
 *  卖家端订单商品和商品分类
 * @author: lyj
 * @since: 2018/9/14
 */
public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
