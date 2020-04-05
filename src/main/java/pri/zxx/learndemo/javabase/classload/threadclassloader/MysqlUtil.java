package pri.zxx.learndemo.javabase.classload.threadclassloader;

import java.sql.*;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-11-18-15:52
 */
public class MysqlUtil {
    private String user;
    private String password;
    private String url;
    private String driver;

    public MysqlUtil(String user, String password, String url, String driver) {
        this.user = user;
        this.password = password;
        this.url = url;
        this.driver = driver;
    }

    public static void main(String[] args) {
        MysqlUtil mysqlUtil = new MysqlUtil("root", "1234", "jdbc:mysql://localhost:3306/date", "com.mysql.jdbc.Driver");
        Connection con = mysqlUtil.getCon();
        if (null == con) {
            System.out.println("连接失败");
        } else {
            mysqlUtil.show(con);
        }
    }

    public Connection getCon() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("未找到驱动");
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接失败");
            return null;
        }
    }

    public void show(Connection connection) {
        String sql = "select * from siteconfig where scid = 2";
        PreparedStatement pr;
        try {
            pr = connection.prepareStatement(sql);
            ResultSet resultSet = pr.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println("id = " + id + "; name = " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
