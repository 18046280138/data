package com.ylz.exer4;

/**
 * @author gwj
 * @since 2021-08-08 19:17
 */

public class C extends B implements A{
    public static void main(String[] args){
        new C().px();
    }
    public void px(){
        //出现歧义，
        //System.out.println(x);
    }
}
