package reflectTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author weihoong
 * @since 2017/11/23
 */
public class ReflectService {
    public void sqyHello(String name){
        System.err.println("hello"+name);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object service = Class.forName(ReflectService.class.getName()).newInstance();
        Method sayHello = service.getClass().getMethod("sayHello", String.class);
        sayHello.invoke(service,"zhangsan");
    }
}
