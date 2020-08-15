package net;

import java.io.*;
import java.net.Socket;

public class Client {

    /**
     *  简单的Socket客户端
     *  功能为：发送字符串“Hello”到服务器端，并打印出服务器端的反馈
     */
    public static void main(String[] args)throws IOException {
        System.out.println("客户端准备建立连接");
        Socket s=new Socket("localhost",8999);
        PrintWriter out= new PrintWriter(s.getOutputStream());
        out.println("你好，我是客户端");
        out.flush();

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String s1 = in.readLine();

        System.out.println("服务端发送回来的数据:"+s1);

        in.close();
        out.close();
        s.close();

    }



}
