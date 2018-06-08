package com.zb.backstage.service.impl;

import com.zb.backstage.dao.db1.SystemLogMapper;
import com.zb.backstage.model.SystemLog;
import com.zb.backstage.service.SystemLogService;
import com.zb.backstage.core.common.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: SystemLogService接口实现类
* @author zb
* @date 2018/05/29 16:35
*/
@Service
public class SystemLogServiceImpl extends AbstractService<SystemLog> implements SystemLogService {

    @Resource
    private SystemLogMapper systemLogMapper;

    @Override
    public Integer insertByBatch(List<SystemLog> list) {
        return systemLogMapper.insertByBatch(list);
    }
}