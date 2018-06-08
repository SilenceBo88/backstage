package com.zb.backstage.controller;

import com.zb.backstage.core.tool.MailConstant;
import com.zb.backstage.core.util.ApplicationUtil;
import com.zb.backstage.core.util.Result;
import com.zb.backstage.core.util.ResultUtil;
import com.zb.backstage.model.Mail;
import com.zb.backstage.service.MailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zb
 * @Date: Created in 2018/6/1 12:14
 * @Description:
 */
@RestController
@RequestMapping("/mail")
public class MailController {

    @Resource
    private MailService mailService;

    /**
     * 发送注册验证码
     * @param mail
     * @return 验证码
     * @throws Exception
     */
    @PostMapping("/sendTemplateMail")
    public Result<String> sendTemplateMail(Mail mail) throws Exception {
        String identifyingCode = ApplicationUtil.getNumStringRandom(6);
        mail.setSubject("欢迎注册");
        mail.setTemplateName(MailConstant.RETGISTEREMPLATE);
        Map<String,String> map = new HashMap<>();
        map.put("identifyingCode",identifyingCode);
        map.put("to",mail.getTo()[0]);
        mail.setTemplateModel(map);
        mailService.sendTemplateMail(mail);

        return ResultUtil.SUCCESS_DATA(identifyingCode);
    }

    @PostMapping("/sendAttachmentsMail")
    public Result<String> sendAttachmentsMail(Mail mail,HttpServletRequest request) throws Exception {
        mail.setSubject("测试附件");
        mailService.sendAttachmentsMail(mail, request);
        return ResultUtil.SUCCESS();
    }
}
