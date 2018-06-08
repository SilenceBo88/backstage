package com.zb.backstage.core.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.zb.backstage.core.interceptor.Interceptor1;
import com.zb.backstage.core.util.Result;
import com.zb.backstage.core.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zb
 * @Date: Created in 2018/5/23 21:21
 * @Description: 处理返回的json数据
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    /**
     * TODO  修改为自己的需求
     */
    private static final String IZATION = "CESHI";

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 修改自定义消息转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setSupportedMediaTypes(getSupportedMediaTypes());
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                // String null -> ""
                SerializerFeature.WriteNullStringAsEmpty,
                // Number null -> 0
                SerializerFeature.WriteNullNumberAsZero,
                //禁止循环引用
                SerializerFeature.DisableCircularReferenceDetect
        );
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(converter);
    }

    private List<MediaType> getSupportedMediaTypes() {
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);
        return supportedMediaTypes;
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/favicon.ico")
                .addResourceLocations("classpath:/META-INF/resources/favicon.ico");

        super.addResourceHandlers(registry);
    }


    /**
     * 添加拦截器  请求头拦截
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*registry.addInterceptor(
                //注意，HandlerInterceptorAdapter  这里可以修改为自己创建的拦截器
                new HandlerInterceptorAdapter() {
                    @Override
                    public boolean preHandle(HttpServletRequest request,
                                             HttpServletResponse response, Object handler) throws Exception {
                        String ization = request.getHeader("ization");
                        if(IZATION.equals(ization)){
                            return true;
                        }else{
                            Result<Object> result = new Result<>();
                            result.setCode(ResultCode.UNAUTHORIZED).setMsg("签名认证失败");
                            responseResult(response, result);
                            return false;
                        }
                    }
                }
                //这里添加的是拦截的路径  /**为全部拦截
        ).addPathPatterns("/userInfo/selectAll");*/

        registry.addInterceptor(
            new Interceptor1() {
                @Override
                public boolean preHandle(HttpServletRequest request,
                                         HttpServletResponse response, Object handler) throws Exception {
                    String ization = request.getHeader("ization");
                    if(IZATION.equals(ization)){
                        return true;
                    }else{
                        Result<Object> result = new Result<>();
                        result.setCode(ResultCode.UNAUTHORIZED).setMsg("签名认证失败");
                        responseResult(response, result);
                        return false;
                    }
                }
            }
            //这里添加的是拦截的路径  /**为全部拦截
        ).addPathPatterns("/userInfo/selectAll");
    }

    private void responseResult(HttpServletResponse response, Result<Object> result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
}
