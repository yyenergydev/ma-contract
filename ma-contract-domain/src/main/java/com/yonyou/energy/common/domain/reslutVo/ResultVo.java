package com.yonyou.energy.common.domain.reslutVo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caolin on 2016/9/2.
 */
public class ResultVo {

    //0失败1成功
    private int status;

    //列表和单实体均使用该数据对象
    private Map<String,Object> data = new HashMap<String, Object>();


    //成功或失败的消息
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
    public void addData(String key, Object obj) {
        this.data.put(key,obj);
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultVo(int status) {
        this.status=status;
    }
    public ResultVo() {
    }
}
