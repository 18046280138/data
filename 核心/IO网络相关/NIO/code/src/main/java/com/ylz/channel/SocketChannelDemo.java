package com.ylz.channel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {

    public static void main(String[] args) throws Exception {
        //创建SocketChannel
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("www.baidu.com", 80));

//        SocketChannel socketChanne2 = SocketChannel.open();
//        socketChanne2.connect(new InetSocketAddress("www.baidu.com", 80));

        //设置阻塞和非阻塞
        socketChannel.configureBlocking(true);

        //读操作
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        /**
         * 非阻塞：不会阻塞，会往下执行
         * 阻塞：  会阻塞，卡在这里，除非有数据读到
         */
        socketChannel.read(byteBuffer);
        socketChannel.close();
        System.out.println("read over");

    }

}
