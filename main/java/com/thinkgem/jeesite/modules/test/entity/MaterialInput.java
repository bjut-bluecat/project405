/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 原材料输入Entity
 * @author Robin
 * @version 2018-11-12
 */
public class MaterialInput extends DataEntity<MaterialInput> {
	
	private static final long serialVersionUID = 1L;
	private String type;		// type
	private String input;		// input
	private String unit;		// unit
	private String remark;		// remark
	
	public MaterialInput() {
		super();
	}

	public MaterialInput(String id){
		super(id);
	}

	@Length(min=1, max=64, message="type长度必须介于 1 和 64 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
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