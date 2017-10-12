package com.yonyou.energy.contract.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 标准合同实体类
 * @author mahonggeng
 * @create 2017-09-27 14:38
 **/
//@XmlRootElement
public class BaseContract implements Serializable {
    private Long id;

    private String billnum;

    private String code;

    private String name;

    private Long contractTypeId;

    private String contractTypeName;

    private Integer isCommonText;

    private Long contractTextId;

    private String contractText;

    private Integer isAssetPlatform;

    private Integer isSystemContract;

    private Long industryTypeId;

    private String industryType;

    private Integer moneyflow;

    private Double contractmny;

    private Long currencyId;

    private String currencyName;

    private Long contractOwnId;

    private String contractOwn;

    private Long contractOtherId;

    private String contractOther;

    private Integer settlement;

    private Integer contractTerm;

    private Integer termUnit;

    private String signDate;

    private Integer paytype;

    private Long undertakerId;

    private String undertaker;

    private Long undertakedeptId;

    private String undertakedept;

    private Integer contractStatus;

    private Integer contractCount;

    private String changedate;

    private Integer isPlaceFile;

    private String remark;

    private String markdate;

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

    public String getBillnum() {
        return billnum;
    }

    public void setBillnum(String billnum) {
        this.billnum = billnum;
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

    public Long getContractTypeId() {
        return contractTypeId;
    }

    public void setContractTypeId(Long contractTypeId) {
        this.contractTypeId = contractTypeId;
    }

    public String getContractTypeName() {
        return contractTypeName;
    }

    public void setContractTypeName(String contractTypeName) {
        this.contractTypeName = contractTypeName;
    }

    public Integer getIsCommonText() {
        return isCommonText;
    }

    public Long getContractTextId() {
        return contractTextId;
    }

    public void setContractTextId(Long contractTextId) {
        this.contractTextId = contractTextId;
    }

    public void setIsCommonText(Integer isCommonText) {
        this.isCommonText = isCommonText;
    }

    public String getContractText() {
        return contractText;
    }

    public void setContractText(String contractText) {
        this.contractText = contractText;
    }

    public Integer getIsAssetPlatform() {
        return isAssetPlatform;
    }

    public void setIsAssetPlatform(Integer isAssetPlatform) {
        this.isAssetPlatform = isAssetPlatform;
    }

    public Integer getIsSystemContract() {
        return isSystemContract;
    }

    public void setIsSystemContract(Integer isSystemContract) {
        this.isSystemContract = isSystemContract;
    }

    public Long getIndustryTypeId() {
        return industryTypeId;
    }

    public void setIndustryTypeId(Long industryTypeId) {
        this.industryTypeId = industryTypeId;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public Integer getMoneyflow() {
        return moneyflow;
    }

    public void setMoneyflow(Integer moneyflow) {
        this.moneyflow = moneyflow;
    }

    public Double getContractmny() {
        return contractmny;
    }

    public void setContractmny(Double contractmny) {
        this.contractmny = contractmny;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Long getContractOwnId() {
        return contractOwnId;
    }

    public void setContractOwnId(Long contractOwnId) {
        this.contractOwnId = contractOwnId;
    }

    public String getContractOwn() {
        return contractOwn;
    }

    public void setContractOwn(String contractOwn) {
        this.contractOwn = contractOwn;
    }

    public Long getContractOtherId() {
        return contractOtherId;
    }

    public void setContractOtherId(Long contractOtherId) {
        this.contractOtherId = contractOtherId;
    }

    public String getContractOther() {
        return contractOther;
    }

    public void setContractOther(String contractOther) {
        this.contractOther = contractOther;
    }

    public Integer getSettlement() {
        return settlement;
    }

    public void setSettlement(Integer settlement) {
        this.settlement = settlement;
    }

    public Integer getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(Integer contractTerm) {
        this.contractTerm = contractTerm;
    }

    public Integer getTermUnit() {
        return termUnit;
    }

    public void setTermUnit(Integer termUnit) {
        this.termUnit = termUnit;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public Long getUndertakerId() {
        return undertakerId;
    }

    public void setUndertakerId(Long undertakerId) {
        this.undertakerId = undertakerId;
    }

    public String getUndertaker() {
        return undertaker;
    }

    public void setUndertaker(String undertaker) {
        this.undertaker = undertaker;
    }

    public Long getUndertakedeptId() {
        return undertakedeptId;
    }

    public void setUndertakedeptId(Long undertakedeptId) {
        this.undertakedeptId = undertakedeptId;
    }

    public String getUndertakedept() {
        return undertakedept;
    }

    public void setUndertakedept(String undertakedept) {
        this.undertakedept = undertakedept;
    }

    public Integer getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(Integer contractStatus) {
        this.contractStatus = contractStatus;
    }

    public Integer getContractCount() {
        return contractCount;
    }

    public void setContractCount(Integer contractCount) {
        this.contractCount = contractCount;
    }

    public String getChangedate() {
        return changedate;
    }

    public void setChangedate(String changedate) {
        this.changedate = changedate;
    }

    public Integer getIsPlaceFile() {
        return isPlaceFile;
    }

    public void setIsPlaceFile(Integer isPlaceFile) {
        this.isPlaceFile = isPlaceFile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMarkdate() {
        return markdate;
    }

    public void setMarkdate(String markdate) {
        this.markdate = markdate;
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
        BaseContract other = (BaseContract) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getBillnum() == null ? other.getBillnum() == null : this.getBillnum().equals(other.getBillnum()))
                && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getContractTypeId() == null ? other.getContractTypeId() == null : this.getContractTypeId().equals(other.getContractTypeId()))
                && (this.getContractTypeName() == null ? other.getContractTypeName() == null : this.getContractTypeName().equals(other.getContractTypeName()))
                && (this.getIsCommonText() == null ? other.getIsCommonText() == null : this.getIsCommonText().equals(other.getIsCommonText()))
                && (this.getContractText() == null ? other.getContractText() == null : this.getContractText().equals(other.getContractText()))
                && (this.getIsAssetPlatform() == null ? other.getIsAssetPlatform() == null : this.getIsAssetPlatform().equals(other.getIsAssetPlatform()))
                && (this.getIsSystemContract() == null ? other.getIsSystemContract() == null : this.getIsSystemContract().equals(other.getIsSystemContract()))
                && (this.getIndustryTypeId() == null ? other.getIndustryTypeId() == null : this.getIndustryTypeId().equals(other.getIndustryTypeId()))
                && (this.getIndustryType() == null ? other.getIndustryType() == null : this.getIndustryType().equals(other.getIndustryType()))
                && (this.getMoneyflow() == null ? other.getMoneyflow() == null : this.getMoneyflow().equals(other.getMoneyflow()))
                && (this.getContractmny() == null ? other.getContractmny() == null : this.getContractmny().equals(other.getContractmny()))
                && (this.getCurrencyId() == null ? other.getCurrencyId() == null : this.getCurrencyId().equals(other.getCurrencyId()))
                && (this.getCurrencyName() == null ? other.getCurrencyName() == null : this.getCurrencyName().equals(other.getCurrencyName()))
                && (this.getContractOwnId() == null ? other.getContractOwnId() == null : this.getContractOwnId().equals(other.getContractOwnId()))
                && (this.getContractOwn() == null ? other.getContractOwn() == null : this.getContractOwn().equals(other.getContractOwn()))
                && (this.getContractOtherId() == null ? other.getContractOtherId() == null : this.getContractOtherId().equals(other.getContractOtherId()))
                && (this.getContractOther() == null ? other.getContractOther() == null : this.getContractOther().equals(other.getContractOther()))
                && (this.getSettlement() == null ? other.getSettlement() == null : this.getSettlement().equals(other.getSettlement()))
                && (this.getContractTerm() == null ? other.getContractTerm() == null : this.getContractTerm().equals(other.getContractTerm()))
                && (this.getTermUnit() == null ? other.getTermUnit() == null : this.getTermUnit().equals(other.getTermUnit()))
                && (this.getSignDate() == null ? other.getSignDate() == null : this.getSignDate().equals(other.getSignDate()))
                && (this.getPaytype() == null ? other.getPaytype() == null : this.getPaytype().equals(other.getPaytype()))
                && (this.getUndertakerId() == null ? other.getUndertakerId() == null : this.getUndertakerId().equals(other.getUndertakerId()))
                && (this.getUndertaker() == null ? other.getUndertaker() == null : this.getUndertaker().equals(other.getUndertaker()))
                && (this.getUndertakedeptId() == null ? other.getUndertakedeptId() == null : this.getUndertakedeptId().equals(other.getUndertakedeptId()))
                && (this.getUndertakedept() == null ? other.getUndertakedept() == null : this.getUndertakedept().equals(other.getUndertakedept()))
                && (this.getContractStatus() == null ? other.getContractStatus() == null : this.getContractStatus().equals(other.getContractStatus()))
                && (this.getContractCount() == null ? other.getContractCount() == null : this.getContractCount().equals(other.getContractCount()))
                && (this.getChangedate() == null ? other.getChangedate() == null : this.getChangedate().equals(other.getChangedate()))
                && (this.getIsPlaceFile() == null ? other.getIsPlaceFile() == null : this.getIsPlaceFile().equals(other.getIsPlaceFile()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getMarkdate() == null ? other.getMarkdate() == null : this.getMarkdate().equals(other.getMarkdate()))
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
        result = prime * result + ((getBillnum() == null) ? 0 : getBillnum().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getContractTypeId() == null) ? 0 : getContractTypeId().hashCode());
        result = prime * result + ((getContractTypeName() == null) ? 0 : getContractTypeName().hashCode());
        result = prime * result + ((getIsCommonText() == null) ? 0 : getIsCommonText().hashCode());
        result = prime * result + ((getContractText() == null) ? 0 : getContractText().hashCode());
        result = prime * result + ((getIsAssetPlatform() == null) ? 0 : getIsAssetPlatform().hashCode());
        result = prime * result + ((getIsSystemContract() == null) ? 0 : getIsSystemContract().hashCode());
        result = prime * result + ((getIndustryTypeId() == null) ? 0 : getIndustryTypeId().hashCode());
        result = prime * result + ((getIndustryType() == null) ? 0 : getIndustryType().hashCode());
        result = prime * result + ((getMoneyflow() == null) ? 0 : getMoneyflow().hashCode());
        result = prime * result + ((getContractmny() == null) ? 0 : getContractmny().hashCode());
        result = prime * result + ((getCurrencyId() == null) ? 0 : getCurrencyId().hashCode());
        result = prime * result + ((getCurrencyName() == null) ? 0 : getCurrencyName().hashCode());
        result = prime * result + ((getContractOwnId() == null) ? 0 : getContractOwnId().hashCode());
        result = prime * result + ((getContractOwn() == null) ? 0 : getContractOwn().hashCode());
        result = prime * result + ((getContractOtherId() == null) ? 0 : getContractOtherId().hashCode());
        result = prime * result + ((getContractOther() == null) ? 0 : getContractOther().hashCode());
        result = prime * result + ((getSettlement() == null) ? 0 : getSettlement().hashCode());
        result = prime * result + ((getContractTerm() == null) ? 0 : getContractTerm().hashCode());
        result = prime * result + ((getTermUnit() == null) ? 0 : getTermUnit().hashCode());
        result = prime * result + ((getSignDate() == null) ? 0 : getSignDate().hashCode());
        result = prime * result + ((getPaytype() == null) ? 0 : getPaytype().hashCode());
        result = prime * result + ((getUndertakerId() == null) ? 0 : getUndertakerId().hashCode());
        result = prime * result + ((getUndertaker() == null) ? 0 : getUndertaker().hashCode());
        result = prime * result + ((getUndertakedeptId() == null) ? 0 : getUndertakedeptId().hashCode());
        result = prime * result + ((getUndertakedept() == null) ? 0 : getUndertakedept().hashCode());
        result = prime * result + ((getContractStatus() == null) ? 0 : getContractStatus().hashCode());
        result = prime * result + ((getContractCount() == null) ? 0 : getContractCount().hashCode());
        result = prime * result + ((getChangedate() == null) ? 0 : getChangedate().hashCode());
        result = prime * result + ((getIsPlaceFile() == null) ? 0 : getIsPlaceFile().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getMarkdate() == null) ? 0 : getMarkdate().hashCode());
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
        sb.append(", billnum=").append(billnum);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", contractTypeId=").append(contractTypeId);
        sb.append(", contractTypeName=").append(contractTypeName);
        sb.append(", isCommonText=").append(isCommonText);
        sb.append(", contractText=").append(contractText);
        sb.append(", isAssetPlatform=").append(isAssetPlatform);
        sb.append(", isSystemContract=").append(isSystemContract);
        sb.append(", industryTypeId=").append(industryTypeId);
        sb.append(", industryType=").append(industryType);
        sb.append(", moneyflow=").append(moneyflow);
        sb.append(", contractmny=").append(contractmny);
        sb.append(", currencyId=").append(currencyId);
        sb.append(", currencyName=").append(currencyName);
        sb.append(", contractOwnId=").append(contractOwnId);
        sb.append(", contractOwn=").append(contractOwn);
        sb.append(", contractOtherId=").append(contractOtherId);
        sb.append(", contractOther=").append(contractOther);
        sb.append(", settlement=").append(settlement);
        sb.append(", contractTerm=").append(contractTerm);
        sb.append(", termUnit=").append(termUnit);
        sb.append(", signDate=").append(signDate);
        sb.append(", paytype=").append(paytype);
        sb.append(", undertakerId=").append(undertakerId);
        sb.append(", undertaker=").append(undertaker);
        sb.append(", undertakedeptId=").append(undertakedeptId);
        sb.append(", undertakedept=").append(undertakedept);
        sb.append(", contractStatus=").append(contractStatus);
        sb.append(", contractCount=").append(contractCount);
        sb.append(", changedate=").append(changedate);
        sb.append(", isPlaceFile=").append(isPlaceFile);
        sb.append(", remark=").append(remark);
        sb.append(", markdate=").append(markdate);
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
}