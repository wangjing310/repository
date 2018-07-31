package com.briup.client;

import java.util.Collection;

import com.briup.bean.Environment;

/**
 * 网络模块，收集采集过来的数据，发送给服务器端
 * @author mx
 *
 */
public interface Client {
	public void send(Collection<Environment> coll) throws Exception;
}
