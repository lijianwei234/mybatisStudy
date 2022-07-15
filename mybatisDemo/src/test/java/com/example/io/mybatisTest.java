package com.example.io;

import com.example.pojo.User;
import com.example.sqlSession.SqlSession;
import com.example.sqlSession.SqlSessionFactory;
import com.example.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.InputStream;

public class mybatisTest {

    @Test
    public void test() throws PropertyVetoException, DocumentException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        User user1 = sqlSession.selectOne("user.selectOne", user);
    }

}
