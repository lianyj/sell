package com.lianyanjie.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 功能描述: 订单详情表
 * @author: lyj
 * @since: 2018/9/17
 */
@DynamicUpdate
@Entity
@Data
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = -6918418999418984007L;
    /** 订单详情ID */
    @Id
    private String detailId;

    /** 订单id */
    private String orderId;

    /** 商品id */
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 商品价格 */
    private BigDecimal productPrice;

    /** 商品数量 */
    private Integer productQuantity;

    /** 商品小图 */
    private String productIcon;

    public OrderDetail() {

    }
}
