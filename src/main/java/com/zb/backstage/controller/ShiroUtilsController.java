package com.zb.backstage.controller;

import com.zb.backstage.model.UserInfo;
import com.zb.backstage.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zb
 * @Date: Created in 2018/5/30 21:17
 * @Description:
 */
@RestController
@RequestMapping("shiroUtils")
public class ShiroUtilsController {

    @Resource
    ShiroService shiroService;


    @GetMapping("/noLogin")
    public void noLogin() {
        throw new UnauthenticatedException("没有登录");
    }

    @GetMapping("/noAuthorize")
    public void noAuthorize() {
        throw new UnauthorizedException("没有权限");
    }


    @PostMapping("/getNowUser")
    public UserInfo getNowUser() {
        UserInfo u = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        return u;
    }

    /**
     * @Description: 重新加载shiro权限
     * @throws Exception
     */
    @PostMapping("/updatePermission")
    public void updatePermission() throws Exception {
        shiroService.updatePermission();
    }
}
