package com.zb.backstage.controller;

import com.zb.backstage.core.util.Result;
import com.zb.backstage.core.util.ResultUtil;
import com.zb.backstage.core.util.UploadActionUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: zb
 * @Date: Created in 2018/6/1 10:20
 * @Description:
 */
@RestController
@RequestMapping("uploadFile")
public class UploadFileController {

    @PostMapping("/upload")
    public Result<List<String>> upload(HttpServletRequest httpServletRequest) throws Exception {
        List<String> list = UploadActionUtil.uploadFile(httpServletRequest);
        return ResultUtil.SUCCESS(list);
    }
}
