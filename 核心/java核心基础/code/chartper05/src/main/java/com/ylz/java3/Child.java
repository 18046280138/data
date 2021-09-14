package com.ylz.java3;

/**
 * @author gwj
 * @since 2021-08-07 11:20
 */

public class Child extends Student{
    @Override
    public void eat() {
        super.eat();
        super.personEat();
        super.name = "ggg"; //间接父类，所以super不局限于直接父类
    }
}
