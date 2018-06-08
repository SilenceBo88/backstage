package com.zb.backstage.controller;

import com.zb.backstage.core.util.Result;
import com.zb.backstage.core.util.ResultUtil;
import com.zb.backstage.core.util.ApplicationUtil;
import com.zb.backstage.model.SystemLog;
import com.zb.backstage.service.SystemLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: SystemLogController类
* @author zb
* @date 2018/05/29 16:35
*/
@RestController
@RequestMapping("/systemLog")
public class SystemLogController {

    @Resource
    private SystemLogService systemLogService;

    @PostMapping("/insert")
    public Result<Integer> insert(SystemLog systemLog) throws Exception{
        systemLog.setId(ApplicationUtil.getUUID());
        Integer state = systemLogService.insert(systemLog);
        return ResultUtil.SUCCESS(state);
    }

    @PostMapping("/deleteById")
    public Result<Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = systemLogService.deleteById(id);
        return ResultUtil.SUCCESS(state);
    }

    @PostMapping("/update")
    public Result<Integer> update(SystemLog systemLog) throws Exception {
        Integer state = systemLogService.update(systemLog);
        return ResultUtil.SUCCESS(state);
    }

    @GetMapping("/selectById")
    public Result<SystemLog> selectById(@RequestParam String id) throws Exception {
        SystemLog systemLog = systemLogService.selectById(id);
        return ResultUtil.SUCCESS(systemLog);
    }

    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn RetResult<PageInfo<SystemLog>>
    */
    @GetMapping("/list")
    public Result<PageInfo<SystemLog>> list(@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<SystemLog> list = systemLogService.selectAll();
        PageInfo<SystemLog> pageInfo = new PageInfo<SystemLog>(list);
        return ResultUtil.SUCCESS(pageInfo);
    }
}