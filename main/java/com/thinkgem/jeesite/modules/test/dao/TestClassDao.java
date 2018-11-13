/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.test.entity.TestClass;

/**
 * 班级管理DAO接口
 * @author 蓝猫
 * @version 2018-09-18
 */
@MyBatisDao
public interface TestClassDao extends CrudDao<TestClass> {
	
}