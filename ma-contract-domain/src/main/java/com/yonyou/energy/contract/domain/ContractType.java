package com.yonyou.energy.contract.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class ContractType implements Serializable {
    private Long id;

    private String code;

    private String name;

    private Integer level;

    private Integer isGlobal;

    private Long parentId;

    private String parentName;

    private Long templateId;

    private String templateName;

    private String useScopeIds;

    private String useScopeNames;

    private Long creator;

    private String creationtime;

    private Long modifier;

    private String modifytime;

    private String pkGroup;

    private String pkOrg;

    private String remark;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIsGlobal() {
        return isGlobal;
    }

    public void setIsGlobal(Integer isGlobal) {
        this.isGlobal = isGlobal;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
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
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ContractType other = (ContractType) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getIsGlobal() == null ? other.getIsGlobal() == null : this.getIsGlobal().equals(other.getIsGlobal()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getTemplateId() == null ? other.getTemplateId() == null : this.getTemplateId().equals(other.getTemplateId()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreationtime() == null ? other.getCreationtime() == null : this.getCreationtime().equals(other.getCreationtime()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModifytime() == null ? other.getModifytime() == null : this.getModifytime().equals(other.getModifytime()))
            && (this.getPkGroup() == null ? other.getPkGroup() == null : this.getPkGroup().equals(other.getPkGroup()))
            && (this.getPkOrg() == null ? other.getPkOrg() == null : this.getPkOrg().equals(other.getPkOrg()))
            && (this.getDr() == null ? other.getDr() == null : this.getDr().equals(other.getDr()))
            && (this.getTs() == null ? other.getTs() == null : this.getTs().equals(other.getTs()))
            && (this.getVdef1() == null ? other.getVdef1() == null : this.getVdef1().equals(other.getVdef1()))
            && (this.getVdef2() == null ? other.getVdef2() == null : this.getVdef2().equals(other.getVdef2()))
            && (this.getVdef3() == null ? other.getVdef3() == null : this.getVdef3().equals(other.getVdef3()))
            && (this.getVdef4() == null ? other.getVdef4() == null : this.getVdef4().equals(other.getVdef4()))
            && (this.getVdef5() == null ? other.getVdef5() == null : this.getVdef5().equals(other.getVdef5()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getIsGlobal() == null) ? 0 : getIsGlobal().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getTemplateId() == null) ? 0 : getTemplateId().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreationtime() == null) ? 0 : getCreationtime().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModifytime() == null) ? 0 : getModifytime().hashCode());
        result = prime * result + ((getPkGroup() == null) ? 0 : getPkGroup().hashCode());
        result = prime * result + ((getPkOrg() == null) ? 0 : getPkOrg().hashCode());
        result = prime * result + ((getDr() == null) ? 0 : getDr().hashCode());
        result = prime * result + ((getTs() == null) ? 0 : getTs().hashCode());
        result = prime * result + ((getVdef1() == null) ? 0 : getVdef1().hashCode());
        result = prime * result + ((getVdef2() == null) ? 0 : getVdef2().hashCode());
        result = prime * result + ((getVdef3() == null) ? 0 : getVdef3().hashCode());
        result = prime * result + ((getVdef4() == null) ? 0 : getVdef4().hashCode());
        result = prime * result + ((getVdef5() == null) ? 0 : getVdef5().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", level=").append(level);
        sb.append(", isGlobal=").append(isGlobal);
        sb.append(", parentId=").append(parentId);
        sb.append(", templateId=").append(templateId);
        sb.append(", creator=").append(creator);
        sb.append(", creationtime=").append(creationtime);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifytime=").append(modifytime);
        sb.append(", pkGroup=").append(pkGroup);
        sb.append(", pkOrg=").append(pkOrg);
        sb.append(", dr=").append(dr);
        sb.append(", ts=").append(ts);
        sb.append(", vdef1=").append(vdef1);
        sb.append(", vdef2=").append(vdef2);
        sb.append(", vdef3=").append(vdef3);
        sb.append(", vdef4=").append(vdef4);
        sb.append(", vdef5=").append(vdef5);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}