package com.biuqu.log.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户调用日志(接口统计日志)
 *
 * @author BiuQu
 * @date 2023/2/4 11:58
 */
@Data
public class ClientLog extends ChannelLog
{
    @Override
    public String toString()
    {
        List<Object> lists = new ArrayList<>();
        lists.add(super.toString());
        lists.add(StringUtils.defaultString(this.channelId));

        return StringUtils.join(lists, LINK);
    }

    /**
     * 渠道id
     */
    private String channelId;
}
