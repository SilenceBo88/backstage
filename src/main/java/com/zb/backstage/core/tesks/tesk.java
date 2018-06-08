package com.zb.backstage.core.tesks;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: zb
 * @Date: Created in 2018/6/8 17:02
 * @Description: 定时任务
 */
@Component
//开启定时任务的注解
@EnableScheduling
public class tesk {

    @Scheduled(fixedRate = 5000)
    public void job1(){
        System.out.println("定时任务1" + new Date());
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void job2(){
        System.out.println("定时任务2" + new Date());
    }
}
