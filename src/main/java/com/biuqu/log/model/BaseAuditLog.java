package com.biuqu.log.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 审计日志抽象类
 *
 * @author BiuQu
 * @date 2023/2/4 12:18
 */
@Data
public abstract class BaseAuditLog extends BaseLog
{
    /**
     * 设置成功结果
     */
    public final void ok()
    {
        this.setResult(SUCCESS);
    }

    /**
     * 设置失败结果
     */
    public final void fail()
    {
        this.setResult(FAILURE);
    }

    /**
     * 简单填充
     */
    @Override
    public void simpleFill()
    {
        super.simpleFill();
        this.setDetail(StringUtils.EMPTY);
        this.setResource(StringUtils.EMPTY);
        this.setResult(FAILURE);
    }

    /**
     * operation:|time{}/{}|ip|operator|module|resource|detail|result|type|
     * system:|time{}/{}|ip|operator|module|resource|detail|result|level|
     * security:|time{}/{}|ip|operator|module|resource|detail|result|type|level|
     *
     * @return 返回日志对象
     */
    @Override
    public String toString()
    {
        List<Object> lists = new ArrayList<>();
        lists.add(super.toString());
        lists.add(StringUtils.defaultString(this.module));
        lists.add(StringUtils.defaultString(this.resource));
        lists.add(StringUtils.defaultString(this.detail));
        lists.add(this.result);

        return StringUtils.join(lists, LINK);
    }

    /**
     * 业务模块(业务服务)
     */
    private String module;

    /**
     * 操作资源(如：用户/角色/权限)
     */
    private String resource;

    /**
     * 操作详情(如：删除用户xxx的权限ppp成功)
     */
    private String detail;

    /**
     * 操作结果
     */
    private int result;

    /**
     * 操作成功
     */
    private static final int SUCCESS = 1;

    /**
     * 操作失败
     */
    private static final int FAILURE = -1;

}