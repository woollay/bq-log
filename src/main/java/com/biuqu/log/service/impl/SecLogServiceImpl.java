package com.biuqu.log.service.impl;

import com.biuqu.log.dao.LogDao;
import com.biuqu.log.model.SecurityLog;
import com.biuqu.log.service.BaseLogService;

/**
 * 安全日志服务具体实现
 * <br>
 *
 * @date: 2019/9/3 8:19
 * @author: BiuQu
 * @since: JDK 1.8
 */
public class SecLogServiceImpl extends BaseLogService<SecurityLog>
{
    public SecLogServiceImpl(LogDao<SecurityLog> logDao)
    {
        super(logDao);
    }
}