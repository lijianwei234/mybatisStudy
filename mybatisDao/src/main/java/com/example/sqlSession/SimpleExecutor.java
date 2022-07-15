package com.example.sqlSession;

import com.example.config.BoundSql;
import com.example.pojo.Configuration;
import com.example.pojo.MappedStatement;
import com.example.utils.GenericTokenParser;
import com.example.utils.ParameterMapping;
import com.example.utils.ParameterMappingTokenHandler;
import com.example.utils.TokenHandler;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SimpleExecutor implements Executor{
    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws SQLException {
        //获取链接
        Connection connection = configuration.getDataSource().getConnection();

        //获取执行的sql语句
        String sql = mappedStatement.getSql();
        BoundSql boundSql = getBoundSql(sql);

        //获取预处理对象
        PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());

        //设置参数
        String paramterType = mappedStatement.getParamterType();
        Class<?> parameterClassType = getClassType(paramterType);

        List<ParameterMapping> parameterMappingList = boundSql.getParameterMappingList();
        for (int i = 0; i < parameterMappingList.size(); i++) {
            ParameterMapping parameterMapping = parameterMappingList.get(0);
            String content = parameterMapping.getContent();

            //反射
            Field field = null;
            try {
                field = parameterClassType.getDeclaredField(content);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            field.setAccessible(true);
            Object o = null;
            try {
                o = field.get(params[0]);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            preparedStatement.setObject(i+1, o);
        }

        //执行sql

        //封装返回结果集
        return null;
    }

    private Class<?> getClassType(String paramterType) {

        if (paramterType != null) {
            Class<?> aClass = null;
            try {
                aClass = Class.forName(paramterType);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return aClass;
        }
        return null;
    }

    /**
     * 将sql中#{}使用?来代替
     * 解析出#{}里面的值进行存储
     * @param sql
     * @return
     */
    private BoundSql getBoundSql(String sql) {
        //标记处理类：配置标记解析器来完成对占位符的解析处理
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();

        //解析出来的带?的token
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
        String parseSql = genericTokenParser.parse(sql);

        //#{}里面解析出来的参数名称
        List<ParameterMapping> parameterMappings = parameterMappingTokenHandler.getParameterMappings();

        BoundSql boundSql = new BoundSql(parseSql, parameterMappings);
        return boundSql;
    }
}
