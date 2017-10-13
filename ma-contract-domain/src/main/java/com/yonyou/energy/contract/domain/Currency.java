package com.yonyou.energy.contract.domain;

import java.io.Serializable;

/**
 * Created by tanghe on 2017/10/12.
 */
public class Currency implements Serializable {

    private Long id;

    private String code;

    private String name;

    private String symbol;

    private String precision;

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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
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

        Currency currency = (Currency) o;

        if (getId() != null ? !getId().equals(currency.getId()) : currency.getId() != null) return false;
        if (getCode() != null ? !getCode().equals(currency.getCode()) : currency.getCode() != null) return false;
        if (getName() != null ? !getName().equals(currency.getName()) : currency.getName() != null) return false;
        if (getSymbol() != null ? !getSymbol().equals(currency.getSymbol()) : currency.getSymbol() != null)
            return false;
        if (getPrecision() != null ? !getPrecision().equals(currency.getPrecision()) : currency.getPrecision() != null)
            return false;
        if (getCreator() != null ? !getCreator().equals(currency.getCreator()) : currency.getCreator() != null)
            return false;
        if (getCreationtime() != null ? !getCreationtime().equals(currency.getCreationtime()) : currency.getCreationtime() != null)
            return false;
        if (getModifier() != null ? !getModifier().equals(currency.getModifier()) : currency.getModifier() != null)
            return false;
        if (getModifytime() != null ? !getModifytime().equals(currency.getModifytime()) : currency.getModifytime() != null)
            return false;
        if (getDr() != null ? !getDr().equals(currency.getDr()) : currency.getDr() != null) return false;
        return getTs() != null ? getTs().equals(currency.getTs()) : currency.getTs() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSymbol() != null ? getSymbol().hashCode() : 0);
        result = 31 * result + (getPrecision() != null ? getPrecision().hashCode() : 0);
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
        return "Currency{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", precision='" + precision + '\'' +
                ", creator=" + creator +
                ", creationtime='" + creationtime + '\'' +
                ", modifier=" + modifier +
                ", modifytime='" + modifytime + '\'' +
                ", dr=" + dr +
                ", ts='" + ts + '\'' +
                '}';
    }
}
