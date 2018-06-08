package com.zb.backstage.service;

import com.zb.backstage.model.RolePerm;
import com.zb.backstage.core.common.Service;

import java.util.List;

/**
* @Description: RolePermService接口
* @author zb
* @date 2018/05/30 20:36
*/
public interface RolePermService extends Service<RolePerm> {

    List<String> getPermsByUserId(String userId);
}