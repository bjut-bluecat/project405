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
import com.thinkgem.jeesite.modules.test.entity.WasteOutput;
import com.thinkgem.jeesite.modules.test.service.WasteOutputService;

/**
 * 废弃输出Controller
 * @author Robin
 * @version 2018-11-12
 */
@Controller
@RequestMapping(value = "${adminPath}/test/wasteOutput")
public class WasteOutputController extends BaseController {

	@Autowired
	private WasteOutputService wasteOutputService;
	
	@ModelAttribute
	public WasteOutput get(@RequestParam(required=false) String id) {
		WasteOutput entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wasteOutputService.get(id);
		}
		if (entity == null){
			entity = new WasteOutput();
		}
		return entity;
	}
	
	@RequiresPermissions("test:wasteOutput:view")
	@RequestMapping(value = {"list", ""})
	public String list(WasteOutput wasteOutput, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WasteOutput> page = wasteOutputService.findPage(new Page<WasteOutput>(request, response), wasteOutput); 
		model.addAttribute("page", page);
		return "modules/test/wasteOutputList";
	}

	@RequiresPermissions("test:wasteOutput:view")
	@RequestMapping(value = "form")
	public String form(WasteOutput wasteOutput, Model model) {
		model.addAttribute("wasteOutput", wasteOutput);
		return "modules/test/wasteOutputForm";
	}

	@RequiresPermissions("test:wasteOutput:edit")
	@RequestMapping(value = "save")
	public String save(WasteOutput wasteOutput, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wasteOutput)){
			return form(wasteOutput, model);
		}
		wasteOutputService.save(wasteOutput);
		addMessage(redirectAttributes, "保存废弃输出成功成功");
		return "redirect:"+Global.getAdminPath()+"/test/wasteOutput/?repage";
	}
	
	@RequiresPermissions("test:wasteOutput:edit")
	@RequestMapping(value = "delete")
	public String delete(WasteOutput wasteOutput, RedirectAttributes redirectAttributes) {
		wasteOutputService.delete(wasteOutput);
		addMessage(redirectAttributes, "删除废弃输出成功成功");
		return "redirect:"+Global.getAdminPath()+"/test/wasteOutput/?repage";
	}

}