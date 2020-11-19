package com.company;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*删除操作*/

public class JDBCDemo3 {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jiangkeda","root","123456");

        String sql = "delete from account where id = 4";

        Statement stmt = conn.createStatement();

        int i = stmt.executeUpdate(sql);

        if (i==1){
            System.out.println("删除成功");
        }else {
            System.out.println("失败");
        }
        stmt.close();
        conn.close();
    }
}