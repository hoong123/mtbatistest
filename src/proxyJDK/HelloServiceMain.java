package proxyJDK;

/**
 * @author weihoong
 * @since 2017/11/23
 */
public class HelloServiceMain {
    public static void main(String[] args) {
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
        HelloService bind = (HelloService) helloServiceProxy.bind(new HelloServiceImpl());
        bind.sayHello("张三");
    }
}
