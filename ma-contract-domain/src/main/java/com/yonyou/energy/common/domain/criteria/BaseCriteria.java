package com.yonyou.energy.common.domain.criteria;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * 公共的参数载体类
 * 这里面的参数应该是够用了,有特殊的参数可以再加,用这一个就行
 * @author mahonggeng
 * @create 2017-09-13 16:01
 **/
public class BaseCriteria extends PageCriteria implements Serializable {

    private Long id;
    private Long[] ids;
    private String idstr;
    private Long parentid;
    private Integer parentLevel;
    private Integer level;
    private Long modifier;
    private String status;
    private String billstatus;
    private String billstatuses;
    private String code;
    private String name;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(String billstatus) {
        this.billstatus = billstatus;
    }

    public String getBillstatuses() {
        return billstatuses;
    }

    public void setBillstatuses(String billstatuses) {
        this.billstatuses = billstatuses;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Integer getParentLevel() {
        return parentLevel;
    }

    public void setParentLevel(Integer parentLevel) {
        this.parentLevel = parentLevel;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    @Override
    public String toString() {
        return "BaseCriteria{" +
                "id=" + id +
                ", ids=" + Arrays.toString(ids) +
                ", parentid=" + parentid +
                ", level=" + level +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
