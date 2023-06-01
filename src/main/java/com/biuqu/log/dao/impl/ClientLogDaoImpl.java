package com.biuqu.log.dao.impl;

import com.biuqu.log.dao.LogDao;
import com.biuqu.log.model.ClientLog;
import lombok.extern.slf4j.Slf4j;

/**
 * 客户调用日志的dao实现
 *
 * @author BiuQu
 * @date 2023/2/5 08:50
 */
@Slf4j
public class ClientLogDaoImpl implements LogDao<ClientLog>
{
    @Override
    public void saveLog(ClientLog clientLog)
    {
        log.info(clientLog.toString());
    }
}
