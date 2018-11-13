/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.test.entity.MaterialInput;
import com.thinkgem.jeesite.modules.test.dao.MaterialInputDao;

/**
 * 原材料输入Service
 * @author 蓝猫
 * @version 2018-11-12
 */
@Service
@Transactional(readOnly = true)
public class MaterialInputService extends CrudService<MaterialInputDao, MaterialInput> {

	public MaterialInput get(String id) {
		return super.get(id);
	}
	
	public List<MaterialInput> findList(MaterialInput materialInput) {
		return super.findList(materialInput);
	}
	
	public Page<MaterialInput> findPage(Page<MaterialInput> page, MaterialInput materialInput) {
		return super.findPage(page, materialInput);
	}
	
	@Transactional(readOnly = false)
	public void save(MaterialInput materialInput) {
		super.save(materialInput);
	}
	
	@Transactional(readOnly = false)
	public void delete(MaterialInput materialInput) {
		super.delete(materialInput);
	}
	
}