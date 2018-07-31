package com.briup.util;
/**
 * 日志
 * @author mx
 *
 */
public interface Log {
	public void debug(String message);
	public void info(String message);
	public void warn(String message);
	public void error(String message);
	public void fatal(String message);
}
