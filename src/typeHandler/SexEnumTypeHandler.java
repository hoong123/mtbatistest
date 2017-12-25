package typeHandler;

import enums.Sex;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Hoong
 */
public class SexEnumTypeHandler implements TypeHandler<Sex> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Sex sex, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,sex.getId());
    }

    @Override
    public Sex getResult(ResultSet resultSet, String s) throws SQLException {
        int id = resultSet.getInt(s);
        return Sex.getSex(id);
    }

    @Override
    public Sex getResult(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt(i);
        return Sex.getSex(id);
    }

    @Override
    public Sex getResult(CallableStatement callableStatement, int i) throws SQLException {
        int id = callableStatement.getInt(i);
        return Sex.getSex(id);
    }
}
