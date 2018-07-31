package com.briup.server;

import java.util.Collection;

import com.briup.bean.Environment;

/**
 * 存数据
 * @author mx
 *
 */
public interface DBStore {
	void saveDB(Collection<Environment > c)throws Exception;

}
