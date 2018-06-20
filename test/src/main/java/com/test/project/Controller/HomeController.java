package com.test.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.project.Service.UserService;

@Controller
public class HomeController {
	@Autowired
	UserService service;


	@RequestMapping("/test")
	public String test(String name) {
	System.out.println(service.UserCnt());
	System.out.println("!!!!!!!!!!!!");
	return "index";
	}

}
