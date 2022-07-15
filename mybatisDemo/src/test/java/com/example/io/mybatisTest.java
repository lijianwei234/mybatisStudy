package com.example.io;

import org.junit.Test;

import java.io.InputStream;

public class mybatisTest {

    @Test
    public void test() {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        System.out.println(resourceAsStream);
    }

}
