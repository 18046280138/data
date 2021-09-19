package com.ylz.tcp;

/**
 * @author gwj
 * @since 2021-07-04 13:40
 */

public class TimeServer {
    public static void main(String[] args){
        int port = 8080;
        AsyncTimeServerHandler timeServer=new AsyncTimeServerHandler (port);
        new Thread(timeServer, "AlO-AsyncTimeServerHandler-001") .start();
    }
}
