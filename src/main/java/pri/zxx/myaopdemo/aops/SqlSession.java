package pri.zxx.myaopdemo.aops;

import java.lang.reflect.Proxy;

/**
 * @author 钢蛋
 * @desc 获取代理对象
 * @createTime 2020-03-31-10:09
 */
public class SqlSession {
    //jdk动态代理
    public static <T> T getMapper(Class aClass) {
        return (T) Proxy.newProxyInstance(aClass.getClassLoader(), new Class[]{aClass}, new MyInvocationHandlerMybatis(aClass));
    }
}