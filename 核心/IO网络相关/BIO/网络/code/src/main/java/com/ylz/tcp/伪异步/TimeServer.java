package com.ylz.tcp.伪异步;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gwj
 * @since 2021-07-04 13:15
 */

public class TimeServer {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port : " + port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(
                    50, 10000);// 创建IO任务线程池
            while (true) {
                //阻塞，直到接收到连接
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (server != null) {
                System.out.println("The time server close");
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
