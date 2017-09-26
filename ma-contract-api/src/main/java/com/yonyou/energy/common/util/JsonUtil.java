package com.yonyou.energy.common.util;

import com.yonyou.energy.contract.domain.ContractType;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Collection;
import java.util.logging.Logger;

/**
 * Json处理工具类
 * @author mahonggeng
 * @create 2017-09-13 16:18
 **/
public class JsonUtil {

    public static String objToString(Object obj){
        if(obj==null)
            return null;
        return JSONObject.fromObject(obj).toString();
    }

    public static String collectionToString(Collection collection){
        if(collection==null || collection.size()==0)
            return null;
        return JSONArray.fromObject(collection).toString();
    }

    public static <T>T jsonToObject(String json, Class<T> clasz){
        if(json==null || "".equals(json))
                return null;
        if(json.startsWith("{")) {
            JSONObject obj = JSONObject.fromObject(json);
            return (T)JSONObject.toBean(obj,clasz);
        } else {
            JSONArray obj = JSONArray.fromObject(json);
            return (T)JSONArray.toCollection(obj,clasz);
        }

    }

    public static JSONObject jsonToJSONObject(String json){
        if(json==null || "".equals(json))
            return null;
        return JSONObject.fromObject(json);
    }

    public static void main(String[] args){
        ContractType con = new ContractType();
        con.setName("23");
        con.setCode("jack");
        String json = objToString(con);
        Logger.getLogger(con.getClass().getName()).info(json);
        System.out.println(jsonToObject(json, ContractType.class));
    }
}
