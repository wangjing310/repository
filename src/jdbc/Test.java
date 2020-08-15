package jdbc;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Test {
    public static void main(String[] args)throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8";
        Connection conn = DriverManager.getConnection(url, "root", "root");

        //增加
        String sql1="insert tb_book values(?,?,?,?,?)";
        PreparedStatement stat = conn.prepareStatement(sql1);

        SimpleDateFormat adf=new SimpleDateFormat("yyyy-MM");

        stat.setObject(1,3);
        stat.setObject(2,"水浒传");
        stat.setObject(3,"罗贯中");
        stat.setObject(4,101.1);
        stat.setObject(5, adf.parse("1893-2-13"));
       // stat.executeUpdate();

        //删除
        String sql2="delete from tb_book where id=?";
        PreparedStatement stat1 = conn.prepareStatement(sql2);

        stat1.setObject(1,2);
       // stat1.execute();

        //修改
        String sql4="update tb_book set name=?,author=?,price=?,public_date=? where id=?";
        PreparedStatement stat3 = conn.prepareStatement(sql4);

        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");

        stat3.setString(1,"三国");
        stat3.setString(2,"罗贯中");
        stat3.setFloat(3,34.4f);
        stat3.setObject(4,sp.parse("1987-4-5"));
        stat3.setInt(5,1);
        stat3.executeUpdate();

        //查询

        String sql3="select id,name,author,price,public_date from tb_book";
        Statement stat2 = conn.createStatement();
        ResultSet rs = stat2.executeQuery(sql3);
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String author = rs.getString("author");
            float price = rs.getFloat("price");
            Date public_date = rs.getDate("public_date");
            System.out.println(id+" "+name+" "+author+" "+price+" "+public_date);
        }

        conn.close();
    }
}
