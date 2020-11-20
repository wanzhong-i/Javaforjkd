package com.company;

/*查询emp表中的数据*/

import com.company.domain.Emp;

import java.sql.*;

public class JDBCDemo5 {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jiangkeda", "root", "123456");

        String sql = "select * from emp";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

//        while (rs.next()) {
//            int empno = rs.getInt("empno");
//            String ename = rs.getString("ename");
//            String job = rs.getString("job");
//            int mgr = rs.getInt("mgr");
//            Date hiredate = rs.getDate("hiredate");
//            int sal = rs.getInt("sal");
//            int comm = rs.getInt("comm");
//            int deptno = rs.getInt("deptno");
//            System.out.println(empno + "    " + ename + "    "+job+"    "+mgr+"    "+hiredate+"    " + sal+"    "+comm+"    "+deptno);
//        }
        while (rs.next()) {
            int empno = rs.getInt("empno");
            String ename = rs.getString("ename");
            String job = rs.getString("job");
            int mgr = rs.getInt("mgr");
            Date hiredate = rs.getDate("hiredate");
            int sal = rs.getInt("sal");
            int comm = rs.getInt("comm");
            int deptno = rs.getInt("deptno");
            Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
            System.out.println(emp);
        }

        stmt.close();
        conn.close();
    }
}
