/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.test.entity.WorkingInput;

/**
 * 加工输入DAO接口
 * @author Robin
 * @version 2018-11-12
 */
@MyBatisDao
public interface WorkingInputDao extends CrudDao<WorkingInput> {
	
}