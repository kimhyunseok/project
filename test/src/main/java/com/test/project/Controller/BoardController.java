package com.test.project.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
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
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.test.project.NaverLoginBO;
import com.test.project.CommonMathod.Common;
import com.test.project.Dao.FileDao;
import com.test.project.Dto.CircleBean;
import com.test.project.Dto.FileBean;
import com.test.project.Dto.UserBean;
import com.test.project.Service.CircleService;
import com.test.project.Service.FileService;
import com.test.project.Service.UserService;

/**
 * @패키지 com.test.project.Controller
 * @파일이름 BoardController.java
 * @작성자 KHS
 * @작성날짜 2018. 8. 12. 오후 12:06:57
 * @설명:동아리 컨트롤러
 */

@Controller
public class BoardController {
  private static Logger logger = LogManager.getLogger(BoardController.class);
  
  /**
   * @메소드명 : eventList
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :이벤트목록
   */
  @RequestMapping("board/eventList")
  public ModelAndView eventList() {
    logger.info("circleList-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("board/eventList");
    model.addObject("title", "이벤트목록");
    logger.info("circleList-end");
    return model;
  }
  
  /**
   * @메소드명 : eventview
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :이벤트보기
   */
  @RequestMapping("board/eventview")
  public ModelAndView eventview() {
    logger.info("eventview-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("event/eventview");
    model.addObject("title", "이벤트보기");
    logger.info("eventview-start");
    return model;
  }
  
  /**
   * @메소드명 : eventInsert
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :이벤트등록
   */
  @RequestMapping("board/eventInsert")
  public ModelAndView eventInsert() {
    logger.info("eventInsert-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("event/eventInsert");
    model.addObject("title", "이벤트등록");
    logger.info("eventInsert-end");
    return model;
  }
  
  /**
   * @메소드명 : noticeList
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :공지사항목록
   */
  @RequestMapping("board/noticeList")
  public ModelAndView noticeList() {
    logger.info("noticeList-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("board/noticeList");
    model.addObject("title", "공지사항목록");
    logger.info("noticeList-end");
    return model;
  }
  
  /**
   * @메소드명 :noticeview
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :공지사항보기
   */
  @RequestMapping("board/noticeview")
  public ModelAndView noticeview() {
    logger.info("noticeview-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("notice/noticeview");
    model.addObject("title", "공지사항보기");
    logger.info("noticeview-start");
    return model;
  }
  
  /**
   * @메소드명 : Cricle
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :공지사항등록
   */
  @RequestMapping("board/noticeInsert")
  public ModelAndView noticeInsert() {
    logger.info("noticeInsert-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("notice/noticeInsert");
    model.addObject("title", "공지사항등록");
    logger.info("noticeInsert-end");
    return model;
  }
  
  /**
   * @메소드명 : qnaList
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :이벤트목록
   */
  @RequestMapping("board/qnaList")
  public ModelAndView qnaList() {
    logger.info("qnaList-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("board/qnaList");
    model.addObject("title", "QnA목록");
    logger.info("qnaList-end");
    return model;
  }
  
  /**
   * @메소드명 :qnaview
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :QnA리스트
   */
  @RequestMapping("board/qnaview")
  public ModelAndView qnaview() {
    logger.info("qnaview-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("qna/qnaview");
    model.addObject("title", "QnA목록");
    logger.info("qnaview-start");
    return model;
  }
  
  /**
   * @메소드명 : qnaInsert
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :  QnA등록
   */
  @RequestMapping("board/qnaInsert")
  public ModelAndView qnaInsert() {
    logger.info("qnaInsert-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("qna/qnaInsert");
    model.addObject("title", "QnA등록");
    logger.info("qnaInsert-end");
    return model;
  }
}
