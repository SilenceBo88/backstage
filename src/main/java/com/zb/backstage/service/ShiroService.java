package com.zb.backstage.service;

import java.util.Map;

/**
 * @Author: zb
 * @Date: Created in 2018/5/31 15:55
 * @Description: shiro 动态更新权限
 */
public interface ShiroService {

    Map<String, String> loadFilterChainDefinitions();

    /**
     * 动态修改权限
     */
    void updatePermission();
}
