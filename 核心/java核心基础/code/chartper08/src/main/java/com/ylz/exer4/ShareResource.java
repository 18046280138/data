package com.ylz.exer4;

/**
 * @author gwj
 * @since 2021-08-11 21:04
 * 两个线程，A线程打印1-52，B线程打印A-Z，12A34B56C...52Z
 */

public class ShareResource {
    /**
     * 标志位，A=1，B=2
     */
    public int num = 1;

    public synchronized void printA(int j){
        //1、判断
        while(num != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2、干活
        System.out.print(j);
        //3、通知、修改状态位
        if(j%2 == 0){
            num = 2;
            notifyAll();
        }
    }

    public synchronized void printB(int j){
        //1、判断
        while(num != 2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2、干活
        System.out.print((char)j);
        //3、通知、修改状态位
        num = 1;
        notifyAll();
    }
}
