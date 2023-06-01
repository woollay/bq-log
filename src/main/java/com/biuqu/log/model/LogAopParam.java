package com.biuqu.log.model;

import lombok.Data;

/**
 * 日志切面参数对象
 *
 * @author BiuQu
 * @date 2023/2/3 19:03
 */
@Data
public class LogAopParam
{
    /**
     * 用户id
     */
    private String userId;

    /**
     * 客户端IP
     */
    private String clientIp;

    /**
     * 开始时间
     */
    private long curTime;

    /**
     * 请求id
     */
    private String repId;

    /**
     * 响应id
     */
    private String respId;

    /**
     * 接口id
     */
    private String urlId;

    /**
     * 接口url
     */
    private String url;
}
