package com.test.project.Controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
		logger.info("================index Start=================");
		// System.out.println(service.UserCnt());
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
	@RequestMapping("/LoginChk")
	public ModelAndView loginChk(String name, HttpServletRequest request) {
		logger.info("================Login Start=================");
		final int LOGIN_ID_FAIL=1;
		final int LOGIN_PW_FAIL=2;
		final int LOGIN_SUCCESS=2;
		ModelAndView mv = new ModelAndView(); 
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		System.out.println(id+"+++++++++++++"+pw);
		if(id.equals("")&&id.isEmpty()==true) {
			logger.info(">>>>>>>>>>>>>>>>>>>>>>>아이디 입력해주세요");
			mv.addObject("chk", LOGIN_ID_FAIL);
		}
		else if(pw.equals("")&&pw.isEmpty()==true){
			logger.info(">>>>>>>>>>>>>>>>>>>>>>>패스워드 입력해주세요");
			mv.addObject("chk", LOGIN_PW_FAIL);
		}
		else {
			logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>로그인성공");
			/*int loginChk=service.LoginChk(id, pw);
			if(loginChk==1){
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패");
			}*/
			mv.addObject("chk", LOGIN_SUCCESS);
		}
		logger.info("================Login End=================");
		mv.setViewName("main/Login");
		return mv;
	}
}
