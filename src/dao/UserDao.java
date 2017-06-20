package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtil.dbConnection;
import entity.User;

public class UserDao {
    private static Connection con;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static User checkUser(User user) {//从数据库中查找user并返回
        con = dbConnection.getCon();//获取数据库连接
        String sql="select * from users where userNo=? and userPassword=?";
        //从users表查找userNo=user.userNo,userPasword=user.userPassword的所有值
        User returnuser = new User();//用来返回的user
        try {
            ps = con.prepareStatement(sql);//预执行sql语句
            if (con == null) {
                System.out.println("con is null");
            }
            ps.setString(1, user.getUserNo());//对sql语句中userNo赋值
            ps.setString(2, user.getUserPassword());
            rs = ps.executeQuery();//执行sql语句

            if (rs.next()) {//判断结果有没有值
                System.out.println("登录查询成功");

                returnuser.setUserNo(rs.getString("userNo"));//获取userNo行的值,赋值
                returnuser.setUserPassword(rs.getString("userPassword"));//获取userPassword行的值，赋值
                returnuser.setUserType(rs.getString("userType"));//获取userType行的值，赋值
                returnuser.setUserName(rs.getString("userName"));
            } else {
                System.out.println("查无此人");
                returnuser=null;
            }
        } catch (SQLException e) {
            System.out.println("查询失败" + e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return returnuser;
    }

    public static void ChangeUser(User user) {
        con = dbConnection.getCon();//获取数据库连接
        String sql = "UPDATE users SET userPassword = ? WHERE userNo = ?";
        try {
            ps = con.prepareStatement(sql);
            if (con == null) {
                System.out.println("con is null");
            }
            ps.setString(1, user.getUserPassword());
            ps.setString(2, user.getUserNo().toString());
            ps.executeUpdate();

            System.out.println("Update Pass Succes");
        } catch (SQLException e) {
            System.out.println("Update Pass Fail" + e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static User fond(User user) {
        String tablename = null;
        if (user.getUserType().equals("student")) {
            tablename = "stu";
        } else {
            tablename = "tea";
        }
        con = dbConnection.getCon();//获取数据库连接
        String sql = "select * from " + tablename + " where No = '" + user.getUserNo() + "'";
        User returnuser = new User();
        try {
            ps = con.prepareStatement(sql);
            if (con == null) {
                System.out.println("con is null");
            }
            rs = ps.executeQuery();

            if (rs.next()) {
                returnuser.setUserNo(rs.getString("No"));
                returnuser.setUserName(rs.getString("Name"));
                returnuser.setSex(rs.getString("Sex"));
                returnuser.setAge(rs.getInt("Age"));
                returnuser.setPhone(rs.getString("Phone"));
                returnuser.setAdd(rs.getString("Addr"));
            }

            System.out.println("Info成功");
        } catch (SQLException e) {
            System.out.println("Info失败" + e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return returnuser;
    }

    public static void upUserInfo(User user) {
        String tablename = null;
        if (user.getUserType().equals("student")) {
            tablename = "stu";
        } else if (user.getUserType().equals("teacher") || user.getUserType().equals("admin")) {
            tablename = "tea";
        }
        con = dbConnection.getCon();//获取数据库连接
        String sql = "UPDATE " + tablename + " SET Age = " + user.getAge() + " ,Phone = '" + user.getPhone() + "', Addr = '" + user.getAdd() + "' WHERE No = '" + user.getUserNo() + "'";
        try {
            ps = con.prepareStatement(sql);
            if (con == null) {
                System.out.println("con is null");
            }
//			ps.setString(1, String.valueOf(user.getAge()));
//			ps.setString(2, user.getPhone());
//			ps.setString(3, user.getAdd());
//			ps.setString(4, user.getUserNo());
            ps.executeUpdate();

            System.out.println("UserInfo更新成功");
        } catch (SQLException e) {
            System.out.println("UserInfo更新失败" + e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void DelUser(String no) {
        con = dbConnection.getCon();//获取数据库连接
        String sql = "DELETE FROM users WHERE userNo = "+no;
        try {
            ps = con.prepareStatement(sql);
            if (con == null) {
                System.out.println("con is null");
            }
            ps.executeUpdate();

            System.out.println("Del User Succes");
        } catch (SQLException e) {
            System.out.println("Del User Fail" + e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void ChangeUserSta(String no, String type) {
        con = dbConnection.getCon();//获取数据库连接
        String sql = "UPDATE "+type+" SET State=1 WHERE No = "+no;
        try {
            ps = con.prepareStatement(sql);
            if (con == null) {
                System.out.println("con is null");
            }
            ps.executeUpdate();

            System.out.println("Update User Sta Succes");
        } catch (SQLException e) {
            System.out.println("Update User Sta Fail" + e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
