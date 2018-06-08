package com.zb.backstage.controller;

import com.zb.backstage.core.util.Result;
import com.zb.backstage.core.util.ResultUtil;
import com.zb.backstage.core.util.ApplicationUtil;
import com.zb.backstage.model.SysPermissionInit;
import com.zb.backstage.service.SysPermissionInitService;
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
* @Description: SysPermissionInitController类
* @author zb
* @date 2018/05/31 15:19
*/
@RestController
@RequestMapping("/sysPermissionInit")
public class SysPermissionInitController {

    @Resource
    private SysPermissionInitService sysPermissionInitService;

    @PostMapping("/insert")
    public Result<Integer> insert(SysPermissionInit sysPermissionInit) throws Exception{
        sysPermissionInit.setId(ApplicationUtil.getUUID());
        Integer state = sysPermissionInitService.insert(sysPermissionInit);
        return ResultUtil.SUCCESS(state);
    }

    @PostMapping("/deleteById")
    public Result<Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = sysPermissionInitService.deleteById(id);
        return ResultUtil.SUCCESS(state);
    }

    @PostMapping("/update")
    public Result<Integer> update(SysPermissionInit sysPermissionInit) throws Exception {
        Integer state = sysPermissionInitService.update(sysPermissionInit);
        return ResultUtil.SUCCESS(state);
    }

    @GetMapping("/selectById")
    public Result<SysPermissionInit> selectById(@RequestParam String id) throws Exception {
        SysPermissionInit sysPermissionInit = sysPermissionInitService.selectById(id);
        return ResultUtil.SUCCESS(sysPermissionInit);
    }

    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn RetResult<PageInfo<SysPermissionInit>>
    */
    @GetMapping("/list")
    public Result<PageInfo<SysPermissionInit>> list(@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<SysPermissionInit> list = sysPermissionInitService.selectAll();
        PageInfo<SysPermissionInit> pageInfo = new PageInfo<SysPermissionInit>(list);
        return ResultUtil.SUCCESS(pageInfo);
    }
}