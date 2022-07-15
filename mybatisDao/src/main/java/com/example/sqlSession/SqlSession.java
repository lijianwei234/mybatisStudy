package com.example.sqlSession;

import java.sql.SQLException;
import java.util.List;

public interface SqlSession {

    //查询所有
    public <E> List<E> selectList(String statementId, Object... params) throws SQLException, Exception;

    //查询指定条件的数据
    public <T> T selectOne(String statementId, Object... params) throws SQLException, Exception;


    //为dao层生成代理类
    public <T> T getMapper(Class<?> mapperClass);

}
