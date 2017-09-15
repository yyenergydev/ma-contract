package com.yonyou.energy.common.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class PubBaseEntityBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -6027839739173044356L;
	private Date createTime;
	private Date modifiedtime;
	private String creator;
	private String modifier;
	private Integer dr;
	private Date ts;

	public static final String SORT_DIRECTION_ASC = "ASC";
	public static final String SORT_DIRECTION_DESC = "DESC";
	private LinkedHashMap<String, String> sortItemMap;
	private Map<String, Object> extFields;
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifiedtime() {
		return modifiedtime;
	}
	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
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
	public LinkedHashMap<String, String> getSortItemMap() {
		return sortItemMap;
	}
	public void setSortItemMap(LinkedHashMap<String, String> sortItemMap) {
		this.sortItemMap = sortItemMap;
	}
	public Map<String, Object> getExtFields() {
		return extFields;
	}
	public void setExtFields(Map<String, Object> extFields) {
		this.extFields = extFields;
	}
	 
}
