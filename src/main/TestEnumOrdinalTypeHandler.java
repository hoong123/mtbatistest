package main;

import enums.Sex;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import po.User;
import util.SqlSessionFactoryUtil;

import java.util.Date;


public class TestEnumOrdinalTypeHandler {
    public static void main(String[] args) {
        testEnumOrdinalTypeHandler();
    }

    public static void testEnumOrdinalTypeHandler() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUserName("zhangsan");
            user.setCname("张三");
            user.setMobile("18888888");
            user.setSex(Sex.MALE);
            user.setEmail("zhangsan@163.com");
            user.setNote("test EnumOrdinalTypeHandler!!");
            user.setBirthday(new Date());
            userMapper.insertUser(user);
            User user2 = userMapper.getUser(1L);
            System.out.println(user2.getSex());
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
