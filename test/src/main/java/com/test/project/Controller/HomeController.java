package com.test.project.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.MultiValueMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.test.project.Dto.UserBean;
import com.test.project.Service.UserService;

import lombok.Value;

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
   * @메소드명 : member
   * @작성일 : 2018. 7. 2. 오후 9:36:31
   * @작성자 : KHS
   * @설명 : 회원가입
   */
  @RequestMapping("/member")
  public ModelAndView member(String name) {
    logger.info("================member Start=================");
    ModelAndView model = new ModelAndView();
    model.addObject("user", 1);
    model.setViewName("main/member");
    logger.info("================member End=================");
    return model;
  }
  
  /**
   * @메소드명 : memberUpdate
   * @작성일 : 2018. 7. 2. 오후 9:36:11
   * @작성자 : KHS
   * @설명 : 회원정보수정
   */
  @RequestMapping("/memberUpdate")
  public ModelAndView memberUpdate(HttpSession session) {
    logger.info("================memberUpdate Start=================");
    ModelAndView model = new ModelAndView();
    model.addObject("user", 2);
    model.setViewName("main/member");
    Object user_id = session.getAttribute("ss_id");
    if (user_id != "") {
      UserBean user = service.SelectUserInfo(user_id.toString());
      model.addObject("user", 2);
      model.addObject("user_info", user);
    }
    logger.info("================memberUpdate End=================");
    return model;
  }
  
  @RequestMapping("/main/UploadComplete")
  public ModelAndView test(HttpSession session) {
    logger.info("================memberUpdate Start=================");
    ModelAndView model = new ModelAndView();
    model.setViewName("main/UploadComplete");
    logger.info("================memberUpdate End=================");
    return model;
  }
  
  /**
   * @메소드명 : imageUpload
   * @작성일 : 2018. 7. 3. 오후 7:50:33
   * @작성자 : KHS
   * @설명 :이미지 업로드
   */ 


}

/*
 * @ResponseBody
 * 
 * @RequestMapping("/LoginChk") public HashMap<String, Object> loginChk( HttpServletRequest request) { logger.info("================Login Start================="); HashMap<String, Object> map = new HashMap<String, Object>();
 * 
 * logger.info("================Login End=================");
 * 
 * return map; }
 */
