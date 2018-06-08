package com.zb.backstage.dao.db1;

import com.zb.backstage.core.common.Mapper;
import com.zb.backstage.model.SystemLog;

import java.util.List;

public interface SystemLogMapper extends Mapper<SystemLog> {
    Integer insertByBatch(List<SystemLog> list);
}