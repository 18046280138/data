package com.ylz;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author gwj
 * @since 2021-10-24 10:33
 */

public class BCryptPasswordEncoderTest {
    public static void main(String[] args){
        // 创建密码解析器
        BCryptPasswordEncoder bCryptPasswordEncoder = new
                BCryptPasswordEncoder();
        // 对密码进行加密
        String atguigu = bCryptPasswordEncoder.encode("123456");
        // 打印加密之后的数据
        System.out.println("加密之后数据： \t"+atguigu);
        //判断原字符加密后和加密之前是否匹配
        boolean result = bCryptPasswordEncoder.matches("atguigu", atguigu);
        // 打印比较结果
        System.out.println("比较结果： \t"+result);
    }
}
