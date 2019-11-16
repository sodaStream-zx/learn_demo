package pri.zxx.learndemo.designmodels.dynproxy.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-04-20-22:31
 */
public class MyInvocationHandler<T> implements InvocationHandler {
    T moveable;

    public MyInvocationHandler(T moveable) {
        this.moveable = moveable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理对象执行：" + method.getName());
        Object invoke = method.invoke(moveable, args);
        return invoke;
    }
}
