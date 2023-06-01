package com.biuqu.log.annotation;

import com.biuqu.log.model.LevelType;
import com.biuqu.log.model.LogMapper;

import java.lang.annotation.*;

/**
 * 操作日志目标注解
 * <br>
 * 该注解加在需要记录日志的方法上
 *
 * @date: 2019/9/2 17:28
 * @author: BiuQu
 * @since: JDK 1.8
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuditLogAnn
{
    /**
     * 资源信息
     *
     * @return 资源对象
     */
    String resource() default "";

    /**
     * 详情
     *
     * @return 详情
     */
    String detail() default "";

    /**
     * 日志类别:CURD
     *
     * @return 日志增删改查类别
     */
    String type() default "";

    /**
     * 日志级别
     *
     * @return 日志级别
     */
    LevelType level() default LevelType.MINOR;

    /**
     * 日志解析类别
     *
     * @return 日志对象(系统日志 / 操作日志 / 安全日志)解析对象
     */
    LogMapper mapper() default LogMapper.OpMapper;
}
