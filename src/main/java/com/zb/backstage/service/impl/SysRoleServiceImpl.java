package com.zb.backstage.service.impl;

import com.zb.backstage.dao.db1.SysRoleMapper;
import com.zb.backstage.model.SysRole;
import com.zb.backstage.service.SysRoleService;
import com.zb.backstage.core.common.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: SysRoleService接口实现类
* @author zb
* @date 2018/05/30 20:43
*/
@Service
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

}