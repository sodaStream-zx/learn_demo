package pri.zxx.learndemo.jdbcdemo;

import pri.zxx.learndemo.jdbcdemo.services.SqlService;

/**
 * @author zxx
 * @desc
 * @createTime 2019-11-26-下午 4:50
 */
public class JdbcTest {
    public static void main(String[] args) {
        String sql = "SELECT * from hashtest LIMIT 10";
        SqlService sqlService = new SqlService();
        sqlService.getData(sql);
    }
}
