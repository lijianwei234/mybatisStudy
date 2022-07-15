package com.example.sqlSession;

import com.example.pojo.Configuration;
import com.example.pojo.MappedStatement;

import java.util.List;

public class SimpleExecutor implements Executor{
    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) {
        return null;
    }
}
