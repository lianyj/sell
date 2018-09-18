package com.lianyanjie.sell.dataobject;

import com.lianyanjie.sell.enums.OrderStatusEnum;
import com.lianyanjie.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**功能描述: 订单主表
 * @author: lyj
 * @since: 2018/9/17
 */
@DynamicUpdate
@Entity
@Data
public class OrderMaster implements Serializable {

    private static final long serialVersionUID = 2085005502702055500L;
    /** 订单id */
    @Id
    private String orderId;

    /** 买家名字 */
    private String buyerName;

    /** 买家电话 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信openid */
    private String buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态，0：新下单（默认）1：已完成 2：取消 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态，0：未支付（默认）1：已支付 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    @Transient
    private List<OrderDetail> orderDetailList;

    public OrderMaster() {

    }
}
