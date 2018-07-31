package com.briup.main;

import org.apache.log4j.chainsaw.Main;

import com.briup.client.ClientImpl;
import com.briup.server.Server;
import com.briup.server.ServerImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ThreadRun {
	
	public static void main(String[] args) {
	
			Thread server=new ServerImpl();
			Thread client=new ClientImpl();
			
			server.start();
			client.start();
		
		
	}
	
	
	

}
