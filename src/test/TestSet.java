package test;

import mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import po.Role;
import util.SqlSessionFactoryUtil;

/**
 * @author weihoong
 * @since 2017/11/17
 */
public class TestSet {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setId(3L);
            role.setRoleName("ABD");
            mapper.updateRole1(role);
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
