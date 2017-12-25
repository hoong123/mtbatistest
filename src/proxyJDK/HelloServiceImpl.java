package proxyJDK;

/**
 * @author weihoong
 * @since 2017/11/23
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.err.println("hello"+name);
    }
}
