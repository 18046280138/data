package com.ylz.java2;

/**
 * @author gwj
 * @since 2021-08-04 23:35
 * 同一个.java文件中，只能有一个public类（内部类不算），并且这public类名必须跟文件名一样，可以多个默认权限的类
 * .java中可以没有public权限的类
 */

class Person {
    public void show(){
        System.out.println("hahah");
    }
}
class Humen{
    public void show(){
        System.out.println("hahah");
    }
}
