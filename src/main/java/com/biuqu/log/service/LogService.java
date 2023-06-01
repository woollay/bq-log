package com.biuqu.log.service;

import com.biuqu.log.model.BaseLog;

/**
 * 记录日志服务接口
 * <br>
 *
 * @date: 2019/9/3 8:15
 * @author: BiuQu
 * @since: JDK 1.8
 */
public interface LogService<T extends BaseLog>
{
    /**
     * 记录日志
     *
     * @param log 日志对象
     */
    void saveLog(T log);
}
