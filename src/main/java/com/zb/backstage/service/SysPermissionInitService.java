package com.zb.backstage.service;

import com.zb.backstage.model.SysPermissionInit;
import com.zb.backstage.core.common.Service;

import java.util.List;

/**
* @Description: SysPermissionInitService接口
* @author zb
* @date 2018/05/31 15:19
*/
public interface SysPermissionInitService extends Service<SysPermissionInit> {

    List<SysPermissionInit> selectAllOrderBySort();
}