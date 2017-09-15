package com.yonyou.energy.common.domain.criteria;

import java.io.Serializable;
import java.util.Date;

public class BaseCriteria extends PageCriteria implements Serializable {

    private Long id;
    private Long[] ids;

    private Long parentid;
    /** 修改人id */
    private Long modifier;
    /**页面状态切换状态**/
    private String status;
    /**单据状态**/
    private String billstatus;
    /**
     * 多个单据状态
     * */
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
}
