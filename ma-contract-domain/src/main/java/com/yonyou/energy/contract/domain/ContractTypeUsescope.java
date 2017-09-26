package com.yonyou.energy.contract.domain;

import java.io.Serializable;

/**
 * 合同类型使用范围实体类
 * @author mahonggeng
 * @create 2017-09-13 16:01
 **/
public class ContractTypeUsescope implements Serializable {
    private Long id;

    private Long contracttypeid;

    private Long orgid;

    private String type;

    private Integer dr;

    private String ts;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContracttypeid() {
        return contracttypeid;
    }

    public void setContracttypeid(Long contracttypeid) {
        this.contracttypeid = contracttypeid;
    }

    public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        ContractTypeUsescope other = (ContractTypeUsescope) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getContracttypeid() == null ? other.getContracttypeid() == null : this.getContracttypeid().equals(other.getContracttypeid()))
            && (this.getOrgid() == null ? other.getOrgid() == null : this.getOrgid().equals(other.getOrgid()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getDr() == null ? other.getDr() == null : this.getDr().equals(other.getDr()))
            && (this.getTs() == null ? other.getTs() == null : this.getTs().equals(other.getTs()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getContracttypeid() == null) ? 0 : getContracttypeid().hashCode());
        result = prime * result + ((getOrgid() == null) ? 0 : getOrgid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getDr() == null) ? 0 : getDr().hashCode());
        result = prime * result + ((getTs() == null) ? 0 : getTs().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", contracttypeid=").append(contracttypeid);
        sb.append(", orgid=").append(orgid);
        sb.append(", type=").append(type);
        sb.append(", dr=").append(dr);
        sb.append(", ts=").append(ts);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}