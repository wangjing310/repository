package com.briup.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.chainsaw.Main;

import com.briup.bean.Environment;
import com.briup.inject.Configuration;
import com.briup.inject.ConfigurationImpl;
import com.briup.inject.WossModual;
import com.briup.util.Log;
import com.briup.util.LogImpl;
import com.sun.media.jfxmedia.logging.Logger;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor;

public class GatherImpl implements Gather,WossModual{
	static ConfigurationImpl configuration=new ConfigurationImpl();
	List<Environment> list=new ArrayList<Environment>();
	Environment environment1=null;
	//Environment environment2=new Environment();
	float temperature;
	float humidity;
	int sum=0,tnum=0,hnum=0,cnum=0,lnum=0;
	String readfile=null,writefile=null;
	
	/**
	 * 采集数据
	 * @author wang
	 */
	public Collection<Environment> gather() throws Exception {
		Log log = configuration.getLogger();		
		
		//读取文件，用字符流，因为只有字符流才有readLine		
		FileReader in=new FileReader(readfile);	
		BufferedReader bufRead=new BufferedReader(in);	
		
		//备份文件
		File file=new File(writefile);	//写文件，即使没有该文件目录，也会创建文件写进去，读文件，没有该文件，就会找不到文件目录报错	
		FileWriter out=new FileWriter(file,true);//写了true就不会从新创建一个文件。
		BufferedWriter bufWrite=new BufferedWriter(out);
			 
		/*if(file.exists()&&file.isFile()){
			long ls=file.length();
			System.out.println("file length:"+ls);
		}
		else
			{System.out.println("文件不存在");}*/
		
		long ls=file.length();
		//long ls2=
		//log.info(message);
	    log.info("备份文件长度:"+ls);
		//buf.skip(ls);
		
		String s;		
		while((s=bufRead.readLine())!=null){
			  sum++; 
			  
			  bufWrite.write(s);   //写入到备份文件             
              bufWrite.newLine();  //写完之后换行	              

			String date[]=s.split("[|]"); //切分字符串	
			
			//每次都要创建一个对象，因为一个对象对应一个引用地址，不然会被后面的值覆盖掉!!!!!			
			environment1=new Environment();
		
			environment1.setSrcId(date[0]);
			environment1.setDstId(date[1]);
			environment1.setDevId(date[2]);
			environment1.setSersorAddress(date[3]);
			environment1.setCount(Integer.parseInt(date[4]));
			environment1.setCmd(date[5]);			
			environment1.setStatus(Integer.parseInt(date[7]));
		
			//将string类型转换成long类型，再通过Timestamp(long time)构造器转换成timestamp对象
			Long l=Long.parseLong(date[8]);			
			Timestamp time=new Timestamp(l);
			//System.out.println("SHISJIAN"+time.getDate());
			environment1.setGather_date(time);
			
			if(date[3].equals("16")){
				//温度((float)value＊0.00268127)-46.85
			    int tem=Integer.parseInt(date[6].substring(0, 4),16);  //截取字符串，转换成int类型,16进制				
				temperature=(float)(tem*0.00268127-46.85);
				//System.out.println(temperature);
				tnum++;
				
				environment1.setName("温度");
				environment1.setData(temperature);
				list.add(environment1);
				
				environment1=new Environment();
				// 湿度:((float)value*0.00190735)-6				
				int hum=Integer.parseInt(date[6].substring(4, 8),16);
				humidity=(float)(hum*0.00190735-6);
				hnum++;
				
				environment1.setName("湿度");	
				environment1.setData(humidity);
				environment1.setSrcId(date[0]);
				environment1.setDstId(date[1]);
				environment1.setDevId(date[2]);
				environment1.setSersorAddress(date[3]);
				environment1.setCount(Integer.parseInt(date[4]));
				environment1.setCmd(date[5]);			
				environment1.setStatus(Integer.parseInt(date[7]));
				environment1.setGather_date(time);			
				list.add(environment1);
				
//				十进制转换成十六进制
//				Integer x = 666;
//				String hex = x.toHexString(x);
//				System.out.println(hex);
				
			}else{		
				if(date[3].equals("256")){									
					//光照强度
					int lig=Integer.parseInt(date[6].substring(0,4),16);
					lnum++;
			
					environment1.setName("光照强度");
					environment1.setData(lig);
					list.add(environment1);
				}
				
				if(date[3].equals("1280")){ 
					//二氧化碳浓度				
					int carbon=Integer.parseInt(date[6].substring(0, 4),16);
					cnum++;
					
					environment1.setName("二氧化碳浓度");
					environment1.setData(carbon);
					list.add(environment1);
				}
		  }
			bufWrite.flush();   //字符流在关闭流的时候，信息才会全部输出,所以要先flush()	
		}//while循环结束
		//关闭流
		bufWrite.close();
		bufRead.close();
		
		log.info("采集温度数据条数:"+tnum);
		log.info("采集湿度数据条数"+hnum);
	    log.info("采集二氧化碳数据条数"+cnum);
		log.info("采集光照强度数据条数"+lnum);
		log.info("采集数据总条数"+list.size());

			return list;
	}
	
	/**
	 * 注入
	 */
	public void init(Properties p) {
		readfile=p.getProperty("radwtmp");
		writefile=p.getProperty("backup");		
	}
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		Gather g = configuration.getGather();
		
		try {
			Collection<Environment> gather = g.gather();
			//System.out.println("采集数据条数:"+gather.size());
			/*for (Environment environment : gather) {
				System.out.println(environment.getGather_date().getDate());//获取gather_date的哪一天
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
