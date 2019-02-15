package io.coeuvre.analysis.mybatis.driver;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Map;

public class BuildingSqlSessionFactoryFromXMLDriver {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        Long userId = 1L;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Map<String, Object> result = sqlSession.selectOne("io.coeuvre.analysis.mybatis.driver.mapper.UserMapper.findUserById", userId);
            System.out.println(result);
        }
    }
}
