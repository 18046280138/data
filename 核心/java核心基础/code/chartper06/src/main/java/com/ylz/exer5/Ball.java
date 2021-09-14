package com.ylz.exer5;

import javax.swing.*;

/**
 * @author gwj
 * @since 2021-08-08 19:26
 */

public class Ball implements Rollable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ball(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        Ball ball = new Ball("Football");
        System.out.println(ball.getName());
    }
}
