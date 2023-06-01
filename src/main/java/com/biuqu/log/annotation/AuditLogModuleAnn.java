package com.biuqu.log.annotation;

import java.lang.annotation.*;

/**
 * 操作日志模块目标注解
 * <br>
 * 该注解加在类上，表示该类为一个业务模块
 *
 * @date: 2019/9/2 17:58
 * @author: BiuQu
 * @since: JDK 1.8
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuditLogModuleAnn
{
    /**
     * 业务模块的名称
     *
     * @return 模块名称
     */
    String name() default "";
}
