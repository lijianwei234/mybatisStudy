package com.example.sqlSession;

import java.util.List;

public interface SqlSession {

    //查询所有
    public <E> List<E> selectList(String statementId, Object... params);

    //查询指定条件的数据
    public <T> T selectOne(String statementId, Object... params);

}
