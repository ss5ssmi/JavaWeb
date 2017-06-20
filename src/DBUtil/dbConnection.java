package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "root";
    private static Connection con = null;

    public static Connection getCon() {//��ȡ���ݿ�����
        try {
            Class.forName(DBDRIVER);
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
            if (con != null) {
                System.out.println("���ӳɹ�");
            }
        } catch (Exception e) {
            System.out.println("����ʧ��" + e);
        }
        return con;
    }

    public void closeCon() throws SQLException {//�ر����ݿ�����
        try {
            if (!con.isClosed()) {
                con.close();
                System.out.println("���ӹرճɹ�");
            }
        } catch (SQLException e) {
            System.out.println("�ر�����ʧ��" + e);
        }
    }
}
