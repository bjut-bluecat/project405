/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.test.entity.WasteOutput;
import com.thinkgem.jeesite.modules.test.dao.WasteOutputDao;

/**
 * 废弃输出Service
 * @author Robin
 * @version 2018-11-12
 */
@Service
@Transactional(readOnly = true)
public class WasteOutputService extends CrudService<WasteOutputDao, WasteOutput> {

	public WasteOutput get(String id) {
		return super.get(id);
	}
	
	public List<WasteOutput> findList(WasteOutput wasteOutput) {
		return super.findList(wasteOutput);
	}
	
	public Page<WasteOutput> findPage(Page<WasteOutput> page, WasteOutput wasteOutput) {
		return super.findPage(page, wasteOutput);
	}
	
	@Transactional(readOnly = false)
	public void save(WasteOutput wasteOutput) {
		super.save(wasteOutput);
	}
	
	@Transactional(readOnly = false)
	public void delete(WasteOutput wasteOutput) {
		super.delete(wasteOutput);
	}
	
}