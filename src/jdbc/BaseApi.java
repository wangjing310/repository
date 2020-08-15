package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseApi {

    public static void main(String[] args)throws Exception{
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得连接对象
        //协议：//host：port/res
        //jdbc:mysql://192.168.43.153:3306/
        String url="jdbc:mysql://localhost:3306/runoob";
        Connection conn=DriverManager.getConnection(url,"root","root");
        // 3.获得句柄对象statement  支持DML和DDL，
        // PrepareStatement 支持DML   批处理
        Statement stat = conn.createStatement();
        String sql="create ";
        String sql1="select id,name,sex,age from student";

        //4.执行sql语句
        //stat.executeQuery()  select语句  返回ResultSet
        //stat.executeUpdate()  insert update delete 操作影响的行数
        //stat.execute(sql);  //DML DDL 返回值代表是否有结果集
        ResultSet rs = stat.executeQuery(sql1);
        //5.返回结果集
        while (rs.next()){
            System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3)
                    +" "+rs.getObject(4));
        }

        //6.关闭资源
        stat.close();
        conn.close();

    }

}
