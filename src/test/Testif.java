package test;

import mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import po.Role;
import util.SqlSessionFactoryUtil;

/**
 * @author weihoong
 * @since 2017/11/14
 */
public class Testif {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.findRoles3("Note");
            System.out.println(role);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
