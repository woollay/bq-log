package com.biuqu.log.annotation;

import java.lang.annotation.*;

/**
 * 客户调用日志(SDK)目标注解
 * <br>
 * 该注解加在需要记录日志的方法上
 *
 * @author BiuQu
 * @date 2023/2/5 10:12
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ClientLogAnn
{
    /**
     * 接口价格
     *
     * @return 价格, 0或者""表示免费
     */
    String price() default "";
}
