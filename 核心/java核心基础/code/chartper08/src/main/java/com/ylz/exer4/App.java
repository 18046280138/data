package com.ylz.exer4;

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
                for(int i=1;i<=52;i++){
                    shareResource.printA(i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<26;i++){
                    shareResource.printB(i+65);
                }
            }
        }).start();
    }
}
