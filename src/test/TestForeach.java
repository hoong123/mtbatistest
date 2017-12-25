package test;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import po.User;
import util.SqlSessionFactoryUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author weihoong
 * @since 2017/11/22
 */
public class TestForeach {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List sexList = new ArrayList();
            sexList.add(1);
            sexList.add(2);
            List<User> userBySex = mapper.findUserBySex(sexList);
            for (User bySex : userBySex) {
                System.out.println(bySex);
            }
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
