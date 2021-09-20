package com.ylz.tcp;

import java.io.IOException;
/**
 * @author gwj
 * @since 2021-07-04 13:40
 */

public class TimeClient {
    public static void main(String[] args) throws IOException {
        int port=8080;
        new Thread(new AsyncTimeClientHandler("127.0.0.1",port),"AIOClient").start();
    }
}

