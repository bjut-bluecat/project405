/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.test.entity.MaterialInput;

/**
 * 原材料输入DAO接口
 * @author 蓝猫
 * @version 2018-11-12
 */
@MyBatisDao
public interface MaterialInputDao extends CrudDao<MaterialInput> {
	
}