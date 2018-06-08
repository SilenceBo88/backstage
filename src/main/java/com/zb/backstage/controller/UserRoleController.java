package com.zb.backstage.controller;

import com.zb.backstage.core.util.Result;
import com.zb.backstage.core.util.ResultUtil;
import com.zb.backstage.core.util.ApplicationUtil;
import com.zb.backstage.model.UserRole;
import com.zb.backstage.service.UserRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: UserRoleController类
* @author zb
* @date 2018/05/30 20:36
*/
@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Resource
    private UserRoleService userRoleService;

    @PostMapping("/insert")
    public Result<Integer> insert(UserRole userRole) throws Exception{
        userRole.setId(ApplicationUtil.getUUID());
        Integer state = userRoleService.insert(userRole);
        return ResultUtil.SUCCESS(state);
    }

    @PostMapping("/deleteById")
    public Result<Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = userRoleService.deleteById(id);
        return ResultUtil.SUCCESS(state);
    }

    @PostMapping("/update")
    public Result<Integer> update(UserRole userRole) throws Exception {
        Integer state = userRoleService.update(userRole);
        return ResultUtil.SUCCESS(state);
    }

    @GetMapping("/selectById")
    public Result<UserRole> selectById(@RequestParam String id) throws Exception {
        UserRole userRole = userRoleService.selectById(id);
        return ResultUtil.SUCCESS(userRole);
    }

    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn RetResult<PageInfo<UserRole>>
    */
    @GetMapping("/list")
    public Result<PageInfo<UserRole>> list(@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<UserRole> list = userRoleService.selectAll();
        PageInfo<UserRole> pageInfo = new PageInfo<UserRole>(list);
        return ResultUtil.SUCCESS(pageInfo);
    }
}