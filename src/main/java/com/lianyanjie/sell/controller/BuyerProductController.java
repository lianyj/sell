package com.lianyanjie.sell.controller;

import com.lianyanjie.sell.VO.ProductInfoVO;
import com.lianyanjie.sell.VO.ProductVO;
import com.lianyanjie.sell.VO.ResultVO;
import com.lianyanjie.sell.dataobject.ProductCategory;
import com.lianyanjie.sell.dataobject.ProductInfo;
import com.lianyanjie.sell.service.ProductCategoryService;
import com.lianyanjie.sell.service.ProductInfoService;
import com.lianyanjie.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** 买家商品
 * @author: lyj
 * @since: 2018/9/17
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService categoryService;

    /**
     * 商品列表
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultVO productList(){

        // 1. 查询所有上架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        // 2. 查询类目（一次性查询）
//        List<Integer> categoryTypeList = new ArrayList<Integer>();
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }

        // 精简方法（Java8，lambda）
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e->e.getCategoryType())
                .collect(Collectors.toList());

        // 3. 数据拼装
        ResultVO rest = new ResultVO();
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        for (ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<ProductInfoVO>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }

}
