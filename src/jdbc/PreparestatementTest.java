package jdbc;

import java.sql.*;

public class PreparestatementTest {
    public static void main(String[] args)throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/runoob";
        Connection conn=DriverManager.getConnection(url,"root","root");

        System.out.println(conn);

        String sql="insert into student values (?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        //设置值替换占位符  批处理

            ps.setObject(1,3);
            ps.setObject(2,"六哥");
            ps.setObject(3,"男");
            ps.setObject(4,25);

            ps.executeUpdate();


       //ps.execute();
//        ps.executeQuery();
//        ps.executeUpdate();
        conn.close();

    }

    }

