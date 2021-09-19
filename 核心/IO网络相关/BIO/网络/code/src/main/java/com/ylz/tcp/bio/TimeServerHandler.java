package com.ylz.tcp.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @author gwj
 * @since 2021-07-04 12:50
 */

public class TimeServerHandler implements Runnable{
    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            //socket.getInputStream()，获取输入流，读取客户端数据，并进行转化
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //socket.getOutputStream(),获取输出流，往客户端写数据
            out = new PrintWriter(socket.getOutputStream(),true);
            String currentTime= null;
            String body = null;
            while(true){
                body = in.readLine();
                if(body == null){
                    break;
                }
                System.out.println("时间服务器收到的命令是："+body);
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"错误数据";
                out.println(currentTime);
            }
            System.out.println("客户端已经关闭。。。");
        } catch (IOException e) {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(out != null){
                out.close();
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}
