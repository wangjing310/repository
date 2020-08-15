package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;

public class CommitTest {
    public static void main(String[] args)throws Exception{
        Connection conn = JDBCUtil.getConn();
        //不自动提交事务
        conn.setAutoCommit(false);
        Statement stat = conn.createStatement();

        //张三扣款
        String sql1="update account set balance=balance-500 where name='张三'";
        stat.execute(sql1);
        System.out.println("张三扣款500");
        //设置回滚点
        Savepoint p1 = conn.setSavepoint();

        String sql2="update account set balance=balance+500 where name='李四'";
        stat.execute(sql2);
        System.out.println("李四收款500");
        //判断能否进行转款
        String sql3="select balance from account where name='张三'";
        ResultSet rs = stat.executeQuery(sql3);
        rs.next();
        int balance=rs.getInt(1);
        if (balance<500){
            conn.rollback(p1);
            try{
                throw new Exception("余额不足");
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }

        conn.commit();
        JDBCUtil.close(rs,stat);



    }
}
