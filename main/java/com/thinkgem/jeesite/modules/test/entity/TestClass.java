/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 班级管理Entity
 * @author 蓝猫
 * @version 2018-09-18
 */
public class TestClass extends DataEntity<TestClass> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名字
	private String teacher;		// 班主任
	
	public TestClass() {
		super();
	}

	public TestClass(String id){
		super(id);
	}

	@Length(min=1, max=255, message="名字长度必须介于 1 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=255, message="班主任长度必须介于 1 和 255 之间")
	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
}