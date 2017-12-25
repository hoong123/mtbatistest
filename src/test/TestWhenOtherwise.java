package test;

import mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import po.Role;
import util.SqlSessionFactoryUtil;

/**
 * @author weihoong
 * @since 2017/11/14
 */
public class TestWhenOtherwise {


    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setId(3L);
            Role roles1 = mapper.findRoles1(role);
            System.out.println(roles1);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
