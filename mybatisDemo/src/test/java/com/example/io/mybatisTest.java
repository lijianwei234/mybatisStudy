package com.example.io;

import com.example.sqlSession.SqlSessionFactory;
import com.example.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class mybatisTest {

    @Test
    public void test() {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

}
