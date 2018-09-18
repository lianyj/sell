package com.lianyanjie.sell.utils;

import java.util.Random;

/**
 * 生成随机数工具
 * @author: lyj
 * @since: 2018/9/18
 */
public class KeyUtil {

    /**
     * 功能描述: 生成唯一的主键（格式：时间 + 6位随机数）
     * synchronized：在多线程下保证唯一性
     * <p>
     * 作者: luohongquan
     * 日期: 2018/5/4 0004 15:16
     * @param: []
     * @return: java.lang.String
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000; // 生成6位数

        return System.currentTimeMillis() + String.valueOf(number);
    }
}