package com.zb.backstage.service.impl;

import com.zb.backstage.core.common.AbstractService;
import com.zb.backstage.dao.db1.UserInfoMapper;
import com.zb.backstage.model.UserInfo;
import com.zb.backstage.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: zb
 * @Date: Created in 2018/5/23 14:36
 * @Description:
 */
@Service
public class UserInfoServiceImpl extends AbstractService<UserInfo> implements UserInfoService {

    @Resource
    UserInfoMapper userInfoMapper;
}
