package test;

import mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import po.Role;
import util.SqlSessionFactoryUtil;

import java.util.List;

/**
 * @author weihoong
 * @since 2017/11/22
 */
public class TestBind {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            List<Role> roles4 = mapper.findRoles4("B", "t");
            for (Role role : roles4) {
                System.out.println(role);
            }
        }finally {
            if (sqlSession!=null) {
                sqlSession.close();
            }
        }
    }
}
