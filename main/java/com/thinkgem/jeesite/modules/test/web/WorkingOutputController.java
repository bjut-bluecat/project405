/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.test.entity.WorkingOutput;
import com.thinkgem.jeesite.modules.test.service.WorkingOutputService;

/**
 * 加工输出Controller
 * @author Robin
 * @version 2018-11-12
 */
@Controller
@RequestMapping(value = "${adminPath}/test/workingOutput")
public class WorkingOutputController extends BaseController {

	@Autowired
	private WorkingOutputService workingOutputService;
	
	@ModelAttribute
	public WorkingOutput get(@RequestParam(required=false) String id) {
		WorkingOutput entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = workingOutputService.get(id);
		}
		if (entity == null){
			entity = new WorkingOutput();
		}
		return entity;
	}
	
	@RequiresPermissions("test:workingOutput:view")
	@RequestMapping(value = {"list", ""})
	public String list(WorkingOutput workingOutput, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkingOutput> page = workingOutputService.findPage(new Page<WorkingOutput>(request, response), workingOutput); 
		model.addAttribute("page", page);
		return "modules/test/workingOutputList";
	}

	@RequiresPermissions("test:workingOutput:view")
	@RequestMapping(value = "form")
	public String form(WorkingOutput workingOutput, Model model) {
		model.addAttribute("workingOutput", workingOutput);
		return "modules/test/workingOutputForm";
	}

	@RequiresPermissions("test:workingOutput:edit")
	@RequestMapping(value = "save")
	public String save(WorkingOutput workingOutput, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, workingOutput)){
			return form(workingOutput, model);
		}
		workingOutputService.save(workingOutput);
		addMessage(redirectAttributes, "保存加工输出成功成功");
		return "redirect:"+Global.getAdminPath()+"/test/workingOutput/?repage";
	}
	
	@RequiresPermissions("test:workingOutput:edit")
	@RequestMapping(value = "delete")
	public String delete(WorkingOutput workingOutput, RedirectAttributes redirectAttributes) {
		workingOutputService.delete(workingOutput);
		addMessage(redirectAttributes, "删除加工输出成功成功");
		return "redirect:"+Global.getAdminPath()+"/test/workingOutput/?repage";
	}

}