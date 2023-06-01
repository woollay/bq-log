package com.biuqu.log.service;

import com.biuqu.log.dao.LogDao;
import com.biuqu.log.dao.impl.ChannelLogDaoImpl;
import com.biuqu.log.dao.impl.ClientLogDaoImpl;
import com.biuqu.log.model.*;
import com.biuqu.log.service.impl.*;
import lombok.extern.slf4j.Slf4j;

/**
 * 日志服务门面类
 * <br>
 *
 * @date: 2019/9/4 8:06
 * @author: BiuQu
 * @since: JDK 1.8
 */
@Slf4j
public class LogFacade
{
    public LogFacade(LogDao<OperationLog> opDao, LogDao<SecurityLog> secDao, LogDao<SystemLog> sysDao)
    {
        this.opService = new OpLogServiceImpl(opDao);
        this.secService = new SecLogServiceImpl(secDao);
        this.sysService = new SysLogServiceImpl(sysDao);
        //接口调用日志只需要保存至日志文件即可，不需要考虑存储介质切换
        this.clientService = new ClientLogServiceImpl(new ClientLogDaoImpl());
        this.channelService = new ChannelLogServiceImpl(new ChannelLogDaoImpl());
    }

    /**
     * 保存日志
     *
     * @param bizLog 业务日志对象
     * @param <T>    日志对象类别
     */
    public <T extends BaseLog> void saveLog(T bizLog)
    {
        LogService<T> logService = getService(bizLog);
        if (null == logService)
        {
            log.error("failed to save log by log type:{}", bizLog.getClass().getName());
            return;
        }
        logService.saveLog(bizLog);
    }

    /**
     * 获取日志服务对象
     *
     * @param log 日志服务
     * @param <T> 日志类别
     * @return 日志对象对应的服务
     */
    private <T extends BaseLog> LogService<T> getService(T log)
    {
        LogService<T> logService = null;
        if (log.getClass() == SecurityLog.class)
        {
            logService = (LogService<T>)this.secService;
        }
        else if (log.getClass() == SystemLog.class)
        {
            logService = (LogService<T>)this.sysService;
        }
        else if (log.getClass() == OperationLog.class)
        {
            logService = (LogService<T>)this.opService;
        }
        else if (log.getClass() == ClientLog.class)
        {
            logService = (LogService<T>)this.clientService;
        }
        else if (log.getClass() == ChannelLog.class)
        {
            logService = (LogService<T>)this.channelService;
        }
        return logService;
    }

    /**
     * 操作日志服务
     */
    private LogService<OperationLog> opService;

    /**
     * 安全日志服务
     */
    private LogService<SecurityLog> secService;

    /**
     * 系统日志服务
     */
    private LogService<SystemLog> sysService;

    /**
     * 客户调用日志
     */
    private LogService<ClientLog> clientService;

    /**
     * 客户调用渠道的日志
     */
    private LogService<ChannelLog> channelService;
}
