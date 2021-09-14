package com.ylz.exer3;

/**
 * @author gwj
 * @since 2021-08-11 21:04
 */

public class App {
    public static void main(String[] args){
        ShareResource shareResource = new ShareResource();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    shareResource.printA();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    shareResource.printB();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    shareResource.printC();
                }
            }
        }).start();
    }
}
