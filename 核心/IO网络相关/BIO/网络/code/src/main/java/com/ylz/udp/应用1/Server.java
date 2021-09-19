package com.ylz.udp.应用1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 * @author gwj
 * @since 2021-07-04 13:55
 */

public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建服务端套接字
        DatagramSocket ds = new DatagramSocket(152);//注意指定端口
        //2.创建接受客户端信息的空数据包
        while(true){
            byte [] buf =new byte[1024];
            //如果接收到的数据大于buf长度，则丢弃掉大于部分
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            //3.接受数据
            ds.receive(dp);
            //4.拆分数据
            byte[] data = dp.getData(); //
            //5.获取客户端IP和主机名
            InetAddress ip = dp.getAddress();
            String host = ip.getHostAddress();
            int port = dp.getPort();
            //6.读取数据
//            String info = new String(buf,0,buf.length);
//            System.out.println("来自"+host+"的消息是:"+info);
            String info = new String(data,0,dp.getLength());
            System.out.println("来自ip:"+host+"端口："+port+"的消息是:"+info);
            if("886".equals(info)){
                ds.close();
                //7.关闭套接字
            }
        }
    }
}
