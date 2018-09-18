package com.lianyanjie.sell.enums;

import lombok.Getter;

/**
 * @author: lyj
 * @since: 2018/9/17
 */
@Getter
public enum  PayStatusEnum implements CodeEnum{

    WAIT(0, "未支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
