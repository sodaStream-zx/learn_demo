package pri.zxx.learndemo.jdbcdemo;

import pri.zxx.learndemo.jdbcdemo.entitys.Role;
import pri.zxx.learndemo.jdbcdemo.services.SqlService;

import java.lang.reflect.InvocationTargetException;

/**
 * @author zxx
 * @desc
 * @createTime 2019-11-26-下午 4:50
 */
public class JdbcTest {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String sql = "SELECT * FROM sys_role limit 10";
        SqlService sqlService = new SqlService();
        sqlService.getData(sql, Role.class);
    }
}
