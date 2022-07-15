package com.example.sqlSession;

import com.example.pojo.Configuration;
import com.example.pojo.MappedStatement;

import java.sql.SQLException;
import java.util.List;

public interface Executor {

    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws SQLException;

}
