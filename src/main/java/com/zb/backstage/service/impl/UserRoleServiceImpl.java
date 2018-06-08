package com.zb.backstage.service.impl;

import com.zb.backstage.dao.db1.UserRoleMapper;
import com.zb.backstage.model.UserRole;
import com.zb.backstage.service.UserRoleService;
import com.zb.backstage.core.common.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: UserRoleService接口实现类
* @author zb
* @date 2018/05/30 20:36
*/
@Service
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    public List<String> getRolesByUserId(String userId){
        return userRoleMapper.getRolesByUserId(userId);
    }
}