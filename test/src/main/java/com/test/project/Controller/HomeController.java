package com.test.project.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.project.Dto.User;
import com.test.project.Service.UserService;

import net.sf.json.JSONArray;

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
		logger.info("================index Start=================");
		service.UserCnt();
		logger.info("================index End=================");
		return "index";
	}

	/**
	 * @메소드명 : index
	 * @작성일 : 2018. 6. 20. 오후 7:42:34
	 * @작성자 : KHS
	 * @설명 : LoginPage 이동
	 */
	@RequestMapping("/login")
	public String login(String name) {
		return "main/Login";
	}

	/**
	 * 
	 * @메소드명 : loginChk
	 * @작성일 : 2018. 6. 20. 오후 7:54:59
	 * @작성자 : KHS
	 * @설명 : login check
	 */
	@ResponseBody
	@RequestMapping("/LoginChk.ajax")
	public HashMap<String, Object> loginChk(User user, HttpServletRequest request) {
		logger.info("================Login Start=================");
		final int LOGIN_ID_FAIL = 3;
		final int LOGIN_PW_FAIL = 4;
		final Boolean LOGIN_SUCCESS = true;
		final Boolean LOGIN_FAIL = false;
		
		String user_id = user.getUser_id();
		String user_pw = user.getUser_pw();
		HttpSession session = request.getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();

		if (user_id.equals("") && user_id.isEmpty() == true) {
			logger.info("==================ID Empty==================");
			map.put("chk", LOGIN_ID_FAIL);
		} else if (user_pw.equals("") && user_pw.isEmpty() == true) {
			logger.info("==================Password Empty==================");
			map.put("chk", LOGIN_PW_FAIL);
		} else {
			int loginChk = service.LoginChk(user);
				if (loginChk == 1) {
					logger.info("==================Login Success==================");
					session.setAttribute("ss_id", user_id);
					logger.info("=================="+session.getAttribute("ss_id").toString()+"==================");
					map.put("chk", LOGIN_SUCCESS);
				} else {
					logger.info("==================Login Fail");
					map.put("chk", LOGIN_FAIL);
				}
		}
		logger.info("================Login End=================");
		return map;
	}
	@RequestMapping("/loginout")
	public String loginOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("ss_id");
		return "index";
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
