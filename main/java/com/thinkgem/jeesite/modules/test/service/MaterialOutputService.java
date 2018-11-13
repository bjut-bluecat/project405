/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.test.entity.MaterialOutput;
import com.thinkgem.jeesite.modules.test.dao.MaterialOutputDao;

/**
 * 原材料输出Service
 * @author Robin
 * @version 2018-11-12
 */
@Service
@Transactional(readOnly = true)
public class MaterialOutputService extends CrudService<MaterialOutputDao, MaterialOutput> {

	public MaterialOutput get(String id) {
		return super.get(id);
	}
	
	public List<MaterialOutput> findList(MaterialOutput materialOutput) {
		return super.findList(materialOutput);
	}
	
	public Page<MaterialOutput> findPage(Page<MaterialOutput> page, MaterialOutput materialOutput) {
		return super.findPage(page, materialOutput);
	}
	
	@Transactional(readOnly = false)
	public void save(MaterialOutput materialOutput) {
		super.save(materialOutput);
	}
	
	@Transactional(readOnly = false)
	public void delete(MaterialOutput materialOutput) {
		super.delete(materialOutput);
	}
	
}