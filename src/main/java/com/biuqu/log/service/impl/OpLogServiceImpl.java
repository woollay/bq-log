package com.biuqu.log.service.impl;

import com.biuqu.log.dao.LogDao;
import com.biuqu.log.model.OperationLog;
import com.biuqu.log.service.BaseLogService;

/**
 * 操作日志服务具体实现
 * <br>
 *
 * @date: 2019/9/3 8:19
 * @author: BiuQu
 * @since: JDK 1.8
 */
public class OpLogServiceImpl extends BaseLogService<OperationLog>
{
    public OpLogServiceImpl(LogDao<OperationLog> logDao)
    {
        super(logDao);
    }
}