package net;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)throws Exception{
        //1-1000操作系统
        //8080 1521 3306
        //16010  9090 9000  大数据端口
        ServerSocket ss=new ServerSocket(8999);

        System.out.println("服务器已启动，等待接受");
        Socket accept = ss.accept();//等待接受


        BufferedReader in = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        String s = in.readLine();

        System.out.println("客户端发来的消息:"+s);

        PrintWriter out = new PrintWriter(accept.getOutputStream());
        out.println("服务端已接收到消息，请客户端放心");
        out.flush();

        in.close();
        out.close();
        ss.close();

        InetAddress address = accept.getInetAddress();
        String hostAddress = address.getHostAddress();//获得客户端地址
        int port = accept.getPort();
        System.out.println("客户端地址"+hostAddress);
        System.out.println("客户端"+port);


    }


}
