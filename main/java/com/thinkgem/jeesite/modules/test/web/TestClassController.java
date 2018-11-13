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
import com.thinkgem.jeesite.modules.test.entity.TestClass;
import com.thinkgem.jeesite.modules.test.service.TestClassService;

/**
 * 班级管理Controller
 * @author 蓝猫
 * @version 2018-09-18
 */
@Controller
@RequestMapping(value = "${adminPath}/test/testClass")
public class TestClassController extends BaseController {

	@Autowired
	private TestClassService testClassService;
	
	@ModelAttribute
	public TestClass get(@RequestParam(required=false) String id) {
		TestClass entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = testClassService.get(id);
		}
		if (entity == null){
			entity = new TestClass();
		}
		return entity;
	}
	
	@RequiresPermissions("test:testClass:view")
	@RequestMapping(value = {"list", ""})
	public String list(TestClass testClass, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TestClass> page = testClassService.findPage(new Page<TestClass>(request, response), testClass); 
		model.addAttribute("page", page);
		return "modules/test/testClassList";
	}

	@RequiresPermissions("test:testClass:view")
	@RequestMapping(value = "form")
	public String form(TestClass testClass, Model model) {
		model.addAttribute("testClass", testClass);
		return "modules/test/testClassForm";
	}

	@RequiresPermissions("test:testClass:edit")
	@RequestMapping(value = "save")
	public String save(TestClass testClass, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, testClass)){
			return form(testClass, model);
		}
		testClassService.save(testClass);
		addMessage(redirectAttributes, "保存班级成功");
		return "redirect:"+Global.getAdminPath()+"/test/testClass/?repage";
	}
	
	@RequiresPermissions("test:testClass:edit")
	@RequestMapping(value = "delete")
	public String delete(TestClass testClass, RedirectAttributes redirectAttributes) {
		testClassService.delete(testClass);
		addMessage(redirectAttributes, "删除班级成功");
		return "redirect:"+Global.getAdminPath()+"/test/testClass/?repage";
	}

}