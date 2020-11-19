package com.company;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*插入操作*/

public class JDBCDemo2 {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jiangkeda","root","123456");

        String sql = "insert into account values (null,'王五',777)";

        Statement stmt = conn.createStatement();

        int i = stmt.executeUpdate(sql);

        if (i==1){
            System.out.println("插入成功");
        }else {
            System.out.println("失败");
        }
        stmt.close();
        conn.close();
    }
}