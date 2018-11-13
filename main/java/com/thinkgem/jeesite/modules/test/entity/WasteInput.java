/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 废弃输入Entity
 * @author Robin
 * @version 2018-11-12
 */
public class WasteInput extends DataEntity<WasteInput> {
	
	private static final long serialVersionUID = 1L;
	private String type;		// type
	private Double input;		// input
	private String unit;		// unit
	private String remark;		// remark
	
	public WasteInput() {
		super();
	}

	public WasteInput(String id){
		super(id);
	}

	@Length(min=1, max=64, message="type长度必须介于 1 和 64 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Double getInput() {
		return input;
	}

	public void setInput(Double input) {
		this.input = input;
	}
	
	@Length(min=0, max=64, message="unit长度必须介于 0 和 64 之间")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Length(min=0, max=255, message="remark长度必须介于 0 和 255 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}