package pri.zxx.learndemo.jdbcdemo.services;

import pri.zxx.learndemo.jdbcdemo.utils.DbUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author zxx
 * @desc
 * @createTime 2019-11-26-下午 4:50
 */
public class SqlService {

    public void getData(String sqlStr, Class<?> className) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Connection con = DbUtil.getCon();
        if (con == null) {
            System.out.println("连接为空 null");
            return;
        }
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = preparedStatement.getMetaData();
            int columnCount = metaData.getColumnCount();

            ArrayList<Object> reslist = new ArrayList<>();

            while (resultSet.next()) {
                Object ent = className.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i);
                    Object theValue = resultSet.getObject(columnLabel);
                    Arrays.stream(className.getMethods()).filter(method -> method.getName().startsWith("set"))
                            .forEach(method -> {
                                String name = method.getName();
                                if (parseMethodName(columnLabel).equals(name)) {
                                    String filed = Arrays.stream(columnLabel.split("_"))
                                            .map(s1 -> s1.substring(0, 1).toUpperCase() + s1.substring(1))
                                            .collect(Collectors.joining());
                                    Field declaredField;
                                    try {
                                        declaredField = className.getDeclaredField(filed.substring(0, 1).toLowerCase() + filed.substring(1));
                                        method.invoke(ent, declaredField.getType().cast(theValue.toString()));
                                    } catch (IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                }
                reslist.add(ent);
            }
            reslist.forEach(System.out::println);
            DbUtil.closeCon(resultSet, preparedStatement, con);
        } catch (
                SQLException e) {
            System.out.println("执行sql异常：" + e);
        }

    }

    /**
     * 解析方法名称
     */
    private String parseMethodName(String columnLabel) {
        String pri = "set";
        String methodNameWithPri = Arrays.stream(columnLabel.split("_"))
                .map(s1 -> s1.substring(0, 1).toUpperCase() + s1.substring(1))
                .collect(Collectors.joining());
        return pri + methodNameWithPri;
    }

}
