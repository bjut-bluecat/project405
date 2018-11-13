/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.test.entity.UseOutput;
import com.thinkgem.jeesite.modules.test.dao.UseOutputDao;

/**
 * 使用输出Service
 * @author Robin
 * @version 2018-11-12
 */
@Service
@Transactional(readOnly = true)
public class UseOutputService extends CrudService<UseOutputDao, UseOutput> {

	public UseOutput get(String id) {
		return super.get(id);
	}
	
	public List<UseOutput> findList(UseOutput useOutput) {
		return super.findList(useOutput);
	}
	
	public Page<UseOutput> findPage(Page<UseOutput> page, UseOutput useOutput) {
		return super.findPage(page, useOutput);
	}
	
	@Transactional(readOnly = false)
	public void save(UseOutput useOutput) {
		super.save(useOutput);
	}
	
	@Transactional(readOnly = false)
	public void delete(UseOutput useOutput) {
		super.delete(useOutput);
	}
	
}