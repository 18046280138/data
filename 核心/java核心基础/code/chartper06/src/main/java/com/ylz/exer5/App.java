package com.ylz.exer5;

/**
 * @author gwj
 * @since 2021-08-08 19:29
 */

public class App {
    public static void main(String[] args){
        Ball ball = new Ball("篮球");
        ball.play();
        System.out.println(ball.ball.getName());
        ball.ball.play();
    }
}
