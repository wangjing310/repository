package com.briup.server;

import java.util.Collection;

import com.briup.bean.Environment;

/**
 * 网络模块，用来接收客户端传递过来的数据
 * @author mx
 *
 */
public interface Server {
	public Collection<Environment> receive() throws Exception;
}
