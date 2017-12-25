package main;

import mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import po.Role;
import util.SqlSessionFactoryUtil;

/**
 * @author Hoong
 */
public class TestUseGeneratedKeys {
    public static void main(String[] args) {
        testUseGeneratedKeys();
    }

    public static void testUseGeneratedKeys() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("test4");
            role.setRoleName("test4Note");
            roleMapper.insertRole(role);
            System.err.println(role.getId());
            sqlSession.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            sqlSession.rollback();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
    }
}
