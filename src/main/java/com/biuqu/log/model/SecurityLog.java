package com.biuqu.log.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 安全日志(审计日志之一)
 * <p>
 * 用户、权限、角色、菜单相关的增删改查操作日志对象
 * <p>
 *
 * @date: 2019/9/3 11:07
 * @author: BiuQu
 * @since: JDK 1.8
 */
@Data
public class SecurityLog extends SystemLog
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