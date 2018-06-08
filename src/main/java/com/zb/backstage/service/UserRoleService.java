package com.zb.backstage.service;

import com.zb.backstage.model.UserRole;
import com.zb.backstage.core.common.Service;

import java.util.List;

/**
* @Description: UserRoleService接口
* @author zb
* @date 2018/05/30 20:36
*/
public interface UserRoleService extends Service<UserRole> {

    List<String> getRolesByUserId(String userId);
}