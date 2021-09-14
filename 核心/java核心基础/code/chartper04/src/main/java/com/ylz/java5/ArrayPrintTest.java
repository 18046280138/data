package com.ylz.java5;

public class ArrayPrintTest {
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3};
		System.out.println(arr);//地址值

		char[] arr1 = new char[]{'a','b','c'};
		System.out.println(arr1); //abc，直接打印值
		/**
		 * 原因：println方法重载，调用的是不同的方法
		 */
		char[] arr2 = new char[]{'a','b','c'};
		System.out.println(arr2+"--"); //打印地址
	}
}
