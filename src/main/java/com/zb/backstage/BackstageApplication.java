package com.zb.backstage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//启注解事务管理
@EnableTransactionManagement  // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class BackstageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackstageApplication.class, args);
    }
}
