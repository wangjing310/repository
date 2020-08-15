package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

    private static Connection conn;
    private static String driver;
    private static String url;
    private static String user;
    private static String pwd;


    static{
        //读取配置文件
        Properties prop=new Properties();
        try{
            prop.load(JDBCUtil.class.getResourceAsStream("conninfo.properties"));
            driver=prop.getProperty("driver");
            url=prop.getProperty("url");
            user=prop.getProperty("user");
            pwd=prop.getProperty("pwd");
            //注册驱动
            Class.forName(driver);

        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
    //获得连接对象
    public static Connection getConn(){
        try{
            conn=DriverManager.getConnection(url,user,pwd);
        }
        catch(Exception e){
            e.printStackTrace();
        }


        return conn;
    }

    //关闭资源
    public static void close(ResultSet rs, Statement stat){
        try{
            if (rs!=null)
                rs.close();
            if (stat!=null)
                stat.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
