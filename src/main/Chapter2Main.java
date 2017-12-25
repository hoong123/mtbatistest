package main;

import mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import po.Role;
import util.SqlSessionFactoryUtil;

import java.util.HashMap;
import java.util.Map;

public class Chapter2Main {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("testName");
            role.setNote("testNote");
            roleMapper.insertRole(role);
            roleMapper.deleteRole(1L);
            Map<String, String> paramsMap = new HashMap<String, String>();
            paramsMap.put("roleName", "me");
            paramsMap.put("note", "te");
            roleMapper.findRoleByMap(paramsMap);
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
