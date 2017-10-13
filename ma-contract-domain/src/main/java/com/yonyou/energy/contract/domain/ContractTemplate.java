package com.yonyou.energy.contract.domain;

import java.io.Serializable;

public class ContractTemplate implements Serializable {

    private Long id;

    private String code;

    private String name;

    private String useScopeIds;

    private String useScopeNames;

    private Integer version;

    private Integer status;

    private Long creator;

    private String creationtime;

    private Long modifier;

    private String modifytime;

    private String pkGroup;

    private String pkOrg;

    private Integer dr;

    private String ts;

    private String vdef1;

    private String vdef2;

    private String vdef3;

    private String vdef4;

    private String vdef5;

    private static final long serialVersionUID = 1L;

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

    public String getUseScopeIds() {
        return useScopeIds;
    }

    public void setUseScopeIds(String useScopeIds) {
        this.useScopeIds = useScopeIds;
    }

    public String getUseScopeNames() {
        return useScopeNames;
    }

    public void setUseScopeNames(String useScopeNames) {
        this.useScopeNames = useScopeNames;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getPkGroup() {
        return pkGroup;
    }

    public void setPkGroup(String pkGroup) {
        this.pkGroup = pkGroup;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
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

    public String getVdef1() {
        return vdef1;
    }

    public void setVdef1(String vdef1) {
        this.vdef1 = vdef1;
    }

    public String getVdef2() {
        return vdef2;
    }

    public void setVdef2(String vdef2) {
        this.vdef2 = vdef2;
    }

    public String getVdef3() {
        return vdef3;
    }

    public void setVdef3(String vdef3) {
        this.vdef3 = vdef3;
    }

    public String getVdef4() {
        return vdef4;
    }

    public void setVdef4(String vdef4) {
        this.vdef4 = vdef4;
    }

    public String getVdef5() {
        return vdef5;
    }

    public void setVdef5(String vdef5) {
        this.vdef5 = vdef5;
    }

    @Override
    public String toString() {
        return "ContractTemplate{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", useScopeIds='" + useScopeIds + '\'' +
                ", useScopeNames='" + useScopeNames + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", creator=" + creator +
                ", creationtime='" + creationtime + '\'' +
                ", modifier=" + modifier +
                ", modifytime='" + modifytime + '\'' +
                ", pkGroup='" + pkGroup + '\'' +
                ", pkOrg='" + pkOrg + '\'' +
                ", dr=" + dr +
                ", ts='" + ts + '\'' +
                ", vdef1='" + vdef1 + '\'' +
                ", vdef2='" + vdef2 + '\'' +
                ", vdef3='" + vdef3 + '\'' +
                ", vdef4='" + vdef4 + '\'' +
                ", vdef5='" + vdef5 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractTemplate that = (ContractTemplate) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getCode() != null ? !getCode().equals(that.getCode()) : that.getCode() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getUseScopeIds() != null ? !getUseScopeIds().equals(that.getUseScopeIds()) : that.getUseScopeIds() != null)
            return false;
        if (getUseScopeNames() != null ? !getUseScopeNames().equals(that.getUseScopeNames()) : that.getUseScopeNames() != null)
            return false;
        if (getVersion() != null ? !getVersion().equals(that.getVersion()) : that.getVersion() != null) return false;
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null) return false;
        if (getCreator() != null ? !getCreator().equals(that.getCreator()) : that.getCreator() != null) return false;
        if (getCreationtime() != null ? !getCreationtime().equals(that.getCreationtime()) : that.getCreationtime() != null)
            return false;
        if (getModifier() != null ? !getModifier().equals(that.getModifier()) : that.getModifier() != null)
            return false;
        if (getModifytime() != null ? !getModifytime().equals(that.getModifytime()) : that.getModifytime() != null)
            return false;
        if (getPkGroup() != null ? !getPkGroup().equals(that.getPkGroup()) : that.getPkGroup() != null) return false;
        if (getPkOrg() != null ? !getPkOrg().equals(that.getPkOrg()) : that.getPkOrg() != null) return false;
        if (getDr() != null ? !getDr().equals(that.getDr()) : that.getDr() != null) return false;
        if (getTs() != null ? !getTs().equals(that.getTs()) : that.getTs() != null) return false;
        if (getVdef1() != null ? !getVdef1().equals(that.getVdef1()) : that.getVdef1() != null) return false;
        if (getVdef2() != null ? !getVdef2().equals(that.getVdef2()) : that.getVdef2() != null) return false;
        if (getVdef3() != null ? !getVdef3().equals(that.getVdef3()) : that.getVdef3() != null) return false;
        if (getVdef4() != null ? !getVdef4().equals(that.getVdef4()) : that.getVdef4() != null) return false;
        return getVdef5() != null ? getVdef5().equals(that.getVdef5()) : that.getVdef5() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getUseScopeIds() != null ? getUseScopeIds().hashCode() : 0);
        result = 31 * result + (getUseScopeNames() != null ? getUseScopeNames().hashCode() : 0);
        result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getCreator() != null ? getCreator().hashCode() : 0);
        result = 31 * result + (getCreationtime() != null ? getCreationtime().hashCode() : 0);
        result = 31 * result + (getModifier() != null ? getModifier().hashCode() : 0);
        result = 31 * result + (getModifytime() != null ? getModifytime().hashCode() : 0);
        result = 31 * result + (getPkGroup() != null ? getPkGroup().hashCode() : 0);
        result = 31 * result + (getPkOrg() != null ? getPkOrg().hashCode() : 0);
        result = 31 * result + (getDr() != null ? getDr().hashCode() : 0);
        result = 31 * result + (getTs() != null ? getTs().hashCode() : 0);
        result = 31 * result + (getVdef1() != null ? getVdef1().hashCode() : 0);
        result = 31 * result + (getVdef2() != null ? getVdef2().hashCode() : 0);
        result = 31 * result + (getVdef3() != null ? getVdef3().hashCode() : 0);
        result = 31 * result + (getVdef4() != null ? getVdef4().hashCode() : 0);
        result = 31 * result + (getVdef5() != null ? getVdef5().hashCode() : 0);
        return result;
    }
}
