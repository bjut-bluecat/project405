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
import com.thinkgem.jeesite.modules.test.entity.WorkingInput;
import com.thinkgem.jeesite.modules.test.service.WorkingInputService;

/**
 * 加工输入Controller
 * @author Robin
 * @version 2018-11-12
 */
@Controller
@RequestMapping(value = "${adminPath}/test/workingInput")
public class WorkingInputController extends BaseController {

	@Autowired
	private WorkingInputService workingInputService;
	
	@ModelAttribute
	public WorkingInput get(@RequestParam(required=false) String id) {
		WorkingInput entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = workingInputService.get(id);
		}
		if (entity == null){
			entity = new WorkingInput();
		}
		return entity;
	}
	
	@RequiresPermissions("test:workingInput:view")
	@RequestMapping(value = {"list", ""})
	public String list(WorkingInput workingInput, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkingInput> page = workingInputService.findPage(new Page<WorkingInput>(request, response), workingInput); 
		model.addAttribute("page", page);
		return "modules/test/workingInputList";
	}

	@RequiresPermissions("test:workingInput:view")
	@RequestMapping(value = "form")
	public String form(WorkingInput workingInput, Model model) {
		model.addAttribute("workingInput", workingInput);
		return "modules/test/workingInputForm";
	}

	@RequiresPermissions("test:workingInput:edit")
	@RequestMapping(value = "save")
	public String save(WorkingInput workingInput, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, workingInput)){
			return form(workingInput, model);
		}
		workingInputService.save(workingInput);
		addMessage(redirectAttributes, "保存加工输入成功成功");
		return "redirect:"+Global.getAdminPath()+"/test/workingInput/?repage";
	}
	
	@RequiresPermissions("test:workingInput:edit")
	@RequestMapping(value = "delete")
	public String delete(WorkingInput workingInput, RedirectAttributes redirectAttributes) {
		workingInputService.delete(workingInput);
		addMessage(redirectAttributes, "删除加工输入成功成功");
		return "redirect:"+Global.getAdminPath()+"/test/workingInput/?repage";
	}

}