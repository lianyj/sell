package com.lianyanjie.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: lyj
 * @since: 2018/9/17
 */
@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = 5661888289810899564L;

    @JsonProperty("id")
    private String productId;

    /** 名字 */
    @JsonProperty("name")
    private String productName;

    /** 单价 */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /** 描述 */
    @JsonProperty("description")
    private String productDescription;

    /** 小图 */
    @JsonProperty("icon")
    private String productIcon;

}
