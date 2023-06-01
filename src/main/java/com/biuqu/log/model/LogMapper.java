package com.biuqu.log.model;

import com.biuqu.log.annotation.AuditLogAnn;
import com.biuqu.log.annotation.AuditLogModuleAnn;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * 日志适配器
 * <br>
 *
 * @date: 2019/9/3 11:25
 * @author: BiuQu
 * @since: JDK 1.8
 */
public enum LogMapper
{
    /**
     * 系统日志适配器
     */
    SysMapper
        {
            @Override
            public SystemLog getLog(AuditLogAnn target, AuditLogModuleAnn module, LogAopParam param)
            {
                SystemLog log = new SystemLog();
                log.simpleFill();

                log.setLevel(target.level().getValue());
                fillLog(log, target, module, param);
                return log;
            }
        },

    /**
     * 操作日志适配器
     */
    OpMapper
        {
            @Override
            public OperationLog getLog(AuditLogAnn target, AuditLogModuleAnn module, LogAopParam param)
            {
                OperationLog log = new OperationLog();
                log.simpleFill();

                log.setOpType(target.type());
                fillLog(log, target, module, param);
                return log;
            }
        },

    /**
     * 安全日志适配器
     */
    SecMapper
        {
            @Override
            public SecurityLog getLog(AuditLogAnn target, AuditLogModuleAnn module, LogAopParam param)
            {
                SecurityLog log = new SecurityLog();
                log.simpleFill();

                log.setLevel(target.level().getValue());
                log.setOpType(target.type());
                fillLog(log, target, module, param);
                return log;
            }
        };

    /**
     * 获取日志对象
     *
     * @param target 加注解的方法上的目标注解
     * @param module 加在类上的注解
     * @param param  方法时的切面获取的业务参数
     * @param <T>    日志类型
     * @return 日志对象
     */
    public abstract <T extends BaseAuditLog> T getLog(AuditLogAnn target, AuditLogModuleAnn module, LogAopParam param);

    /**
     * 填充日志
     *
     * @param log    日志对象
     * @param target 记日志的方法上的注解
     * @param m      业务模块
     * @param param  拦截方法时获取到的参数
     * @param <T>    日志类型
     */
    private static <T extends BaseAuditLog> void fillLog(T log, AuditLogAnn target, AuditLogModuleAnn m,
        LogAopParam param)
    {
        log.setClientIp(param.getClientIp());

        String moduleName = StringUtils.EMPTY;
        if (null != m)
        {
            moduleName = m.name();
        }
        log.setModule(moduleName);

        String userId = param.getUserId();
        if (StringUtils.isEmpty(userId))
        {
            userId = StringUtils.EMPTY;
        }
        log.setUserId(userId);

        //TODO detail需要进一步完善
        String detail = target.detail();
        String resource = target.resource();
        log.setDetail(detail);
        log.setResource(resource);

        log.setId(UUID.randomUUID().toString());
        log.setCurTime(param.getCurTime());
        log.ok();
    }
}
