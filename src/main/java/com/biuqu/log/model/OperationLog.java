package com.biuqu.log.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作日志对象(审计日志之一)
 * <p>
 * 用户执行业务操作相关的操作日志对象
 * <p>
 *
 * @date: 2019/9/3 11:06
 * @author: BiuQu
 * @since: JDK 1.8
 */
@Data
public class OperationLog extends BaseAuditLog
{
    @Override
    public String toString()
    {
        List<Object> lists = new ArrayList<>();
        lists.add(super.toString());
        lists.add(StringUtils.defaultString(this.opType));

        return StringUtils.join(lists, LINK);
    }

    /**
     * 操作类型（增删改查）
     */
    private String opType;
}