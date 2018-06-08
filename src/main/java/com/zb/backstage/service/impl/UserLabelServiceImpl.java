package com.zb.backstage.service.impl;

import com.zb.backstage.dao.db2.UserLabelMapper;
import com.zb.backstage.model.UserLabel;
import com.zb.backstage.service.UserLabelService;
import com.zb.backstage.core.common.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: UserLabelService接口实现类
* @author zb
* @date 2018/05/30 15:36
*/
@Service
public class UserLabelServiceImpl extends AbstractService<UserLabel> implements UserLabelService {

    @Resource
    private UserLabelMapper userLabelMapper;

}