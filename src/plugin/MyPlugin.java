package plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;


/**
 * @author weihoong
 * @since 2017/12/25
 */
@Intercepts({@Signature(
        type = Executor.class,//确定要拦截的对象
        method = "update",//确定要拦截的方法
        args = {MappedStatement.class, Object.class}//拦截方法的参数
)})
public class MyPlugin implements Interceptor {

    Properties props = null;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.err.println("before......");
        //如果当前代理的是一个非代理对象，那么它就返回调用真实拦截对象的方法，如果不是他会调度下个插件代理对象的invoke方法
        Object proceed = invocation.proceed();
        System.err.println("after.......");
        return proceed;
    }

    /*
    * 生成对象的代理
    * @param o 被代理对象
    * */
    @Override
    public Object plugin(Object o) {
        System.err.println("调用生成代理对象......");
        return Plugin.wrap(o, this);
    }

    /*
    * 获取插件配置的属性
    * @param properties是配置的参数
    * */
    @Override
    public void setProperties(Properties properties) {
        System.err.println(properties.get("dbType"));
        this.props = properties;
    }
}
