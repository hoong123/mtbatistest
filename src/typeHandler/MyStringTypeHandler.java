package typeHandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author Hoong
 */
@MappedTypes({String.class})
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyStringTypeHandler implements TypeHandler<String> {
    private Logger log = Logger.getLogger(MyStringTypeHandler.class);
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        log.info("使用我的TypeHandler");
        preparedStatement.setString(i,s);
    }

    @Override
    public String getResult(ResultSet resultSet, String s) throws SQLException {
        log.info("使用我的TypeHandler,ResultSet列名获取字符串");
        return resultSet.getString(s);
    }

    @Override
    public String getResult(ResultSet resultSet, int i) throws SQLException {
        log.info("使用我的TypeHandler,ResultSet下标获取字符串");
        return resultSet.getString(i);
    }

    @Override
    public String getResult(CallableStatement callableStatement, int i) throws SQLException {
        log.info("使用我的TypeHandler,CallableStatement下标获取字符串");
        return callableStatement.getString(i);
    }
}
