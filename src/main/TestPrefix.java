package main;

import mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import po.Role;
import util.SqlSessionFactoryUtil;

/**
 * @author Hoong
 */
public class TestPrefix {
    public static void main(String[]args){
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role = roleMapper.getRole(3L);
            sqlSession.commit();
            System.out.println(role.toString());
        }catch (Exception e){
            System.err.println(e.getMessage());
            sqlSession.rollback();
        }finally {
            if (sqlSession!=null)
                sqlSession.close();
        }
    }
}
