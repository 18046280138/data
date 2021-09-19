package com.ylz.tcp.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author gwj
 * @since 2021-07-04 12:45
 */

public class TimeClient {
    public static void main(String[] args){
        int port = 8080;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1", port);
            //socket.getInputStream()获取输入流，进行转换，就能读取服务端数据
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //socket.getOutputStream()获取输出流，进行转换，就能向服务器发送数据
            out = new PrintWriter(socket.getOutputStream(), true);
            while(true){
                //发送数据
                out.println("QUERY TIME ORDER");
                //读取数据，读取数据是阻塞方法，会阻塞着，直到数据读取完成或者抛异常或者socket关闭，但是网络中你不知道数据是否读取完成，所以会阻塞着直到连接关闭
                System.out.println("时间请求成功，接收数据如下："+in.readLine());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

