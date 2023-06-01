package com.biuqu.log.dao;

import com.biuqu.log.model.BaseLog;

/**
 * 日志持久化接口
 * <br>
 *
 * @date: 2019/9/3 8:21
 * @author: BiuQu
 * @since: JDK 1.8
 */
public interface LogDao<T extends BaseLog>
{
    /**
     * 持久化日志
     *
     * @param log 日志对象
     */
    void saveLog(T log);
}
