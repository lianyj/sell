package com.lianyanjie.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: lyj
 * @since: 2018/9/17
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = 7875126696687241250L;

    // 序列化返回前端后显示为name，而不是categoryName;
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
