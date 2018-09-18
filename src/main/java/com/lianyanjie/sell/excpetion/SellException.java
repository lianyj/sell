package com.lianyanjie.sell.excpetion;

import com.lianyanjie.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @author: lyj
 * @since: 2018/9/18
 */
@Getter
public class SellException  extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
