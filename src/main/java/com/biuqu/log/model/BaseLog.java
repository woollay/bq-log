package com.biuqu.log.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 日志对象(审计日志和接口日志的抽象类)
 * <br>
 *
 * @date: 2019/9/2 16:28
 * @author: BiuQu
 * @since: JDK 1.8
 */
@Data
public abstract class BaseLog
{
    /**
     * 简单填充
     */
    public void simpleFill()
    {
        this.setCurTime(System.currentTimeMillis());
        this.setId(UUID.randomUUID().toString());
        this.setClientIp(StringUtils.EMPTY);
        this.setUserId(StringUtils.EMPTY);
    }

    /**
     * format:time{}/{}|ip|operator
     *
     * @return 返回日志对象
     */
    @Override
    public String toString()
    {
        List<Object> lists = new ArrayList<>();
        lists.add(getDate(this.curTime));
        lists.add(this.curTime);
        lists.add(StringUtils.defaultString(this.clientIp));
        lists.add(StringUtils.defaultString(this.userId));

        return StringUtils.join(lists, LINK);
    }

    /**
     * 获取对应时间格式'yyyy-MM-dd HH:mm:ss'的时间
     *
     * @param currentMills 毫秒数
     * @return 对应时间格式'yyyy-MM-dd HH:mm:ss'的时间
     */
    protected static String getDate(long currentMills)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        return sdf.format(new Date(currentMills));
    }

    /**
     * 日志唯一标识
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 客户端IP
     */
    private String clientIp;

    /**
     * 操作时间(UTC毫秒数)
     */
    private long curTime;

    /**
     * 标准的时间模板
     */
    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日志分隔符
     */
    protected static final String LINK = "|";
}
