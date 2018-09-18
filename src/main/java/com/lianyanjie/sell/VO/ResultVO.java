package com.lianyanjie.sell.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * @author: lyj
 * @since: 2018/9/17
 */
@Data
public class ResultVO<T> implements Serializable {


    private static final long serialVersionUID = -3578716716090508080L;

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体内容 */
    private T data;

}
