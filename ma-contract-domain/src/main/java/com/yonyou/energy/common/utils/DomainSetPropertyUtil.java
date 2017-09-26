package com.yonyou.energy.common.utils;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 属性复制工具类
 * @author mahonggeng
 * @create 2017-09-16 16:01
 **/
public class DomainSetPropertyUtil {

    public static <T> void setCommonProperty(T obj){
        try{
            setAttribute(obj,"dr",Integer.class,0);
            setAttribute(obj,"creationtime",String.class,new Date());
        }catch (Exception e){

        }
    }

    private static <T> void aa(Class<T> clasz, String name, T t, Object val){
        //Method method = clasz.getMethod("");

    }

    /**
     * Jack
     * 获取dto的某个属性值
     * @param obj : dto对象
     * @param name : 属性名称
     */
    public Object getAttribute(Object obj,String name) throws Exception{
        Class clasz = obj.getClass();
        Method method = clasz.getMethod(name);
        return method.invoke(obj);
    }

    /**
     * Jack
     * 为dto的某个属性赋值
     * @param obj : dto对象
     * @param name : 属性名称
     * @param type : 参数类型Class
     * @param val : 参数值
     */
    public static void setAttribute(Object obj,String name,Class type,Object val) throws Exception{
        Class clasz = obj.getClass();
        Method method = clasz.getMethod(name,type);
        method.invoke(obj,val);
    }
}
