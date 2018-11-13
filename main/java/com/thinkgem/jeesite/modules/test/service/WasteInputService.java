/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.test.entity.WasteInput;
import com.thinkgem.jeesite.modules.test.dao.WasteInputDao;

/**
 * 废弃输入Service
 * @author Robin
 * @version 2018-11-12
 */
@Service
@Transactional(readOnly = true)
public class WasteInputService extends CrudService<WasteInputDao, WasteInput> {

	public WasteInput get(String id) {
		return super.get(id);
	}
	
	public List<WasteInput> findList(WasteInput wasteInput) {
		return super.findList(wasteInput);
	}
	
	public Page<WasteInput> findPage(Page<WasteInput> page, WasteInput wasteInput) {
		return super.findPage(page, wasteInput);
	}
	
	@Transactional(readOnly = false)
	public void save(WasteInput wasteInput) {
		super.save(wasteInput);
	}
	
	@Transactional(readOnly = false)
	public void delete(WasteInput wasteInput) {
		super.delete(wasteInput);
	}
	
}