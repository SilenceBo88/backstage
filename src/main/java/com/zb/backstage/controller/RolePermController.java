package com.zb.backstage.controller;

import com.zb.backstage.core.util.Result;
import com.zb.backstage.core.util.ResultUtil;
import com.zb.backstage.core.util.ApplicationUtil;
import com.zb.backstage.model.RolePerm;
import com.zb.backstage.service.RolePermService;
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
* @Description: RolePermController类
* @author zb
* @date 2018/05/30 20:36
*/
@RestController
@RequestMapping("/rolePerm")
public class RolePermController {

    @Resource
    private RolePermService rolePermService;

    @PostMapping("/insert")
    public Result<Integer> insert(RolePerm rolePerm) throws Exception{
        rolePerm.setId(ApplicationUtil.getUUID());
        Integer state = rolePermService.insert(rolePerm);
        return ResultUtil.SUCCESS(state);
    }

    @PostMapping("/deleteById")
    public Result<Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = rolePermService.deleteById(id);
        return ResultUtil.SUCCESS(state);
    }

    @PostMapping("/update")
    public Result<Integer> update(RolePerm rolePerm) throws Exception {
        Integer state = rolePermService.update(rolePerm);
        return ResultUtil.SUCCESS(state);
    }

    @GetMapping("/selectById")
    public Result<RolePerm> selectById(@RequestParam String id) throws Exception {
        RolePerm rolePerm = rolePermService.selectById(id);
        return ResultUtil.SUCCESS(rolePerm);
    }

    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn RetResult<PageInfo<RolePerm>>
    */
    @GetMapping("/list")
    public Result<PageInfo<RolePerm>> list(@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<RolePerm> list = rolePermService.selectAll();
        PageInfo<RolePerm> pageInfo = new PageInfo<RolePerm>(list);
        return ResultUtil.SUCCESS(pageInfo);
    }
}