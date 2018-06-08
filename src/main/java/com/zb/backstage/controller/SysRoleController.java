package com.zb.backstage.controller;

import com.zb.backstage.core.util.Result;
import com.zb.backstage.core.util.ResultUtil;
import com.zb.backstage.core.util.ApplicationUtil;
import com.zb.backstage.model.SysRole;
import com.zb.backstage.service.SysRoleService;
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
* @Description: SysRoleController类
* @author zb
* @date 2018/05/30 20:43
*/
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    @PostMapping("/insert")
    public Result<Integer> insert(SysRole sysRole) throws Exception{
        sysRole.setId(ApplicationUtil.getUUID());
        Integer state = sysRoleService.insert(sysRole);
        return ResultUtil.SUCCESS(state);
    }

    @PostMapping("/deleteById")
    public Result<Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = sysRoleService.deleteById(id);
        return ResultUtil.SUCCESS(state);
    }

    @PostMapping("/update")
    public Result<Integer> update(SysRole sysRole) throws Exception {
        Integer state = sysRoleService.update(sysRole);
        return ResultUtil.SUCCESS(state);
    }

    @GetMapping("/selectById")
    public Result<SysRole> selectById(@RequestParam String id) throws Exception {
        SysRole sysRole = sysRoleService.selectById(id);
        return ResultUtil.SUCCESS(sysRole);
    }

    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn RetResult<PageInfo<SysRole>>
    */
    @GetMapping("/list")
    public Result<PageInfo<SysRole>> list(@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<SysRole> list = sysRoleService.selectAll();
        PageInfo<SysRole> pageInfo = new PageInfo<SysRole>(list);
        return ResultUtil.SUCCESS(pageInfo);
    }
}