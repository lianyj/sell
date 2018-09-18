package com.lianyanjie.sell.repository;

import com.lianyanjie.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**功能描述: 类目 数据层
 * @author: lyj
 * @since: 2018/9/13
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {


    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);

    ProductCategory findByCategoryId(Integer categoryId);

}
