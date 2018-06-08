package com.zb.backstage.dao.db1;

import com.zb.backstage.core.common.Mapper;
import com.zb.backstage.model.RolePerm;

import java.util.List;

public interface RolePermMapper extends Mapper<RolePerm> {

    List<String> getPermsByUserId(String userId);
}