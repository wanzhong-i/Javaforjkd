package com.company;

/*JDBC连接mysql示例*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo1 {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jiangkeda","root","123456");

        String sql = "update account set balance = 500 where id = 1";

        Statement stmt = conn.createStatement();

        int i = stmt.executeUpdate(sql);

        if (i==1){
            System.out.println("更新成功");
        }else {
            System.out.println("失败");
        }
        stmt.close();
        conn.close();
    }
}
