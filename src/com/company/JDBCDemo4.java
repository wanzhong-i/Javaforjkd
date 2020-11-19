package com.company;

/*查询操作*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo4 {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jiangkeda","root","123456");

        String sql = "select * from account";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()){
        int id = rs.getInt("id");
        String name = rs.getString("name");
        double balance = rs.getDouble("balance");
        System.out.println(id+"----"+name+"----"+balance);
        }
        stmt.close();
        conn.close();
    }
}
