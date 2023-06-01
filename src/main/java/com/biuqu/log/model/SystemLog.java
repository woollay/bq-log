package com.biuqu.log.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统日志(审计日志之一)
 * <p>
 * 系统处理任务、遭受攻击相关的操作日志对象
 * <p>
 *
 * @date: 2019/9/3 11:07
 * @author: BiuQu
 * @since: JDK 1.8
 */
@Data
public class SystemLog extends BaseAuditLog
{
    @Override
    public void simpleFill()
    {
        super.simpleFill();
        this.setLevel(LevelType.MINOR.getValue());
    }

    @Override
    public String toString()
    {
        List<Object> lists = new ArrayList<>();
        lists.add(super.toString());
        lists.add(this.level);

        return StringUtils.join(lists, LINK);
    }

    /**
     * 日志级别，参见{@link LevelType}
     */
    private int level;
}