package com.yonyou.energy.common.domain;


import java.util.Date;

import com.yonyou.energy.common.domain.criteria.Criteria;
import com.yonyou.energy.common.domain.enums.YNEnum;

public class BaseEntityBean extends Criteria {
    private static final long serialVersionUID = -7793739903799136331L;
    //private Integer sysVersion;
    private Date creationtime;
    private Date modifytime;
    private String creator;
    private String modifier;
    private Integer dr;
    private Date ts;
    private Long id;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Long getId(){ return this.id; }

    public void setId(Long id){ this.id = id; }

    public BaseEntityBean init() {
        this.creator = "";
        this.modifier = "";
        this.dr = YNEnum.Y.getCode();
        return this;
    }

}