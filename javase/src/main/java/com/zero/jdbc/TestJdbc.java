package com.zero.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName TestJdbc
 *@Description TODO
 *@Author 张春海
 *@Date 2020/6/12 18:38 
 *@Version 1.0 */
public class TestJdbc {

    public List<Object> findAll() {
        String driver="oracle.jdbc.driver.OracleDriver";
        String url="jdbc:oracle:thin:@localhost:1521:orcl";
        String uname="bjmsb";
        String password="bjmsb";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Object> stuList = new ArrayList<Object>();

        try {
            //  加载驱动
            Class.forName(driver);
            //  建立连接
            conn = DriverManager.getConnection(url, uname,password);
            //建立会话//(0.5分)
            stmt = conn.createStatement();
            //发送SQL命令得到结果(0.5分)
            rs = stmt.executeQuery("select * from t_student");

            //处理结果
            while(rs.next()){
                //取出结果集中各列数据（1分）
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double score = rs.getDouble("score");
                Date enterDate = rs.getDate("enterDate");
                //封装成Student对象（0.5分）
                Student stu=new Student(id,name,age,score,enterDate);
                //加入集合（0.5分
                stuList.add(stu);
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            // TODO 关闭资源(依次关闭rs，stmt，conn)（1分）
//            super.closeAll(rs,stmt,conn);
        }


        return stuList;
    }
}
