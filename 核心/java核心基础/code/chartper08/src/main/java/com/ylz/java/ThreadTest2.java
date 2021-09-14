package com.ylz.java;

/**
 * @author gwj
 * @create 2019-02-13 下午 4:34
 */
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("我是runnable。。。");
    }
}

class MyThread3 extends Thread{
    public MyThread3(Runnable target) {
        super(target);
    }

    @Override
    public void run() {
        System.out.println("我是thread。。。");
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        /**
         * 当thread和runnable都实现run方法时，thread优先，看Thread.run()源码，有thread之后就覆盖了原本代码（即target.run()）
         */
        MyRunnable myRunnable = new MyRunnable();
        Thread t = new MyThread3(myRunnable);
        t.start();
    }

}
