package com.biuqu.log.service.impl;

import com.biuqu.log.dao.LogDao;
import com.biuqu.log.model.ChannelLog;
import com.biuqu.log.service.BaseLogService;

/**
 * 调用第三方的日志记录服务
 *
 * @author BiuQu
 * @date 2023/2/5 09:08
 */
public class ChannelLogServiceImpl extends BaseLogService<ChannelLog>
{
    public ChannelLogServiceImpl(LogDao<ChannelLog> logDao)
    {
        super(logDao);
    }
}
