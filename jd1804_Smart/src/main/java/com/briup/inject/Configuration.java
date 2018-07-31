package com.briup.inject;

import com.briup.client.Client;
import com.briup.client.Gather;
import com.briup.server.DBStore;
import com.briup.server.Server;
import com.briup.util.Log;

public interface Configuration {
	
	public Gather getGather();
	public Client getClient();
	public Server getServer();
	public DBStore getDBStore();
	public Log getLogger();

}
