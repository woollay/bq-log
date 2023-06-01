package com.biuqu.log.service.impl;

import com.biuqu.log.dao.LogDao;
import com.biuqu.log.model.ClientLog;
import com.biuqu.log.service.BaseLogService;

/**
 * 客户调用日志的实现
 *
 * @author BiuQu
 * @date 2023/2/5 08:49
 */
public class ClientLogServiceImpl extends BaseLogService<ClientLog>
{
    public ClientLogServiceImpl(LogDao<ClientLog> logDao)
    {
        super(logDao);
    }
}
