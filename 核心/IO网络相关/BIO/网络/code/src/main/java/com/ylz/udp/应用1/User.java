package com.ylz.udp.应用1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author gwj
 * @since 2021-07-04 13:53
 */

public class User {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //1.创建客户端套接字
        DatagramSocket ds = new DatagramSocket();
        //2.创建客户端发送数据包
        while (true) {
            System.out.println("请输入要发送的信息：");
            String info = sc.nextLine();
            byte[] buf = info.getBytes();
            DatagramPacket dp = new DatagramPacket(buf, buf.length,
                    InetAddress.getByName("localhost"), 152);
            //3.发送数据包
            ds.send(dp);
            //4.结束发送循环
            if ("886".equals(info)) {
                break;
            }
        }
        //5.关闭套接字
        ds.close();
    }
}
