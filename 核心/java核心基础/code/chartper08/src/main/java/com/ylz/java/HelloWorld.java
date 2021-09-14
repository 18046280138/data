package com.ylz.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class HelloWorld {

        static int num = 10;
        public static final int NUMBER = 1;

        public static void main(String[] args) {

            System.out.println(123);
            System.out.println(123);

            System.out.println("HelloWorld.main");
            System.out.println("args = [" + args + "]");

            System.out.println("num = " + num);
        }

}
