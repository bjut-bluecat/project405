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
import com.thinkgem.jeesite.modules.test.entity.MaterialOutput;
import com.thinkgem.jeesite.modules.test.service.MaterialOutputService;

/**
 * 原材料输出Controller
 * @author Robin
 * @version 2018-11-12
 */
@Controller
@RequestMapping(value = "${adminPath}/test/materialOutput")
public class MaterialOutputController extends BaseController {

	@Autowired
	private MaterialOutputService materialOutputService;
	
	@ModelAttribute
	public MaterialOutput get(@RequestParam(required=false) String id) {
		MaterialOutput entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = materialOutputService.get(id);
		}
		if (entity == null){
			entity = new MaterialOutput();
		}
		return entity;
	}
	
	@RequiresPermissions("test:materialOutput:view")
	@RequestMapping(value = {"list", ""})
	public String list(MaterialOutput materialOutput, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MaterialOutput> page = materialOutputService.findPage(new Page<MaterialOutput>(request, response), materialOutput); 
		model.addAttribute("page", page);
		return "modules/test/materialOutputList";
	}

	@RequiresPermissions("test:materialOutput:view")
	@RequestMapping(value = "form")
	public String form(MaterialOutput materialOutput, Model model) {
		model.addAttribute("materialOutput", materialOutput);
		return "modules/test/materialOutputForm";
	}

	@RequiresPermissions("test:materialOutput:edit")
	@RequestMapping(value = "save")
	public String save(MaterialOutput materialOutput, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, materialOutput)){
			return form(materialOutput, model);
		}
		materialOutputService.save(materialOutput);
		addMessage(redirectAttributes, "保存原材料输出成功成功");
		return "redirect:"+Global.getAdminPath()+"/test/materialOutput/?repage";
	}
	
	@RequiresPermissions("test:materialOutput:edit")
	@RequestMapping(value = "delete")
	public String delete(MaterialOutput materialOutput, RedirectAttributes redirectAttributes) {
		materialOutputService.delete(materialOutput);
		addMessage(redirectAttributes, "删除原材料输出成功成功");
		return "redirect:"+Global.getAdminPath()+"/test/materialOutput/?repage";
	}

}