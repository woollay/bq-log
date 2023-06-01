package com.biuqu.log.service;

import com.biuqu.log.dao.LogDao;
import com.biuqu.log.model.BaseLog;

/**
 * 抽象日志服务
 *
 * @author BiuQu
 * @date 2023/2/3 21:55
 */
public abstract class BaseLogService<T extends BaseLog> implements LogService<T>
{
    public BaseLogService(LogDao<T> logDao)
    {
        this.logDao = logDao;
    }

    @Override
    public void saveLog(T log)
    {
        this.logDao.saveLog(log);
    }

    /**
     * 依赖的日志dao
     */
    private LogDao<T> logDao;
}
