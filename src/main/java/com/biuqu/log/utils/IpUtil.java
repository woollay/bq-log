package com.biuqu.log.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP工具类
 * <br>
 *
 * @date: 2019/9/3 14:50
 * @author: BiuQu
 * @since: JDK 1.8
 */
@Slf4j
public final class IpUtil
{
    /**
     * 获取客户端IP
     *
     * @param request http请求
     * @return 客户端IP
     */
    public static String getReqIp(HttpServletRequest request)
    {
        String ipAddress;
        try
        {
            ipAddress = request.getHeader(HTTP_IP_HEADER_KEY);
            if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN_IP.equalsIgnoreCase(ipAddress))
            {
                ipAddress = request.getHeader(HTTP_PROXY_IP_HEADER_KEY);
            }
            if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN_IP.equalsIgnoreCase(ipAddress))
            {
                ipAddress = request.getHeader(HTTP_PROXY2_IP_HEADER_KEY);
            }
            if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN_IP.equalsIgnoreCase(ipAddress))
            {
                ipAddress = request.getRemoteAddr();
                if (LOCAL_IP_DEFAULT.equals(ipAddress))
                {
                    String localIp = getLocalHost();
                    if (!StringUtils.isEmpty(localIp))
                    {
                        ipAddress = localIp;
                    }
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > IPV4_LEN && ipAddress.indexOf(SPLIT) > 0)
            {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(SPLIT));
            }
        }
        catch (Exception e)
        {
            log.error("failed to get ip.", e);
            ipAddress = StringUtils.EMPTY;
        }
        return ipAddress;
    }

    /**
     * 获取本地IP
     *
     * @return 网卡IP
     */
    private static String getLocalHost()
    {
        // 根据网卡取本机配置的IP
        InetAddress inet = null;
        try
        {
            inet = InetAddress.getLocalHost();
        }
        catch (UnknownHostException e)
        {
            log.error("failed to get local ip.", e);
        }

        if (null == inet)
        {
            return null;
        }
        return inet.getHostAddress();
    }

    private IpUtil()
    {
    }

    /**
     * ','
     */
    private static final String SPLIT = ",";

    /**
     * 本地默认IP
     */
    private static final String LOCAL_IP_DEFAULT = "127.0.0.1";

    /**
     * x-forwarded-for
     */
    private static final String HTTP_IP_HEADER_KEY = "x-forwarded-for";

    /**
     * 代理IP的Key
     */
    private static final String HTTP_PROXY_IP_HEADER_KEY = "Proxy-Client-IP";

    /**
     * Weblogic代理IP的key
     */
    private static final String HTTP_PROXY2_IP_HEADER_KEY = "WL-Proxy-Client-IP";

    /**
     * 未知IP
     */
    private static final String UNKNOWN_IP = "unknown";

    /**
     * ipv4长度
     */
    private static final int IPV4_LEN = 15;
}
