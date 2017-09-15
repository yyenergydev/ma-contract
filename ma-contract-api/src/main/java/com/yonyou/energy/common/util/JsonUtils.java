package com.yonyou.energy.common.util;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Collection;
import java.util.List;

public class JsonUtils
{
  private static JsonBinder jsonBinder = JsonBinder.buildNonNullBinder();

  public static <T> T fromJson(String jsonString, Class<T> clazz)
  {
    return jsonBinder.fromJson(jsonString, clazz);
  }

  public static <T> List<T> fromJsonArray(String jsonArray, Class<T> clazz)
  {
    return jsonBinder.fromJsonArray(jsonArray, clazz);
  }

  public static  Collection  fromJsonArrayBy(String jsonArray, Class recordClazz, Class collectionClazz)
  {
    return jsonBinder.fromJsonArrayBy(jsonArray, recordClazz, collectionClazz);
  }

  public static String toJson(Object object)
  {
    return jsonBinder.toJson(object);
  }

  public static void setDateFormat(String pattern)
  {
    jsonBinder.setDateFormat(pattern);
  }
  public static String returnWhenError(String errMsg,Object data){
    return  returnResult(errMsg,data,0);
  }

  /**
   *
   * @param errMsg 返回的消息日志
   * @param data
   * @return
     */
  public static String returnWhenSuccess(String errMsg,Object data){
    return  returnResult(errMsg,data,1);
  }

  /**
   *
   * 实体如果字段值为空,也要有字段,值为null
   *
   * com.alibaba.fastjson.JSON
   public static String toJSONString(Object object, SerializerFeature... features) {
   return toJSONString(object, DEFAULT_GENERATE_FEATURE, features);
   }

   com.alibaba.fastjson.serializer.SerializerFeature 这个是配置枚举
   其中    WriteMapNullValue --> 空字段显示为 null
   WriteEnumUsingToString --> 空字段显示为 ""

   例如
   JSON.toJSONString(bean, SerializerFeature.WriteMapNullValue); --> {"age":null,"field":null,"name":"bean"}

   *
   * @param errMsg 返回的消息日志
   * @param data
   * @return
   */
  public static String returnResult(String errMsg,Object data,int status){
    JSONObject jsonObject= new JSONObject();
//    JSONObject result= new JSONObject();
//    result.put("result",toJson(data));

    jsonObject.put("status",status);
    jsonObject.put("msg",errMsg);
    jsonObject.put("data",JSONObject.toJSONString(data, SerializerFeature.WriteMapNullValue));
    return jsonObject.toString();
  }
}