package com.zb.backstage.service;

import com.zb.backstage.model.SystemLog;
import com.zb.backstage.core.common.Service;

import java.util.List;

/**
* @Description: SystemLogService接口
* @author zb
* @date 2018/05/29 16:35
*/
public interface SystemLogService extends Service<SystemLog> {

    Integer insertByBatch(List<SystemLog> list);
}