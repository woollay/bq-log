package com.biuqu.log.service.impl;

import com.biuqu.log.dao.LogDao;
import com.biuqu.log.model.SystemLog;
import com.biuqu.log.service.BaseLogService;

/**
 * 系统日志服务具体实现
 * <br>
 *
 * @date: 2019/9/3 8:19
 * @author: BiuQu
 * @since: JDK 1.8
 */
public class SysLogServiceImpl extends BaseLogService<SystemLog>
{
    public SysLogServiceImpl(LogDao<SystemLog> logDao)
    {
        super(logDao);
    }
}