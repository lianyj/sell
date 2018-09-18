package com.lianyanjie.sell.repository;

import com.lianyanjie.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: lyj
 * @since: 2018/9/14
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,Integer> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

    ProductInfo findByProductId(String productId);

    Page<ProductInfo> findAll(Pageable pageable);

}
