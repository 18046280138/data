package com.ylz.udp.应用2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

/**
 * @author gwj
 * @since 2021-07-04 13:53
 */

public class User2 {
    public static void main(String args[]) {
        DatagramPacket sendPacket = null;
        DatagramPacket revPacket = null;
        DatagramSocket socket = null;
        byte[] rev = new byte[256];//存放接收数据
        byte[] send = new byte[256];//存放发送数据
        try {
            //创建要收发的数据报
            sendPacket = new DatagramPacket(send, send.length, InetAddress.getByName("127.0.0.1"), 3000);
            revPacket = new DatagramPacket(rev, rev.length);
            //创建用于通信的Socket对象
            socket = new DatagramSocket();
            while (true){
                String str = "请求" + new Random().nextInt(100);
                send = str.getBytes();
                sendPacket.setData(send);
                sendPacket.setLength(send.length);
                //发送数据报
                socket.send(sendPacket);
                //创建接收的数据报

                socket.receive(revPacket);//接收数据报,存放到packet中
                String time = new String(revPacket.getData());//获取数据报中的数据内容
                System.out.println("侦听主机的当前日期为:" + time);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();//释放Socket
        }
    }
}
