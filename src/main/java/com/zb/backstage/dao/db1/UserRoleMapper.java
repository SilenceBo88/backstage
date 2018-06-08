package com.zb.backstage.dao.db1;

import com.zb.backstage.core.common.Mapper;
import com.zb.backstage.model.UserRole;

import java.util.List;

public interface UserRoleMapper extends Mapper<UserRole> {

    List<String> getRolesByUserId(String userId);
}