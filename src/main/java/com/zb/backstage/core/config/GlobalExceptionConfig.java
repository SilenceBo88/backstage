package com.zb.backstage.core.config;

import com.zb.backstage.core.util.ResultCode;
import com.zb.backstage.core.util.ResultUtil;
import com.zb.backstage.core.util.ServiceException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zb
 * @Date: Created in 2018/5/27 15:13
 * @Description: 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionConfig {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = UnauthenticatedException.class)
    public Object page401(HttpServletRequest request, UnauthenticatedException e) {
        /*if (!isJson(request)){
            return responsePage(request, e);
        }else {
            return ResultUtil.Error(ResultCode.UNAUTHEN, e.getMessage());
        }*/
        return ResultUtil.Error(ResultCode.UNAUTHEN, e.getMessage());
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    public Object page403(HttpServletRequest request, UnauthorizedException e) {
        /*if (!isJson(request)){
            return responsePage(request, e);
        }else {
            return ResultUtil.Error(ResultCode.UNAUTHZ, e.getMessage());
        }*/
        return ResultUtil.Error(ResultCode.UNAUTHZ, e.getMessage());
    }

    /**
     * 找不到页面异常
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public Object not_foundExceptionHandler(HttpServletRequest request, NoHandlerFoundException e){
        /*if (!isJson(request)){
            return responsePage(request, e);
        }else {
            return ResultUtil.Error(ResultCode.NOT_FOUND,"接口 [" + request.getRequestURI() + "] 不存在");
        }*/
        return ResultUtil.Error(ResultCode.NOT_FOUND,"接口 [" + request.getRequestURI() + "] 不存在");
    }

    /**
     * 业务异常的处理
     */
    @ExceptionHandler(value = ServiceException.class)
    public Object serviceExceptionHandler(HttpServletRequest request, ServiceException e) {
        /*if (!isJson(request)){
            return responsePage(request, e);
        }else {
            return ResultUtil.Error(e.getCode(), e.getMessage());
        }*/
        return ResultUtil.Error(e.getCode(), e.getMessage());
    }

    /**
     * 其他异常统一处理
     */
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(HttpServletRequest request, Exception e) {
        /*if (!isJson(request)){
            return responsePage(request, e);
        }else {
            return ResultUtil.Error(ResultCode.INTERNAL_SERVER_ERROR , e.getMessage());
        }*/
        return ResultUtil.Error(ResultCode.INTERNAL_SERVER_ERROR , e.getMessage());
    }

    /**
     * 判断是不是ajax请求
     * @param request
     * @return
     */
    private boolean isJson(HttpServletRequest request){
        //使用HttpServletRequest中的header检测请求是否为ajax, 如果是ajax则返回json, 如果为非ajax则返回view(即ModelAndView)
        String contentTypeHeader = request.getHeader("Content-Type");
        String acceptHeader = request.getHeader("Accept");
        String xRequestedWith = request.getHeader("X-Requested-With");

        if ((contentTypeHeader != null && contentTypeHeader.contains("application/json"))
                || (acceptHeader != null && acceptHeader.contains("application/json"))
                || "XMLHttpRequest".equalsIgnoreCase(xRequestedWith)) {
            return true;

        } else {
            return false;
        }
    }

    /**
     * 返回视图
     * @param request
     * @param e
     * @return
     */
    private ModelAndView responsePage(HttpServletRequest request, Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", e.getMessage());
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.addObject("stackTrace", e.getStackTrace());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
