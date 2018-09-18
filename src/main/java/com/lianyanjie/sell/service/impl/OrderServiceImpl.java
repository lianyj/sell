package com.lianyanjie.sell.service.impl;

import com.lianyanjie.sell.dataobject.OrderDetail;
import com.lianyanjie.sell.dataobject.OrderMaster;
import com.lianyanjie.sell.dataobject.ProductInfo;
import com.lianyanjie.sell.dto.CartDTO;
import com.lianyanjie.sell.dto.OrderDTO;
import com.lianyanjie.sell.enums.OrderStatusEnum;
import com.lianyanjie.sell.enums.PayStatusEnum;
import com.lianyanjie.sell.enums.ResultEnum;
import com.lianyanjie.sell.excpetion.SellException;
import com.lianyanjie.sell.repository.OrderDetailRepository;
import com.lianyanjie.sell.repository.OrderMasterRepository;
import com.lianyanjie.sell.service.OrderService;
import com.lianyanjie.sell.service.ProductInfoService;
import com.lianyanjie.sell.service.WebSocket;
import com.lianyanjie.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * 订单Service实现
 * @author: lyj
 * @since: 2018/9/18
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;

//    @Autowired
//    private PayService payService;
//    @Autowired
//    private PushMessageService pushMessageService;
    @Autowired
    private WebSocket webSocket;


    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = UUID.randomUUID().toString().replace("-","");
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        // 1. 查询商品（数量，单价）
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if(null == productInfo){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            // 2. 计算总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            // 3. 订单详情入库
            BeanUtils.copyProperties(productInfo,orderDetail);
            String detailId = UUID.randomUUID().toString().replace("-","");
            orderDetail.setDetailId(detailId);
            orderDetail.setOrderId(orderId);
            orderDetailRepository.save(orderDetail);

        }

        // 4. 写入订单数据库（orderMaster和orderDetail）
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        // BeanUtils.copyProperties会copy null值 所以先要copy
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderAmount(orderAmount);
        orderMasterRepository.save(orderMaster);
        // 4. 扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e->new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

//        // 5. 下订单后，发送websocket消息
//        webSocket.sendMessage("有新的订单");

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        return null;
    }
}
