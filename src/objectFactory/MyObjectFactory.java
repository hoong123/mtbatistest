package objectFactory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.log4j.Logger;


import java.util.List;
import java.util.Properties;


public class MyObjectFactory extends DefaultObjectFactory {
    private static final long serialVersionUID = -3814827216040286292L;
    Logger log =  Logger.getLogger(MyObjectFactory.class);
    @Override
    public void setProperties(Properties properties) {
        log.info("定制属性："+properties);
        super.setProperties(properties);
    }

    @Override
    public <T> T create(Class<T> type) {
        log.info("使用定制对象工厂的create方法构建单个对象");
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        log.info("使用定制对象工厂的create方法构建列表对象");
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
