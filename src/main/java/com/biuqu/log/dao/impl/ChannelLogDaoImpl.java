package com.biuqu.log.dao.impl;

import com.biuqu.log.dao.LogDao;
import com.biuqu.log.model.ChannelLog;
import lombok.extern.slf4j.Slf4j;

/**
 * 接口调用第三方渠道的日志记录实现
 *
 * @author BiuQu
 * @date 2023/2/5 08:53
 */
@Slf4j
public class ChannelLogDaoImpl implements LogDao<ChannelLog>
{
    @Override
    public void saveLog(ChannelLog channelLog)
    {
        log.info(channelLog.toString());
    }
}
