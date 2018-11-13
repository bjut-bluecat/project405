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
import com.thinkgem.jeesite.modules.test.entity.WasteInput;
import com.thinkgem.jeesite.modules.test.service.WasteInputService;

/**
 * 废弃输入Controller
 * @author Robin
 * @version 2018-11-12
 */
@Controller
@RequestMapping(value = "${adminPath}/test/wasteInput")
public class WasteInputController extends BaseController {

	@Autowired
	private WasteInputService wasteInputService;
	
	@ModelAttribute
	public WasteInput get(@RequestParam(required=false) String id) {
		WasteInput entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wasteInputService.get(id);
		}
		if (entity == null){
			entity = new WasteInput();
		}
		return entity;
	}
	
	@RequiresPermissions("test:wasteInput:view")
	@RequestMapping(value = {"list", ""})
	public String list(WasteInput wasteInput, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WasteInput> page = wasteInputService.findPage(new Page<WasteInput>(request, response), wasteInput); 
		model.addAttribute("page", page);
		return "modules/test/wasteInputList";
	}

	@RequiresPermissions("test:wasteInput:view")
	@RequestMapping(value = "form")
	public String form(WasteInput wasteInput, Model model) {
		model.addAttribute("wasteInput", wasteInput);
		return "modules/test/wasteInputForm";
	}

	@RequiresPermissions("test:wasteInput:edit")
	@RequestMapping(value = "save")
	public String save(WasteInput wasteInput, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wasteInput)){
			return form(wasteInput, model);
		}
		wasteInputService.save(wasteInput);
		addMessage(redirectAttributes, "保存废弃输入成功成功");
		return "redirect:"+Global.getAdminPath()+"/test/wasteInput/?repage";
	}
	
	@RequiresPermissions("test:wasteInput:edit")
	@RequestMapping(value = "delete")
	public String delete(WasteInput wasteInput, RedirectAttributes redirectAttributes) {
		wasteInputService.delete(wasteInput);
		addMessage(redirectAttributes, "删除废弃输入成功成功");
		return "redirect:"+Global.getAdminPath()+"/test/wasteInput/?repage";
	}

}