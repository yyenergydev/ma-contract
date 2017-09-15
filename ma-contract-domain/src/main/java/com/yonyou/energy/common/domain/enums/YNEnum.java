package com.yonyou.energy.common.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum YNEnum
{
    Y(Integer.valueOf(0), "启用"),
    N(Integer.valueOf(1), "禁用");

    private Integer code;
    private String name;
    private static final Map<Integer, YNEnum> map;

    private YNEnum(Integer code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public static YNEnum get(Integer code)
    {
        return (YNEnum)map.get(code);
    }

    public String toString()
    {
        return getCode() + ":" + getName();
    }

    static
    {
        map = new HashMap();

        for (YNEnum t : values())
            map.put(t.getCode(), t);
    }
}