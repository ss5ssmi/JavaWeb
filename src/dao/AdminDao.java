package dao;

/**
 * Created by Xing on 2017/6/13.
 */

import DBUtil.dbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DBUtil.dbConnection;
import entity.User;

public class AdminDao {
    private static Connection con;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static List fondstu(String type) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        con = dbConnection.getCon();
        String sql = "select * from "+type+" where State=0";
        try {
            if (con == null) {
                System.out.println("con is null");
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData md = rs.getMetaData(); //获得结果集结构信息,元数据
            int columnCount = md.getColumnCount();   //获得列数
            while (rs.next()) {
                Map<String, Object> rowData = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }
            System.out.println("Fond Stu Succes");
        } catch (SQLException e) {
            System.out.println("Fond Stu Fail" + e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public static List fondstusource() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        con = dbConnection.getCon();
        String sql = "select * from source";
        try {
            if (con == null) {
                System.out.println("con is null");
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData md = rs.getMetaData(); //获得结果集结构信息,元数据
            int columnCount = md.getColumnCount();   //获得列数
            while (rs.next()) {
                Map<String, Object> rowData = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }
            System.out.println("Fond Score Succes");
        } catch (SQLException e) {
            System.out.println("Fond Score Fail" + e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }

}
