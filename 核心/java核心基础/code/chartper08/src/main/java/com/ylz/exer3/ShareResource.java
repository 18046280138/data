package com.ylz.exer3;

/**
 * @author gwj
 * @since 2021-08-11 21:04
 * 三个线程A、B、C，按顺序打印出我是A、我是B、我是C，循环5次
 */

public class ShareResource {
    /**
     * 标志位，A=1，B=2,C=3
     */
    public int num = 1;

    public synchronized void printA(){
        //1、判断
        while(num != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2、干活
        System.out.println("我是A");
        //3、通知、修改状态位
        num = 2;
        notifyAll();
    }

    public synchronized void printB(){
        //1、判断
        while(num != 2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2、干活
        System.out.println("我是B");
        //3、通知、修改状态位
        num = 3;
        notifyAll();
    }

    public synchronized void printC(){
        //1、判断
        while(num != 3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2、干活
        System.out.println("我是C");
        //3、通知、修改状态位
        num = 1;
        notifyAll();
    }
}
