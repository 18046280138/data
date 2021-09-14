package com.ylz.java3;

/**
 * @author gwj
 * @since 2021-08-08 18:15
 *
 * final修饰的属性
 * 1、实例变量：只能且必须在显示初始化、代码块、构造器中的某一个初始化，没有默认初始化值
 * 2、类变量：只能且必须在显示初始化、代码块中的某一个初始化，没有默认初始化值
 */

public class FinalTest2 {
    final String name  = "gwj";
    static final int age;
    static {
        age = 12;
    }

    public FinalTest2() {
        //age = 13;
    }
}
