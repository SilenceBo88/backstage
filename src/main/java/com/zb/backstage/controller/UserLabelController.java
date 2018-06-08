package com.zb.backstage.controller;

import com.zb.backstage.core.util.Result;
import com.zb.backstage.core.util.ResultUtil;
import com.zb.backstage.core.util.ApplicationUtil;
import com.zb.backstage.model.UserLabel;
import com.zb.backstage.service.UserLabelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: UserLabelController类
* @author zb
* @date 2018/05/30 15:36
*/
@RestController
@RequestMapping("/userLabel")
public class UserLabelController {

    @Resource
    private UserLabelService userLabelService;

    @PostMapping("/insert")
    public Result<Integer> insert(UserLabel userLabel) throws Exception{
        userLabel.setId(ApplicationUtil.getUUID());
        Integer state = userLabelService.insert(userLabel);
        return ResultUtil.SUCCESS(state);
    }

    @PostMapping("/deleteById")
    public Result<Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = userLabelService.deleteById(id);
        return ResultUtil.SUCCESS(state);
    }

    @PostMapping("/update")
    public Result<Integer> update(UserLabel userLabel) throws Exception {
        Integer state = userLabelService.update(userLabel);
        return ResultUtil.SUCCESS(state);
    }

    @GetMapping("/selectById")
    public Result<UserLabel> selectById(@RequestParam String id) throws Exception {
        UserLabel userLabel = userLabelService.selectById(id);
        return ResultUtil.SUCCESS(userLabel);
    }

    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn RetResult<PageInfo<UserLabel>>
    */
    @GetMapping("/list")
    public Result<PageInfo<UserLabel>> list(@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<UserLabel> list = userLabelService.selectAll();
        PageInfo<UserLabel> pageInfo = new PageInfo<UserLabel>(list);
        return ResultUtil.SUCCESS(pageInfo);
    }
}