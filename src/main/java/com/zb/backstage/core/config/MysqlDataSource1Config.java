package com.zb.backstage.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @Author: zb
 * @Date: Created in 2018/5/30 14:26
 * @Description:
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.zb.backstage.dao.db1"})
public class MysqlDataSource1Config {

    @Bean(name = "primaryDataSource")
    //需设置主数据源
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.db1")
    public DataSource dataSource(){
        //跟之前不一样了
        return new DruidDataSource();
    }

    @Bean(name = "primaryTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(dataSource());

    }

    @Bean(name="primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("primaryDataSource")DataSource primaryDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(primaryDataSource);
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db1/*.xml");
        sessionFactory.setMapperLocations(mapperLocations);
        return sessionFactory.getObject();
    }
}
