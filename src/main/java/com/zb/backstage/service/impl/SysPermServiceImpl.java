package com.zb.backstage.service.impl;

import com.zb.backstage.dao.db1.SysPermMapper;
import com.zb.backstage.model.SysPerm;
import com.zb.backstage.service.SysPermService;
import com.zb.backstage.core.common.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: SysPermService接口实现类
* @author zb
* @date 2018/05/30 20:39
*/
@Service
public class SysPermServiceImpl extends AbstractService<SysPerm> implements SysPermService {

    @Resource
    private SysPermMapper sysPermMapper;

}