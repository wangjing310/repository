package com.briup.inject;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.briup.bean.Environment;
import com.briup.client.Client;
import com.briup.client.Gather;
import com.briup.server.DBStore;
import com.briup.server.Server;
import com.briup.util.Log;

public class ConfigurationImpl implements Configuration{
	static ConfigurationImpl configuration=new ConfigurationImpl();
	
	public static Map<String, WossModual> map = new HashMap<String,WossModual>();
    public Properties properties = new Properties();
	
	public void dom()throws Exception{
		//获取DocumentBuilderFactory实例对象
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		//创建文档创建器
		DocumentBuilder builder=factory.newDocumentBuilder();
		//通过DocumentBuilder对象的parser方法加载inject.xml文件到当前项目下
		Document document=builder.parse(new File("/jd1804_Smart/src/main/java/com/briup/inject/inject.xml")); //document是入口
		//获取根元素名称
		Element root=document.getDocumentElement();
		//System.out.println("根节点名字"+root);
		
		//获取所有节点的集合
		//NodeList nodeList =document.getChildNodes();
		NodeList nodeList= document.getElementsByTagName("class");
		for(int i=0;i<nodeList.getLength();i++){
			Node node=nodeList.item(i);  //item()获得一个class节点
			
			//System.out.println("节点名"+node);
			NamedNodeMap attrs = node.getAttributes();  //获得class节点属性
			Node attr=attrs.item(0);
			String sname=attr.getNodeName();
			String svalue=attr.getNodeValue();
			//System.out.println("属性名:"+sname+"属性值:"+svalue);
			WossModual wossModual = (WossModual) Class.forName(svalue).newInstance();
			map.put(sname,wossModual);			
			
			//解析class节点的子节点
            NodeList childList=node.getChildNodes();
            for(int j=0;j<childList.getLength();j++){
            	if(childList.item(j).getNodeType()==Node.ELEMENT_NODE){
            		String nodeName=childList.item(j).getNodeName();
            		String nodeValue=childList.item(j).getFirstChild().getNodeValue(); 
            		//System.out.println("节点名:"+nodeName+"节点值"+nodeValue);
            		properties.put(nodeName, nodeValue);
            	}
            }
            wossModual.init(properties);
		}//while循环
	}
	
    /**
     * 配置实现
     */
	public  Log getLogger() {
		Log log = (Log) map.get("log");
		return log;
	}
	

	public Gather getGather() {
		Gather gather=(Gather) map.get("gather");
		return gather;
	}

	public Client getClient() {
		Client client=(Client) map.get("client");
		return client;
	}

	public Server getServer() {
		Server server=(Server) map.get("server");
		return server;
	}

	public DBStore getDBStore() {
		DBStore dbStore=(DBStore) map.get("dbstore");
		return dbStore;
	}
	
	
	/**
	 * 测试类
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		 configuration.dom();
		 Gather g = configuration.getGather();
		 System.out.println(g);
		 
		 Collection<Environment> gather = g.gather();
		 System.out.println("测试类对象"+g);
		 for (Environment s : gather) {
			 System.out.println(s);			
		}
		
		}
}
