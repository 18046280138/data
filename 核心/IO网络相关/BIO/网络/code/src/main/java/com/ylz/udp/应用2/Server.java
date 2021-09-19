package com.ylz.udp.应用2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

/**
 * @author gwj
 * @since 2021-07-04 13:55
 */

public class Server {
    public static void main(String args[]){
        //Socket对象.端口3000
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(3000);
            System.out.println("等待接收数据......");
            while (true) {
                byte buf[] = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                //阻塞住，等待数据
                socket.receive(packet);

                //获取ip、port
                InetAddress ip = packet.getAddress();
                int port = packet.getPort();
                System.out.println("已接收来自" + ip.getHostAddress() + ":" + port + "的数据:"+new String(packet.getData()));

                String date = new Date(System.currentTimeMillis()).toString();
                buf = date.getBytes();
                packet = new DatagramPacket(buf, buf.length, ip, port);
                socket.send(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}
