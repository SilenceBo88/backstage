package com.zb.backstage.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @Author: zb
 * @Date: Created in 2018/5/30 14:33
 * @Description:
 */
@Configuration
@MapperScan(basePackages = {"com.zb.backstage.dao.db2"}, sqlSessionFactoryRef = "secondSqlSessionFactory")
public class MysqlDataSource2Config {
    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db2/*.xml");
        sessionFactory.setMapperLocations(mapperLocations);
        return sessionFactory.getObject();
    }
}
