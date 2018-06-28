package com.test.project.Controller;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.test.project.NaverLoginBO;
import com.test.project.Dto.User;
import com.test.project.Service.UserService;

/**
 * @패키지 com.test.project.Controller
 * @파일이름 HomeController.java
 * @작성자 KHS
 * @작성날짜 2018. 6. 20. 오후 7:39:20
 * @설명:
 */
@Controller
public class HomeController {

	private static Logger logger = LogManager.getLogger(HomeController.class);
	@Autowired
	UserService service;

	/**
	 * @메소드명 : index
	 * @작성일 : 2018. 6. 20. 오후 7:54:19
	 * @작성자 : KHS
	 * @설명 :
	 */
	@RequestMapping("/")
	public String index(String name) {
	
		return "index";
	}
	/**
	 * @메소드명 : index
	 * @작성일 : 2018. 6. 20. 오후 7:54:19
	 * @작성자 : KHS
	 * @설명 :
	 */
	@RequestMapping("/member")
	public String member(String name) {
		logger.info("================member Start=================");
		
		logger.info("================member End=================");
		return "main/member";
	}
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/LoginChk") public HashMap<String, Object> loginChk(
	 * HttpServletRequest request) {
	 * logger.info("================Login Start================="); HashMap<String,
	 * Object> map = new HashMap<String, Object>();
	 * 
	 * logger.info("================Login End=================");
	 * 
	 * return map; }
	 */
}
