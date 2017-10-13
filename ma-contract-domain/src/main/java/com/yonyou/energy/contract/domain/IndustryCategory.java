package com.yonyou.energy.contract.domain;

import java.io.Serializable;

/**
 * Created by tanghe on 2017/10/12.
 */
public class IndustryCategory implements Serializable {

    private Long id;

    private String code;

    private String name;

    private Integer status;

    private String reason;

    private Long creator;

    private String creationtime;

    private Long modifier;

    private String modifytime;

    private Integer dr;

    private String ts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public String getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndustryCategory that = (IndustryCategory) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getCode() != null ? !getCode().equals(that.getCode()) : that.getCode() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null) return false;
        if (getReason() != null ? !getReason().equals(that.getReason()) : that.getReason() != null) return false;
        if (getCreator() != null ? !getCreator().equals(that.getCreator()) : that.getCreator() != null) return false;
        if (getCreationtime() != null ? !getCreationtime().equals(that.getCreationtime()) : that.getCreationtime() != null)
            return false;
        if (getModifier() != null ? !getModifier().equals(that.getModifier()) : that.getModifier() != null)
            return false;
        if (getModifytime() != null ? !getModifytime().equals(that.getModifytime()) : that.getModifytime() != null)
            return false;
        if (getDr() != null ? !getDr().equals(that.getDr()) : that.getDr() != null) return false;
        return getTs() != null ? getTs().equals(that.getTs()) : that.getTs() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getReason() != null ? getReason().hashCode() : 0);
        result = 31 * result + (getCreator() != null ? getCreator().hashCode() : 0);
        result = 31 * result + (getCreationtime() != null ? getCreationtime().hashCode() : 0);
        result = 31 * result + (getModifier() != null ? getModifier().hashCode() : 0);
        result = 31 * result + (getModifytime() != null ? getModifytime().hashCode() : 0);
        result = 31 * result + (getDr() != null ? getDr().hashCode() : 0);
        result = 31 * result + (getTs() != null ? getTs().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IndustryCategory{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", reason='" + reason + '\'' +
                ", creator=" + creator +
                ", creationtime='" + creationtime + '\'' +
                ", modifier=" + modifier +
                ", modifytime='" + modifytime + '\'' +
                ", dr=" + dr +
                ", ts='" + ts + '\'' +
                '}';
    }
}
