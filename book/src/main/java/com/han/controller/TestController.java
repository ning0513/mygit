package com.han.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.han.service.ITestService;
import com.han.service.impl.TestService;

@Controller
public class TestController {
	
	@Autowired
	private ITestService testService;

	
	@RequestMapping("/test")
	@ResponseBody
	public String execute(){
		testService.show();
		return "test";
	}
}
