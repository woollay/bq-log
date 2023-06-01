package com.biuqu.log.model;

/**
 * 日志类别
 * <br>
 *
 * @date: 2019/9/2 18:10
 * @author: BiuQu
 * @since: JDK 1.8
 */
public enum LevelType
{
    /**
     * 提示
     */
    HINT(1),

    /**
     * 警告
     */
    WARNING(2),

    /**
     * 一般
     */
    MINOR(3),

    /**
     * 严重
     */
    MAJOR(4),

    /**
     * 致命
     */
    CRITICAL(5);

    /**
     * 获取level对象
     *
     * @param value 日志级别值
     * @return 级别名称
     */
    public static LevelType get(int value)
    {
        for (LevelType levelType : values())
        {
            if (levelType.getValue() == value)
            {
                return levelType;
            }
        }
        return MINOR;
    }

    /**
     * 级别值
     */
    private int value;

    LevelType(int value)
    {
        this.value = value;
    }

    /**
     * 获取日志对象
     *
     * @return 日志级别
     */
    public int getValue()
    {
        return this.value;
    }
}
