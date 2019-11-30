package pri.zxx.learndemo.jdbcdemo;

import pri.zxx.learndemo.jdbcdemo.services.SqlService;

import java.util.List;
import java.util.Map;

/**
 * @author zxx
 * @desc
 * @createTime 2019-11-26-下午 4:50
 */
public class JdbcTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM sys_role limit 10";
        SqlService sqlService = new SqlService(Map.class);
        sqlService.getData(sql, List.class);
    }
}
