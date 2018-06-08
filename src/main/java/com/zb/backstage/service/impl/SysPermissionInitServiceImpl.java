package com.zb.backstage.service.impl;

import com.zb.backstage.dao.db1.SysPermissionInitMapper;
import com.zb.backstage.model.SysPermissionInit;
import com.zb.backstage.service.SysPermissionInitService;
import com.zb.backstage.core.common.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: SysPermissionInitService接口实现类
* @author zb
* @date 2018/05/31 15:19
*/
@Service
public class SysPermissionInitServiceImpl extends AbstractService<SysPermissionInit> implements SysPermissionInitService {

    @Resource
    private SysPermissionInitMapper sysPermissionInitMapper;

    @Override
    public List<SysPermissionInit> selectAllOrderBySort() {
        return sysPermissionInitMapper.selectAllOrderBySort();
    }
}