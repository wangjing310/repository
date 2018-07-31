package com.briup.jd1804_Smart;

import java.util.Collection;

import com.briup.bean.Environment;
import com.briup.client.ClientImpl;
import com.briup.client.GatherImpl;
import com.briup.server.DBStoreImpl;
import com.briup.server.ServerImpl;
import com.sun.corba.se.impl.ior.GenericTaggedComponent;
import com.sun.corba.se.pept.transport.Connection;

public class Test {
	public static void main(String[] args) throws Exception {
	     GatherImpl g=new GatherImpl();
	     ClientImpl c=new ClientImpl();
	     ServerImpl s=new ServerImpl();   
	     DBStoreImpl d=new DBStoreImpl();
	     
		 Collection<Environment> coll=g.gather();
		 
		/* c.send(coll);
		 Collection<Environment> sc=s.receive();*/
		 
		 d.saveDB(coll);
		 
		//System.out.println(DBUtil.getConn());
	}
}
