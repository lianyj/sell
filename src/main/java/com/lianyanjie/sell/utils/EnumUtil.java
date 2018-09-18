package com.lianyanjie.sell.utils;

import com.lianyanjie.sell.enums.CodeEnum;

/**
 * 功能描述: 枚举工具类
 * @author: lyj
 * @since: 2018/9/18
 */
public class EnumUtil {

    /**
     * 根据code和枚举类返回响应的枚举
     * @param code
     * @param enumClass
     * @param <T>
     * @return
     */
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
