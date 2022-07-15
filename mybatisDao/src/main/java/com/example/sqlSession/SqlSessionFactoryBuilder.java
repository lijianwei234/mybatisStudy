package com.example.sqlSession;

import com.example.config.XMLConfigBuilder;
import com.example.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    /**
     * 1、解析配置文件到configuration实体中
     * 2、创建sqlSessionFactory
     * @param in
     * @return
     */
    public SqlSessionFactory build(InputStream in) throws DocumentException, PropertyVetoException {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);


    }

}
