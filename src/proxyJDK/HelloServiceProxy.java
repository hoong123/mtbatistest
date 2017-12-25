package proxyJDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author weihoong
 * @since 2017/11/23
 */
public class HelloServiceProxy implements InvocationHandler {

    private Object targrt;

    public Object bind(Object target){
        this.targrt = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("####JDK动态代理####");
        Object result = null;
        System.err.println("准备说Hello");
        result = method.invoke(targrt,args);
        System.err.println("说过Hello了");
        return result;
    }
}
