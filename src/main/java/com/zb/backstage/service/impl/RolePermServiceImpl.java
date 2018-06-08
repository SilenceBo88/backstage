package com.zb.backstage.service.impl;

import com.zb.backstage.dao.db1.RolePermMapper;
import com.zb.backstage.model.RolePerm;
import com.zb.backstage.service.RolePermService;
import com.zb.backstage.core.common.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: RolePermService接口实现类
* @author zb
* @date 2018/05/30 20:36
*/
@Service
public class RolePermServiceImpl extends AbstractService<RolePerm> implements RolePermService {

    @Resource
    private RolePermMapper rolePermMapper;

    public List<String> getPermsByUserId(String userId){
        return rolePermMapper.getPermsByUserId(userId);
    }
}