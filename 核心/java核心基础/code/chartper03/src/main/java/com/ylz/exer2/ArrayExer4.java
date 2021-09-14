package com.ylz.exer2;

import java.util.Arrays;
import java.util.Random;

/**
 * @author gwj
 * @since 2021-08-08 9:52
 */

public class ArrayExer4 {
    public static void main(String[] args){
        int[] arr = new int[6];
        int flag = 0;
        while (flag < 6){
            Random random = new Random();
            int i = random.nextInt(29)+1;
            //判断是否已经存在
            boolean index = true;
            for(int j = 0;j<flag;j++){
                if(i==arr[j]){
                    index = false;
                    break;
                }
            }
            if(index){
                //不重复
                arr[flag] = i;
            }
            flag ++;
        }

        //打印数据
        System.out.println(Arrays.toString(arr));
    }
}
