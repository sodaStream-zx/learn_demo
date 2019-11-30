package pri.zxx.learndemo.jdbcdemo.services;

import pri.zxx.learndemo.jdbcdemo.utils.DbUtil;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zxx
 * @desc
 * @createTime 2019-11-26-下午 4:50
 */
public class SqlService {
    private Class<?> objClass;

    public SqlService(Class<?> objClass) {
        this.objClass = objClass;
    }

    /**
     * 获取数据
     */
    public void getData(String sqlStr, Class<?> className) throws IllegalAccessException, InstantiationException {
        Connection con = DbUtil.getCon();
        if (con == null) {
            System.out.println("连接为空 null");
            return;
        }
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = preparedStatement.getMetaData();
            String typeStr = className.getSimpleName();
            int typeNum = this.checkType(typeStr);
            switch (typeNum) {
                case 1:
                    this.mysqlToMap(resultSet, metaData);
                    break;
                case 2:
                    this.mysqlToList(resultSet, metaData);
                    break;
                case 3:
                    this.mysqlToObject(className, resultSet, metaData);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + className);
            }
            DbUtil.closeCon(resultSet, preparedStatement, con);
        } catch (SQLException e) {
            System.out.println("执行sql异常：" + e);
        }
    }

    /**
     * 转为list
     */
    private void mysqlToList(ResultSet resultSet, ResultSetMetaData metaData) throws SQLException, IllegalAccessException, InstantiationException {
        ArrayList<Object> reslist = new ArrayList<>();
        while (resultSet.next()) {
            Object ent = this.mysqlToObject(objClass, resultSet, metaData);
            reslist.add(ent);
        }
        reslist.forEach(System.out::println);
    }

    /**
     * 转为map
     */
    private Map<String, Object> mysqlToMap(ResultSet resultSet, ResultSetMetaData metaData) throws SQLException {
        resultSet.last();
        int rows = resultSet.getRow();
        if (rows > 1) {
            System.out.println("数据数量不对");
            return null;
        } else {
            resultSet.first();
            HashMap<String, Object> stringObjectHashMap = this.toMapEntity(resultSet, metaData);
            System.out.println("map:" + stringObjectHashMap.toString());
            return stringObjectHashMap;
        }
    }

    /**
     * mysql 查询数据封装为实体
     */
    public Object mysqlToObject(Class<?> className, ResultSet resultSet, ResultSetMetaData metaData) throws InstantiationException, IllegalAccessException, SQLException {
        int typeNum = this.checkType(objClass.getSimpleName().toLowerCase());
        if (typeNum == 1) {
            return this.toMapEntity(resultSet, metaData);
        } else {
            return this.toCustomObject(className, resultSet, metaData);
        }
    }

    /**
     * 转发为自定义实体
     */
    private Object toCustomObject(Class<?> className, ResultSet resultSet, ResultSetMetaData metaData) throws SQLException, IllegalAccessException, InstantiationException {
        Object ent = objClass.newInstance();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnLabel = metaData.getColumnLabel(i);
            Object theValue = resultSet.getObject(columnLabel);
            Arrays.stream(className.getMethods())
                    .filter(method -> method.getName().startsWith("set"))
                    .forEach(method -> {
                        String name = method.getName();
                        if (parseMethodName(columnLabel).equals(name)) {
                            String filed = Arrays.stream(columnLabel.split("_"))
                                    .map(s1 -> s1.substring(0, 1).toUpperCase() + s1.substring(1))
                                    .collect(Collectors.joining());
                            Field declaredField;
                            try {
                                declaredField = className.getDeclaredField(filed.substring(0, 1).toLowerCase() + filed.substring(1));
                                if (declaredField != null) {
                                    declaredField.setAccessible(true);
                                    declaredField.set(ent, theValue);
                                }
                            } catch (IllegalAccessException | NoSuchFieldException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }
        return ent;
    }

    /**
     * 转化为map
     */
    private HashMap<String, Object> toMapEntity(ResultSet resultSet, ResultSetMetaData metaData) throws SQLException {
        int columnCount = metaData.getColumnCount();
        HashMap<String, Object> mapObj = new HashMap<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnLabel = metaData.getColumnLabel(i);
            mapObj.put(columnLabel, resultSet.getObject(columnLabel));
        }
        return mapObj;
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

    /**
     * 判断传入得类型是否是list
     */
    private int checkType(String obj) {
        String className = obj.toLowerCase();
        if (className.contains("map")) {
            return 1;
        } else if (className.contains("list")) {
            return 2;
        } else {
            return 3;
        }
    }
}
