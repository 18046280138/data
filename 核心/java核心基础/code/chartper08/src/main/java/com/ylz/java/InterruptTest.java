package com.ylz.java;

/**
 * @author gwj
 * @since 2021-09-01 22:42
 */

public class InterruptTest {
    public static void main(String[] args){
        Share share = new Share();
        Thread thread = new Thread(share);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("该线程执行完interrupt了");
    }
}

class Share implements Runnable{
    @Override
    public void run() {
        System.out.println("淫荡分割线--------------------------");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("该线程执行了interrupt了，抛出异常了");
        }
    }
}
