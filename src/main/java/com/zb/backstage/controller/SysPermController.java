package com.zb.backstage.controller;

import com.zb.backstage.core.util.Result;
import com.zb.backstage.core.util.ResultUtil;
import com.zb.backstage.core.util.ApplicationUtil;
import com.zb.backstage.model.SysPerm;
import com.zb.backstage.service.SysPermService;
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
* @Description: SysPermController类
* @author zb
* @date 2018/05/30 20:39
*/
@RestController
@RequestMapping("/sysPerm")
public class SysPermController {

    @Resource
    private SysPermService sysPermService;

    @PostMapping("/insert")
    public Result<Integer> insert(SysPerm sysPerm) throws Exception{
        sysPerm.setId(ApplicationUtil.getUUID());
        Integer state = sysPermService.insert(sysPerm);
        return ResultUtil.SUCCESS(state);
    }

    @PostMapping("/deleteById")
    public Result<Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = sysPermService.deleteById(id);
        return ResultUtil.SUCCESS(state);
    }

    @PostMapping("/update")
    public Result<Integer> update(SysPerm sysPerm) throws Exception {
        Integer state = sysPermService.update(sysPerm);
        return ResultUtil.SUCCESS(state);
    }

    @GetMapping("/selectById")
    public Result<SysPerm> selectById(@RequestParam String id) throws Exception {
        SysPerm sysPerm = sysPermService.selectById(id);
        return ResultUtil.SUCCESS(sysPerm);
    }

    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn RetResult<PageInfo<SysPerm>>
    */
    @GetMapping("/list")
    public Result<PageInfo<SysPerm>> list(@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<SysPerm> list = sysPermService.selectAll();
        PageInfo<SysPerm> pageInfo = new PageInfo<SysPerm>(list);
        return ResultUtil.SUCCESS(pageInfo);
    }
}