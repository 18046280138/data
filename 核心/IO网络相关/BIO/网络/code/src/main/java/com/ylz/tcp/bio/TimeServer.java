package com.ylz.tcp.bio;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gwj
 * @since 2021-07-04 12:49
 */

public class TimeServer {
    public static void main(String[] args){
        int port = 8080;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("时间服务器开启端口："+port);
            Socket socket = null;
            while (true){
                //阻塞，直到有连接进来，就创建一个Socket
                socket = serverSocket.accept();
                //一有连接，就创建一个线程处理
                new Thread(new TimeServerHandler(socket)).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                    System.out.println("时间服务器关闭");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
