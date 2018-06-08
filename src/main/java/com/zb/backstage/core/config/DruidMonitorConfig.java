package com.zb.backstage.core.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zb
 * @Date: Created in 2018/5/23 19:36
 * @Description: druid监视功能配置
 */
@Configuration
public class DruidMonitorConfig {

    /**
     * 注册ServletRegistrationBean
     * @return
     */
    @Bean
    public ServletRegistrationBean registrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        /** 初始化参数配置，initParams**/
        //白名单
        bean.addInitParameter("allow", "127.0.0.1");//多个ip逗号隔开
        //IP黑名单 (存在共同时，deny优先于allow)
        //bean.addInitParameter("deny", "192.168.1.110");
        //登录查看信息的账号密码.
        bean.addInitParameter("loginUsername", "admin");
        bean.addInitParameter("loginPassword", "zhaobo..");
        //是否能够重置数据.
        bean.addInitParameter("resetEnable", "false");
        return bean;
    }

    /**
     * 注册FilterRegistrationBean
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        bean.addUrlPatterns("/*");
        //添加需要忽略的格式信息
        bean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return bean;
    }
}
