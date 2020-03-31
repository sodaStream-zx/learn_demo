package pri.zxx.webdemo.aops;

import java.lang.reflect.Proxy;

/**
 * @author 钢蛋
 * @desc
 * @createTime 2020-03-31-10:09
 */
public class SqlSession {
    public static <T> T getMapper(Class classz) {
        return (T) Proxy.newProxyInstance(classz.getClassLoader(), new Class[]{classz}, new MyInvocationHandlerMybatis(classz));
    }
}