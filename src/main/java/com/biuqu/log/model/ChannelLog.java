package com.biuqu.log.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 渠道调用日志(接口统计日志)
 *
 * @author BiuQu
 * @date 2023/2/4 12:15
 */
@Data
public class ChannelLog extends BaseLog
{
    @Override
    public String toString()
    {
        List<Object> lists = new ArrayList<>();
        lists.add(super.toString());
        lists.add(StringUtils.defaultString(this.repId));
        lists.add(StringUtils.defaultString(this.respId));
        lists.add(StringUtils.defaultString(this.code));
        lists.add(StringUtils.defaultString(this.msg));
        lists.add(StringUtils.defaultString(this.urlId));
        lists.add(StringUtils.defaultString(this.url));
        lists.add(this.cost);

        return StringUtils.join(lists, LINK);
    }

    /**
     * 请求id
     */
    private String repId;

    /**
     * 响应id
     */
    private String respId;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * 接口id
     */
    private String urlId;

    /**
     * 接口url
     */
    private String url;

    /**
     * 耗时
     */
    private long cost;
}
