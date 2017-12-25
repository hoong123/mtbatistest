package proxyJDK;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author weihoong
 * @since 2017/11/23
 */
public class HelloServiceCgLib implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("#### CGLB动态代理 ####");
        System.err.println("准备说Hello");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.err.println("说过Hello");
        return o1;
    }
}
