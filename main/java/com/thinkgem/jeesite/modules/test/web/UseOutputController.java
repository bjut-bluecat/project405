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
import com.thinkgem.jeesite.modules.test.entity.UseOutput;
import com.thinkgem.jeesite.modules.test.service.UseOutputService;

/**
 * 使用输出Controller
 * @author Robin
 * @version 2018-11-12
 */
@Controller
@RequestMapping(value = "${adminPath}/test/useOutput")
public class UseOutputController extends BaseController {

	@Autowired
	private UseOutputService useOutputService;
	
	@ModelAttribute
	public UseOutput get(@RequestParam(required=false) String id) {
		UseOutput entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = useOutputService.get(id);
		}
		if (entity == null){
			entity = new UseOutput();
		}
		return entity;
	}
	
	@RequiresPermissions("test:useOutput:view")
	@RequestMapping(value = {"list", ""})
	public String list(UseOutput useOutput, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<UseOutput> page = useOutputService.findPage(new Page<UseOutput>(request, response), useOutput); 
		model.addAttribute("page", page);
		return "modules/test/useOutputList";
	}

	@RequiresPermissions("test:useOutput:view")
	@RequestMapping(value = "form")
	public String form(UseOutput useOutput, Model model) {
		model.addAttribute("useOutput", useOutput);
		return "modules/test/useOutputForm";
	}

	@RequiresPermissions("test:useOutput:edit")
	@RequestMapping(value = "save")
	public String save(UseOutput useOutput, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, useOutput)){
			return form(useOutput, model);
		}
		useOutputService.save(useOutput);
		addMessage(redirectAttributes, "保存使用输出成功成功");
		return "redirect:"+Global.getAdminPath()+"/test/useOutput/?repage";
	}
	
	@RequiresPermissions("test:useOutput:edit")
	@RequestMapping(value = "delete")
	public String delete(UseOutput useOutput, RedirectAttributes redirectAttributes) {
		useOutputService.delete(useOutput);
		addMessage(redirectAttributes, "删除使用输出成功成功");
		return "redirect:"+Global.getAdminPath()+"/test/useOutput/?repage";
	}

}