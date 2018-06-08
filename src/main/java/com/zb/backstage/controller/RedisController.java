package com.zb.backstage.controller;

import com.zb.backstage.service.RedisService;
import com.zb.backstage.core.util.Result;
import com.zb.backstage.core.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zb
 * @Date: Created in 2018/5/30 18:12
 * @Description:
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Resource
    private RedisService redisService;

    @PostMapping("/setRedis")
    public Result<String> setRedis(String name) {
        redisService.set("name",name);
        return ResultUtil.SUCCESS_DATA(name);
    }

    @GetMapping("/getRedis")
    public Result<String> getRedis() {
        String name = redisService.get("name");
        return ResultUtil.SUCCESS_DATA(name);
    }
}
