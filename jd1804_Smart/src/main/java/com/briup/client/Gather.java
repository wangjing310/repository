package com.briup.client;

import java.util.Collection;
import java.util.Properties;

import com.briup.bean.Environment;

/**
 * 采集
 * @author mx
 *
 */
public interface Gather {
	public Collection<Environment> gather() throws Exception;

}
