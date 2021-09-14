package com.ylz.java7.非静态内部类;

/**
 * @author gwj
 * @since 2021-07-18 21:29
 */

public class Outer {
    //定义一个实例变量和一个静态变量
    private int a;
    private static int b;
    //定义一个静态方法和一个非静态方法
    public static void say(){}
    public void test(){
        //在外部类中调用内部类的属性和方法
        Inner inner = this.new Inner();
        inner.d = 1;    //通过创建内部类实例来调用内部类属性
        inner.walk();    //通过创建内部类实例来调用内部类方法
    }
    //成员内部类
    public class Inner{
        //定义一个静态常量
        static final int m = 1;
        //在内部类中定义一个静态变量和一个实例变量
        //static int c;                    编译出错
        int d;
        //定义一个匿名代码块和一个静态代码块
        {}
        //static{}                        编译出错
        //定义一个静态方法和一个普通方法
        //public static void go(){}        编译出错
        public void walk(){
            //在内部类中调用外部类的属性和方法
            a = 1;
            b = 1;
            say();
            test();    //内部类可以直接访问外部类的所有属性和方法
        }
    }
}
