package com.lianyanjie.sell.controller;

import com.lianyanjie.sell.VO.ResultVO;
import org.springframework.web.bind.annotation.*;

/**
 * @author: lyj
 * @since: 2018/9/17
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {





    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResultVO create(){
        ResultVO rest = new ResultVO();

        return rest;
    }

//    name: "张三"
//    phone: "18868822111"
//    address: "慕课网总部"
//    openid: "ew3euwhd7sjw9diwkq" //用户的微信openid
//    items: [{
//        productId: "1423113435324",
//                productQuantity: 2 //购买数量
//    }]
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ResultVO detail(){
        ResultVO rest = new ResultVO();

        return rest;
    }

    /**
     * 订单列表
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultVO list(@RequestParam String openid,@RequestParam Integer page,@RequestParam Integer size){
        ResultVO rest = new ResultVO();

        return rest;

    }

    @RequestMapping(value = "/cancel",method = RequestMethod.POST)
    public ResultVO cancel(){
        ResultVO rest = new ResultVO();

        return rest;
    }


}
