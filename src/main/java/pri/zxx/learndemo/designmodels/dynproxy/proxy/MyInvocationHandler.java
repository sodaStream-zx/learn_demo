package pri.zxx.learndemo.designmodels.dynproxy.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-04-20-22:31
 */
public class MyInvocationHandler<T> implements InvocationHandler {
    T movable;

    /**
     * 注入被代理对象
     */
    public MyInvocationHandler(T movable) {
        this.movable = movable;
    }

    /**
     * 反射调用被代理对象方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理对象执行：" + method.getName());
        return method.invoke(movable, args);
    }

    /**
     * 创建代理对象
     */
    public Object createTarget() {
        return Proxy.newProxyInstance(movable.getClass().getClassLoader(), movable.getClass().getInterfaces(), this);
    }
}
