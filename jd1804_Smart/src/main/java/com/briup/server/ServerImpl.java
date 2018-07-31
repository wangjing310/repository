package com.briup.server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Properties;

import org.apache.log4j.chainsaw.Main;

import com.briup.bean.Environment;
import com.briup.inject.Configuration;
import com.briup.inject.ConfigurationImpl;
import com.briup.inject.WossModual;
import com.briup.util.Log;
import com.briup.util.LogImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ServerImpl extends Thread implements Server,WossModual{
	static ConfigurationImpl configuration=new ConfigurationImpl();
	int port=0;
	
	public Collection<Environment> receive() throws Exception {
		Log log = configuration.getLogger();
		/*Properties p = configuration.properties;
		init(p);*/
		ServerSocket ss=new ServerSocket(port);	
		log.info("服务端已开启，等待接受客户端数据");
		
		Socket accept=ss.accept(); //等待接受		
		InputStream i=accept.getInputStream();		
		ObjectInputStream in=new ObjectInputStream(i);
		Collection<Environment> encoll=(Collection<Environment>) in.readObject();
		
		log.info("接收到客户端数据");
		
		//关闭资源
		in.close();
		ss.close();		
		return encoll;
	}
	
	/**
	 * 注入
	 */
	public void init(Properties p) {
		port=Integer.parseInt(p.getProperty("port"));
		
	}
	   /**
	    * 线程开启
	    */
		public void run() {		
				try {
					configuration.dom();
					Server s= configuration.getServer();			
					DBStore d = configuration.getDBStore();
					Collection<Environment> e = s.receive();
					d.saveDB(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();				
			}
		}
			
	
	/**
	 * 开启服务端
	 * @param args
	 * @throws Exception
	 */
	/*public static void main(String[] args) throws Exception {
		configuration.dom();
		Server s= configuration.getServer();
		DBStore d = configuration.getDBStore();
		Collection<Environment> e = s.receive();
		d.saveDB(e);	
	}*/
}
