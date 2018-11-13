/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.test.entity.UseInput;
import com.thinkgem.jeesite.modules.test.dao.UseInputDao;

/**
 * 使用输入Service
 * @author Robin
 * @version 2018-11-12
 */
@Service
@Transactional(readOnly = true)
public class UseInputService extends CrudService<UseInputDao, UseInput> {

	public UseInput get(String id) {
		return super.get(id);
	}
	
	public List<UseInput> findList(UseInput useInput) {
		return super.findList(useInput);
	}
	
	public Page<UseInput> findPage(Page<UseInput> page, UseInput useInput) {
		return super.findPage(page, useInput);
	}
	
	@Transactional(readOnly = false)
	public void save(UseInput useInput) {
		super.save(useInput);
	}
	
	@Transactional(readOnly = false)
	public void delete(UseInput useInput) {
		super.delete(useInput);
	}
	
}