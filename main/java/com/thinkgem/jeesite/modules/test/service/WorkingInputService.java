/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.test.entity.WorkingInput;
import com.thinkgem.jeesite.modules.test.dao.WorkingInputDao;

/**
 * 加工输入Service
 * @author Robin
 * @version 2018-11-12
 */
@Service
@Transactional(readOnly = true)
public class WorkingInputService extends CrudService<WorkingInputDao, WorkingInput> {

	public WorkingInput get(String id) {
		return super.get(id);
	}
	
	public List<WorkingInput> findList(WorkingInput workingInput) {
		return super.findList(workingInput);
	}
	
	public Page<WorkingInput> findPage(Page<WorkingInput> page, WorkingInput workingInput) {
		return super.findPage(page, workingInput);
	}
	
	@Transactional(readOnly = false)
	public void save(WorkingInput workingInput) {
		super.save(workingInput);
	}
	
	@Transactional(readOnly = false)
	public void delete(WorkingInput workingInput) {
		super.delete(workingInput);
	}
	
}