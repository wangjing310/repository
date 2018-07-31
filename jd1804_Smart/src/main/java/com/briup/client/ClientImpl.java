package com.briup.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Properties;

import org.apache.log4j.chainsaw.Main;

import com.briup.bean.Environment;
import com.briup.inject.Configuration;
import com.briup.inject.ConfigurationImpl;
import com.briup.inject.WossModual;
import com.briup.server.DBStoreImpl;
import com.briup.server.ServerImpl;
import com.briup.util.Log;
import com.briup.util.LogImpl;
import com.sun.media.jfxmedia.logging.Logger;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.client.SenderException;
import com.sun.xml.internal.ws.util.InjectionPlan;

public class ClientImpl extends Thread implements Client,WossModual{	
	static ConfigurationImpl configuration=new ConfigurationImpl();
	String ip;
	int port;
	
	public void send(Collection<Environment> coll) throws Exception {
		Log log = configuration.getLogger();		
		
		Socket socket=new Socket(ip, port);	
		OutputStream o=socket.getOutputStream();
		ObjectOutputStream out=new ObjectOutputStream(o);  //将对象序列化
		out.writeObject(coll);	
		log.info("客户端已发送数据到服务端");			
		
		//关闭资源
		out.close();
		socket.close();
	}
	
	/**
	 * 注入
	 */
	public void init(Properties p) {
		ip=p.getProperty("ip");
		port=Integer.parseInt(p.getProperty("port"));	
	}
	
	
	public void run(){
		 try {
			// Thread.sleep(20);
			configuration.dom();
			Gather g = configuration.getGather();
			 //System.out.println(g);
			 Client c = configuration.getClient();	
		     Collection<Environment> coll = g.gather();			
			 c.send(coll);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
	}
	
	
	
	/**
	 * 开启客户端
	 * @param args
	 * @throws Exception
	 */
/*	public static void main(String[] args) throws Exception {
		 configuration.dom();
		 Gather g = configuration.getGather();
		 //System.out.println(g);
		 Client c = configuration.getClient();	 
		 Collection<Environment> coll = g.gather();
		 c.send(coll);			 
	}*/
}
