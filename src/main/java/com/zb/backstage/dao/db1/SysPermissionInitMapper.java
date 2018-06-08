package com.zb.backstage.dao.db1;

import com.zb.backstage.core.common.Mapper;
import com.zb.backstage.model.SysPermissionInit;

import java.util.List;

public interface SysPermissionInitMapper extends Mapper<SysPermissionInit> {

    List<SysPermissionInit> selectAllOrderBySort();
}