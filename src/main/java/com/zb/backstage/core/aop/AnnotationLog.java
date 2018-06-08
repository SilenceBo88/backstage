package com.zb.backstage.core.aop;

import java.lang.annotation.*;

/**
 * @Author: zb
 * @Date: Created in 2018/5/31 20:23
 * @Description:
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnotationLog {
    String remark() default "";
}
