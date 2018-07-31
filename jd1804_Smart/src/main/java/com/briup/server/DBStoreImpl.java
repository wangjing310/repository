package com.briup.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import com.briup.bean.Environment;
import com.briup.client.Gather;
import com.briup.client.GatherImpl;
import com.briup.inject.Configuration;
import com.briup.inject.ConfigurationImpl;
import com.briup.inject.WossModual;
import com.briup.util.Log;
import com.briup.util.LogImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class DBStoreImpl implements DBStore,WossModual{
	static ConfigurationImpl configuration=new ConfigurationImpl();
	int i=0;
	int day1=0;
	
	  String Driver=null;
	  String url=null;
	  String user=null;
	  String password=null;
	
	//子类重写父类方法/实现类实现接口方法，如果超类方法没有throws Exception，则子类重写方法也不能throws
	public void saveDB(Collection<Environment> c) throws Exception{	
		Log log = configuration.getLogger();
		
		Class.forName(Driver);
		Connection conn=DriverManager.getConnection(url, user, password);		
		PreparedStatement ps=null;
		
		 long l1=System.currentTimeMillis();//当前时间毫秒数
		 // 遍历集合		
		Iterator<Environment> ite=c.iterator();
		while(ite.hasNext()){
			i++;			
			Environment e=ite.next();			
			Timestamp t=e.getGather_date();						
			 // 提取日期时间里面的 '日'			 		
			Calendar time=Calendar.getInstance();
			time.setTime(t);
			int day=time.get(Calendar.DAY_OF_MONTH);
			
			//t可以是Date类型也可以是时间戳类型。
			java.sql.Date sqlDate = new java.sql.Date(t.getTime());			
			/*
			 * 批处理
			 * addBatch是对一个ps，多条数据进行操作，
			 * 只要ps=conn.prepareStatement(sql);	就是一个ps对象
			 */
			if(day1!=day||i%6000==0){	
				if(i!=1){
					ps.executeBatch();
					ps.clearBatch();	//提交之后要清理，不然之前的数据一直在batch()里	 							    
				}
	
		    String sql="insert into e_detail_"+day+" values(?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			   day1=day;			
			}
					 
			ps.setString(1, e.getName());
			ps.setString(2,e.getSrcId());
			ps.setString(3, e.getDstId());
			ps.setString(4, e.getSersorAddress());
			ps.setInt(5, e.getCount());
			ps.setString(6,e.getCmd());
			ps.setLong(7, e.getStatus());
			ps.setFloat(8, e.getData());
			ps.setDate(9, sqlDate);						
			ps.addBatch();
	
		}//while结束	
		ps.executeBatch();      //不足一个批次的要最后执行一下
		conn.close();
		ps.close();
		long l2=System.currentTimeMillis();//当前时间毫秒数
		System.out.println("入库时间"+(l2-l1));
		log.info("插入数据库信息条数:"+i);		
	}
	
	 /**
     * 注入
     */
	public void init(Properties p) {
		Driver=p.getProperty("Driver");
		url=p.getProperty("url");
		user=p.getProperty("user");
		password=p.getProperty("pwd");		
	}
	
	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Gather g = configuration.getGather();
		DBStore d = configuration.getDBStore();		
		d.saveDB(g.gather());
	}
}
