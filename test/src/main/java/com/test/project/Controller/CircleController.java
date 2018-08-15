package com.test.project.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.test.project.NaverLoginBO;
import com.test.project.CommonMathod.Common;
import com.test.project.Dao.FileDao;
import com.test.project.Dto.FileBean;
import com.test.project.Dto.UserBean;
import com.test.project.Service.FileService;
import com.test.project.Service.UserService;

/**
 * @패키지 com.test.project.Controller
 * @파일이름 CircleController.java
 * @작성자 KHS
 * @작성날짜 2018. 8. 12. 오후 12:06:57
 * @설명:
 */
@Controller
public class CircleController {
  private static Logger logger = LogManager.getLogger(CircleController.class);
  @Autowired
  FileService service;
  Common method = new Common();
  
  /**
   * @메소드명 : Cricle
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :동아리리스트
   */
  @RequestMapping("circle/circleList")
  public ModelAndView Cricle() {
    ModelAndView model = new ModelAndView();
    model.setViewName("circle/circleList");
    return model;
  }
  
  /**
   * @메소드명 : circleInsert
   * @작성일 : 2018. 7. 3. 오후 7:15:42
   * @작성자 : KHS
   * @설명 :동아리등록
   */
  @RequestMapping("circle/circleInsert")
  public ModelAndView circleInsert() {
    ModelAndView model = new ModelAndView();
    model.setViewName("circle/circleInsert");
    return model;
  }
  
  /**
   * @메소드명 : imgUpload
   * @작성일 : 2018. 8. 12. 오후 12:06:59
   * @작성자 : KHS
   * @설명 : 이미지업로드
   */
  @ResponseBody
  @RequestMapping(value = "/img_upload")
  public HashMap<String, Object> imgUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile img) {
    HashMap<String, Object> map = method.file_upload(img, response, request, "circle");
    FileBean vo = (FileBean) map.get("vo");
    service.file_Insert(vo);
    return map;
  }
  
}
