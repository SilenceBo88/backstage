package com.zb.backstage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zb.backstage.core.aop.AnnotationLog;
import com.zb.backstage.model.UserInfo;
import com.zb.backstage.service.UserInfoService;
import com.zb.backstage.core.util.ResultUtil;
import com.zb.backstage.core.util.Result;
import com.zb.backstage.core.util.ServiceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zb
 * @Date: Created in 2018/5/23 13:32
 * @Description:
 */
@RestController
@RequestMapping("userInfo")
@Api(tags = {"用户操作接口"}, description = "UserInfoController")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @GetMapping("/hello")
    public String hello(){
        return "hello spring boot";
    }

    @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true,
                    dataType = "string", paramType = "query")
    })
    @GetMapping("/selectById")
    @AnnotationLog(remark = "查询")
    public Result<UserInfo> selectById(@RequestParam String id) {
        UserInfo userInfo = userInfoService.selectById(id);
        if(userInfo == null){
            throw new ServiceException("该用户不存在");
        }
        return ResultUtil.SUCCESS(userInfo);
    }

    @ApiOperation(value = "查询用户", notes = "分页查询所有用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码",
                    dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数",
                    dataType = "string", paramType = "query")
    })
    @GetMapping("/selectAll")
    public Result<PageInfo<UserInfo>> selectAll(@RequestParam(defaultValue = "0")Integer page,
                                                @RequestParam(defaultValue = "0")Integer size){
        PageHelper.startPage(page,size);
        List<UserInfo> userInfoList = userInfoService.selectAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfoList);
        return ResultUtil.SUCCESS(pageInfo);
    }

    @PostMapping("/login")
    public Result<UserInfo> login(String userName, String password) {
        Subject currentUser = SecurityUtils.getSubject();
        //登录
        try {
            currentUser.login(new UsernamePasswordToken(userName, password));
        }catch (IncorrectCredentialsException i){
            throw new ServiceException("密码输入错误");
        }
        //从session取出用户信息
        UserInfo user = (UserInfo) currentUser.getPrincipal();
        return ResultUtil.SUCCESS(user);
    }
}
