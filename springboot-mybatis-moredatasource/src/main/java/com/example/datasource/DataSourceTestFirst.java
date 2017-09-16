package com.example.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
/**
 * 1.创建DataSource(数据源)
 * 2.创建SqlSessionFactory(指定mapper.xml位置)
 * 3.创建TransactionManager(事物)
 * 4.将SqlSessionFactory包装到SqlSessionTemplate
 * */
@Configuration
// @MapperScan是指明了扫描dao层，并且给dao层注入指定的SqlSessionTemplate。
// 所有@Bean都需要按照命名指定正确。
@MapperScan(basePackages = "com.example.mapper.testfirst",sqlSessionTemplateRef = "testFirstSqlSessionTemplate")
public class DataSourceTestFirst {

    @Bean(name = "testFirstDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.testfirst")
    @Primary
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "testFirstSqlSessionFactory")
    @Primary
    public SqlSessionFactory testFirstSqlSessionFactory(
            @Qualifier("testFirstDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:/mybatis/mapper/testfirst/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "testFirstTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(
            @Qualifier("testFirstDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "testFirstSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("testFirstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
