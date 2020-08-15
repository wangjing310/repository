package jdbc;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DateWRTest {

    public static void main(String[] args)throws Exception{

        Connection conn = JDBCUtil.getConn();
        Statement stat = conn.createStatement();
        String sql="select id,name,author,public_date from tb_book";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()){
            int id = rs.getInt("id");  //和sql语句的列一样
            String name = rs.getString("name");
            String author = rs.getString("author");
            Date public_date = rs.getDate("public_date");

           /*  下标也可以
           int id = rs.getInt(1);
            String name = rs.getString(2);
            String author = rs.getString(3);
            Date public_date = rs.getDate(4);*/

            //日期转换为字符串
           SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            String date_str = sdf.format(public_date);

            System.out.println(id+" "+name+" "+author+" "+public_date);
        }
        JDBCUtil.close(rs,stat);

    }
}
