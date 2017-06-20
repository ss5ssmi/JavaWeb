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

    public static User checkUser(User user) {//�����ݿ��в���user������
        con = dbConnection.getCon();//��ȡ���ݿ�����
        String sql="select * from users where userNo=? and userPassword=?";
        //��users�����userNo=user.userNo,userPasword=user.userPassword������ֵ
        User returnuser = new User();//�������ص�user
        try {
            ps = con.prepareStatement(sql);//Ԥִ��sql���
            if (con == null) {
                System.out.println("con is null");
            }
            ps.setString(1, user.getUserNo());//��sql�����userNo��ֵ
            ps.setString(2, user.getUserPassword());
            rs = ps.executeQuery();//ִ��sql���

            if (rs.next()) {//�жϽ����û��ֵ
                System.out.println("��¼��ѯ�ɹ�");

                returnuser.setUserNo(rs.getString("userNo"));//��ȡuserNo�е�ֵ,��ֵ
                returnuser.setUserPassword(rs.getString("userPassword"));//��ȡuserPassword�е�ֵ����ֵ
                returnuser.setUserType(rs.getString("userType"));//��ȡuserType�е�ֵ����ֵ
                returnuser.setUserName(rs.getString("userName"));
            } else {
                System.out.println("���޴���");
                returnuser=null;
            }
        } catch (SQLException e) {
            System.out.println("��ѯʧ��" + e);
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
        con = dbConnection.getCon();//��ȡ���ݿ�����
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
        con = dbConnection.getCon();//��ȡ���ݿ�����
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

            System.out.println("Info�ɹ�");
        } catch (SQLException e) {
            System.out.println("Infoʧ��" + e);
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
        con = dbConnection.getCon();//��ȡ���ݿ�����
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

            System.out.println("UserInfo���³ɹ�");
        } catch (SQLException e) {
            System.out.println("UserInfo����ʧ��" + e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void DelUser(String no) {
        con = dbConnection.getCon();//��ȡ���ݿ�����
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
        con = dbConnection.getCon();//��ȡ���ݿ�����
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
