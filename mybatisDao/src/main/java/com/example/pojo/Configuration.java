package com.example.pojo;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 存放sqlMapConfig.xml的属性
 */
public class Configuration {

    private DataSource dataSource;

    /**
     * key: statementId
     * value: 分装好的mappedStatement
     */
    Map<String, MappedStatement> mappedStatementMap = new HashMap<>();

}
