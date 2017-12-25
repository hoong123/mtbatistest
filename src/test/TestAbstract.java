package test;

/**
 * @author weihoong
 * @since 2017/11/30
 */
public abstract class TestAbstract implements ITestInterface{

    public abstract void method3();

    @Override
    public void method1() {
        System.out.println("1");
    }
}
