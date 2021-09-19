package com.ylz.pipe;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.Pipe;
import java.util.Date;

public class PipeDemo {

    public static void main(String[] args) throws IOException {
        //1 获取管道
        Pipe pipe = Pipe.open();

        //2 获取sink通道
        Pipe.SinkChannel sinkChannel = pipe.sink();

        //3 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("atguigu".getBytes());
        byteBuffer.flip();

        //4 写入数据
        sinkChannel.write(byteBuffer);

        //5 获取source通道
        Pipe.SourceChannel sourceChannel = pipe.source();

        //6 读取数据
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);

        //byteBuffer.flip();

        int length = sourceChannel.read(byteBuffer2);

        System.out.println(new String(byteBuffer2.array(),0,length));

        //7 关闭通道
        sourceChannel.close();
        sinkChannel.close();
    }

}
