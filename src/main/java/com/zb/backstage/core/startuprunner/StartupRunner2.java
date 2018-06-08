package com.zb.backstage.core.startuprunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: zb
 * @Date: Created in 2018/6/8 15:16
 * @Description: 初始化资源2
 */
@Component
@Order(value = -1)
public class StartupRunner2 implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(StartupRunner2.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("服务器启动成功！<<<<使用CommandLineRunner接口");
    }
}
