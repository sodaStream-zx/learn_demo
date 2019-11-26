package pri.zxx.learndemo.jdbcdemo.services;

import pri.zxx.learndemo.jdbcdemo.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zxx
 * @desc
 * @createTime 2019-11-26-下午 4:50
 */
public class SqlService {

    public void getData(String sqlStr) {
        Connection con = DbUtil.getCon();
        if (con == null) {
            System.out.println("连接为空 null");
            return;
        }
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            String s = resultSet.toString();
            System.out.println("结果为：" + s);
            DbUtil.closeCon(resultSet, preparedStatement, con);
        } catch (SQLException e) {
            System.out.println("执行sql异常：" + e);
        }
    }

}
