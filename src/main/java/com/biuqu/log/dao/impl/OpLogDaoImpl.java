package com.biuqu.log.dao.impl;

import com.biuqu.log.dao.LogDao;
import com.biuqu.log.model.OperationLog;
import lombok.extern.slf4j.Slf4j;

/**
 * 操作日志持久化实现
 * <br>
 *
 * @date: 2019/9/3 8:23
 * @author: BiuQu
 * @since: JDK 1.8
 */
@Slf4j
public class OpLogDaoImpl implements LogDao<OperationLog>
{
    @Override
    public void saveLog(OperationLog opLog)
    {
        log.info(opLog.toString());
    }
}