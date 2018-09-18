package com.lianyanjie.sell.service;

import com.lianyanjie.sell.dataobject.ProductCategory;
import com.lianyanjie.sell.dataobject.ProductInfo;
import com.lianyanjie.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author: lyj
 * @since: 2018/9/14
 */
public interface ProductInfoService {

    ProductInfo findOne(String productId);

    /**
     * 查询在线商品
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    List<ProductInfo> findByProductStatus(Integer productStatus);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);


    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

}
