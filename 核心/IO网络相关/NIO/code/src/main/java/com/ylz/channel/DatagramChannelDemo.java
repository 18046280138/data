package com.ylz.channel;

import org.junit.jupiter.api.Test;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class DatagramChannelDemo {

    //发送的实现
    @Test
    public void sendDatagram() throws Exception {
        //打开 DatagramChannel
        DatagramChannel sendChannel = DatagramChannel.open();
        InetSocketAddress sendAddress =
                new InetSocketAddress("127.0.0.1",9999);
        //发送
        while(true) {
            ByteBuffer buffer = ByteBuffer.wrap("发送atguigu".getBytes("UTF-8"));
            sendChannel.send(buffer,sendAddress);
            System.out.println("已经完成发送");
            Thread.sleep(1000);
        }
    }

    //接收的实现
    @Test
    public void receiveDatagram() throws Exception {
        //打开DatagramChannel
        DatagramChannel receiveChannel = DatagramChannel.open();
        InetSocketAddress receiveAddress = new InetSocketAddress(9999);
        //绑定
        receiveChannel.bind(receiveAddress);

        //buffer
        ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
        /**
         * 设置是否阻塞，如果不阻塞，会报空指针异常
         */
        receiveChannel.configureBlocking(true);

        //接收
        while(true) {
            receiveBuffer.clear();

            //是否阻塞，阻塞状态的话，会在这里阻塞
            SocketAddress socketAddress = receiveChannel.receive(receiveBuffer);
            System.out.println("接收到数据");

            receiveBuffer.flip();

            System.out.println(socketAddress.toString());

            System.out.println(Charset.forName("UTF-8").decode(receiveBuffer));
            Thread.sleep(2000);
            ByteBuffer buffer = ByteBuffer.wrap("回复".getBytes("UTF-8"));
            receiveChannel.send(buffer,socketAddress);
        }
    }

    //连接  read  和 write
    @Test
    public void testConnect() throws Exception {
        //打开DatagramChannel
        DatagramChannel connChannel = DatagramChannel.open();
        //绑定
        connChannel.bind(new InetSocketAddress(9998));

        //连接，只接受和发送9999的数据包
        connChannel.connect(new InetSocketAddress("127.0.0.1",9999));
        connChannel.configureBlocking(false);
        //write方法
        connChannel.write(ByteBuffer.wrap("发送atguigu".getBytes("UTF-8")));

        //buffer
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);

        while(true) {

            readBuffer.clear();

            System.out.println("准备接收数据...");
            //阻塞模式的话，会阻塞,非阻塞的话就不会阻塞到这里
            connChannel.read(readBuffer);

            readBuffer.flip();
            System.out.println(Charset.forName("UTF-8").decode(readBuffer));

        }
    }

}
