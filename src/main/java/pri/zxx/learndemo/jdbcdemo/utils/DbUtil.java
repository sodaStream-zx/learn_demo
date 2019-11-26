package pri.zxx.learndemo.jdbcdemo.utils;

import java.sql.*;

/**
 * @author zxx
 * @desc 数据库连接工具
 * @createTime 2019-11-26-下午 4:50
 */
public class DbUtil {

    private static final String url = "jdbc:mysql://localhost:3306/mybaties?useUnicode=true&useSSL=false&allowMultiQueries=true";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "zxx1994";

    /**
     * 获取数据库连接
     */
    public static Connection getCon() {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.printf("加载数据库驱动异常：" + e);
        } catch (SQLException e) {
            System.out.printf("获取数据库连接异常：" + e);
        }
        return null;
    }


    /**
     * 关闭数据库连接
     */
    public static void closeCon(ResultSet set, Statement statement, Connection connection) {
        try {
            if (set != null && !set.isClosed()) {
                set.close();
            }
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (!connection.isClosed()) {
                connection.close();
            }
            System.out.println("所有连接已关闭");
        } catch (SQLException e) {
            System.out.printf("关闭数据库连接异常：" + e);
        }
    }
}
