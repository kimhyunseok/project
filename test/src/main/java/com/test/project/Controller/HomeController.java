package com.test.project.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.project.TestApplication;
import com.test.project.Service.UserService;

@Controller
public class HomeController {
	private static Logger logger = LogManager.getLogger(HomeController.class);
	@Autowired
	UserService service;

	@RequestMapping("/")
	public String index(String name) {
		logger.info("================index Start=================");
		System.out.println(service.UserCnt());
		logger.info("================index End=================");
		return "index";
	}
	
	@RequestMapping("/Login")
	public String login(String name) {
		logger.info("================Login Start=================");
		System.out.println("Login");
		logger.info("================Login End=================");
		return "main/Login";
	}

}
