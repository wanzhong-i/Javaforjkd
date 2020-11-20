package com.company;

import com.company.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 模拟用户登录程序
 */
public class JDBCDemo7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome to lol");
        System.out.println("请输入用户名");
        String username = scanner.next();
        System.out.println("请输入密码");
        String password = scanner.next();

        boolean flag = login(username,password);
        if(flag){
            System.out.println("password right");
        }else {
            System.out.println("password wrong");
        }
    }

    public static boolean login(String username, String password){
        //参数校验
        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username = '"+username+"' and password='"+password+"'";
//            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
                e.printStackTrace();
        }
        //走到这里说明有异常，需要返回true
        return false;
    }
}

