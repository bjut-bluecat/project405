/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.test.entity.WorkingOutput;
import com.thinkgem.jeesite.modules.test.dao.WorkingOutputDao;

/**
 * 加工输出Service
 * @author Robin
 * @version 2018-11-12
 */
@Service
@Transactional(readOnly = true)
public class WorkingOutputService extends CrudService<WorkingOutputDao, WorkingOutput> {

	public WorkingOutput get(String id) {
		return super.get(id);
	}
	
	public List<WorkingOutput> findList(WorkingOutput workingOutput) {
		return super.findList(workingOutput);
	}
	
	public Page<WorkingOutput> findPage(Page<WorkingOutput> page, WorkingOutput workingOutput) {
		return super.findPage(page, workingOutput);
	}
	
	@Transactional(readOnly = false)
	public void save(WorkingOutput workingOutput) {
		super.save(workingOutput);
	}
	
	@Transactional(readOnly = false)
	public void delete(WorkingOutput workingOutput) {
		super.delete(workingOutput);
	}
	
}