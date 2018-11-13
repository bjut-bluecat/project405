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
import com.thinkgem.jeesite.modules.test.entity.MaterialInput;
import com.thinkgem.jeesite.modules.test.service.MaterialInputService;

/**
 * 原材料输入Controller
 * @author 蓝猫
 * @version 2018-11-12
 */
@Controller
@RequestMapping(value = "${adminPath}/test/materialInput")
public class MaterialInputController extends BaseController {

	@Autowired
	private MaterialInputService materialInputService;
	
	@ModelAttribute
	public MaterialInput get(@RequestParam(required=false) String id) {
		MaterialInput entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = materialInputService.get(id);
		}
		if (entity == null){
			entity = new MaterialInput();
		}
		return entity;
	}
	
	@RequiresPermissions("test:materialInput:view")
	@RequestMapping(value = {"list", ""})
	public String list(MaterialInput materialInput, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MaterialInput> page = materialInputService.findPage(new Page<MaterialInput>(request, response), materialInput); 
		model.addAttribute("page", page);
		return "modules/test/materialInputList";
	}

	@RequiresPermissions("test:materialInput:view")
	@RequestMapping(value = "form")
	public String form(MaterialInput materialInput, Model model) {
		model.addAttribute("materialInput", materialInput);
		return "modules/test/materialInputForm";
	}

	@RequiresPermissions("test:materialInput:edit")
	@RequestMapping(value = "save")
	public String save(MaterialInput materialInput, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, materialInput)){
			return form(materialInput, model);
		}
		materialInputService.save(materialInput);
		addMessage(redirectAttributes, "保存原材料输入成功成功");
		return "redirect:"+Global.getAdminPath()+"/test/materialInput/?repage";
	}
	
	@RequiresPermissions("test:materialInput:edit")
	@RequestMapping(value = "delete")
	public String delete(MaterialInput materialInput, RedirectAttributes redirectAttributes) {
		materialInputService.delete(materialInput);
		addMessage(redirectAttributes, "删除原材料输入成功成功");
		return "redirect:"+Global.getAdminPath()+"/test/materialInput/?repage";
	}

}