package pri.zxx.webdemo.aops;

import pri.zxx.webdemo.annotation.ExtParam;
import pri.zxx.webdemo.annotation.InsertMysql;
import pri.zxx.webdemo.annotation.SelectMysql;

import java.lang.reflect.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 钢蛋
 * @desc
 * @createTime 2020-03-31-10:09
 */
public class MyInvocationHandlerMybatis implements InvocationHandler {
    public Object obj;

    public MyInvocationHandlerMybatis(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("使用动态代理拦截dao接口---");
        InsertMysql extInsert = method.getDeclaredAnnotation(InsertMysql.class);
        //1.判断方法是否加了insert注解
        if (extInsert != null) {
            return extInsert(extInsert, method, args);
        }
        SelectMysql extSelect = method.getDeclaredAnnotation(SelectMysql.class);
        //2.查询
        if (extSelect != null) {
            //注解存在获取sql
            String querySql = extSelect.value();
            //获取参数绑定
            ConcurrentHashMap<Object, Object> paramMap = getConcurrentHashMap(method, args);
            List<String> sqlSelectParameter = SQLUtils.sqlSelectParameter(querySql);
            List sqlParam = new ArrayList();
            for (String string : sqlSelectParameter) {
                Object paramValue = paramMap.get(string);
                sqlParam.add(paramValue);
            }
            String newSql = SQLUtils.parameQuestion(querySql, sqlSelectParameter);
            //调用jdbc
            ResultSet resultSet = JDBCUtils.query(newSql, sqlParam);
            if (!resultSet.next()) {
                return null;
            }
            resultSet.previous();//下标上移一位
            Class<?> returnType = method.getReturnType();
            Type type = method.getReturnType();
            System.out.println("returnType:" + returnType);
            Object object = returnType.newInstance();
            while (resultSet.next()) {
                //反射机制获取实例化对象
                Field[] declaredFields = returnType.getDeclaredFields();
                for (Field field : declaredFields) {
                    String fieldName = field.getName();
                    Object filedValue = resultSet.getObject(fieldName);
                    field.setAccessible(true);//设置私有属性可以访问
                    field.set(object, filedValue);
                }
             /*   for (String paramName : sqlSelectParameter) {
                    Object resultValue = resultSet.getObject(paramName);
                    Field field = returnType.getDeclaredField(paramName);
                    field.setAccessible(true);
                    field.set(object, resultValue);
                }*/
            }
            return object;
        }

        return null;
    }

    //insert
    private Object extInsert(InsertMysql extInsert, Method method, Object[] args) {
        //2.存在注解，获取sql 截取sql
        String insertSql = extInsert.value();
        System.out.println("insertSql:" + insertSql);

        //3.获取参数 定义map集合接收参数
        ConcurrentHashMap<Object, Object> paramMap = getConcurrentHashMap(method, args);

        //4.替换参数  ?

        String[] sqlInsertParameter = SQLUtils.sqlInsertParameter(insertSql);
        List<Object> sqlParams = getSqlParam(sqlInsertParameter, paramMap);

        String newSql = SQLUtils.parameQuestion(insertSql, sqlInsertParameter);
        System.out.println("拼接后的sql：" + newSql + ",参数有：" + sqlParams.toString());
        //5.调用jdbc
        JDBCUtils.insert(newSql, false, sqlParams);
        return 1;
    }

    //获取方法的参数
    private ConcurrentHashMap<Object, Object> getConcurrentHashMap(Method method, Object[] args) {
        ConcurrentHashMap<Object, Object> paramMap = new ConcurrentHashMap<>();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            ExtParam extParam = parameter.getAnnotation(ExtParam.class);
            if (extParam != null) {
                String paramName = extParam.value();
                Object paramValue = args[i];
                System.out.println(paramName + "---" + paramValue);
                /* if(extParam.value()==parameter.getName()){}*/
                paramMap.put(paramName, paramValue);
            }
        }
        return paramMap;
    }

    //替换参数
    private List getSqlParam(String[] sqlInsertParameter, ConcurrentHashMap<Object, Object> paramMap) {
        List<Object> sqlParams = new ArrayList<>();
        for (String paramName : sqlInsertParameter) {
            Object paramValue = paramMap.get(paramName);
            sqlParams.add(paramValue);
        }
        return sqlParams;
    }

}
