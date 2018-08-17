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
import com.test.project.Dto.BoardBean;
import com.test.project.Dto.CircleBean;
import com.test.project.Dto.FileBean;
import com.test.project.Dto.UserBean;
import com.test.project.Service.BoardService;
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
  @Autowired
  private BoardService BSevice;
  
  @Autowired
  private Common method;
  
  /**
   * @메소드명 : eventList
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :이벤트목록
   */
  @RequestMapping("board/event/eventList")
  public ModelAndView eventList() {
    logger.info("이벤트목록-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("board/event/eventList");
    model.addObject("title", "이벤트목록");
    logger.info("이벤트목록-end");
    return model;
  }
  
  /**
   * @메소드명 : eventView
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :이벤트보기
   */
  @RequestMapping("board/event/eventview")
  public ModelAndView eventView() {
    logger.info("이벤트보기-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("board/event/eventView");
    model.addObject("title", "이벤트보기");
    logger.info("이벤트보기-start");
    return model;
  }
  
  /**
   * @메소드명 : eventInsert
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :이벤트등록페이지
   */
  @RequestMapping("board/event/eventInsert")
  public ModelAndView eventInsert(HttpServletResponse rep, HttpServletRequest req) {
    logger.info("이벤트등록페이지-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("board/event/eventInsert");
    model.addObject("title", "이벤트등록");
    logger.info("이벤트등록페이지-end");
    return model;
  }
  
  /**
   * @메소드명 : eventInsert_ok
   * @작성일 : 2018. 8. 18. 오전 12:31:54
   * @작성자 : KHS
   * @설명 : 이벤트등록처리
   */
  @RequestMapping("board/event/eventInsert_ok")
  public ModelAndView eventInsert_ok(ModelAndView model, HttpServletResponse rep, HttpServletRequest req, @ModelAttribute("BoardBean") BoardBean bean, MultipartFile img) {
    logger.info("이벤트등록처리-start");
    HashMap<String, Object> map = new HashMap<String, Object>();
    HashMap<String, Object> filemap = new HashMap<String, Object>();
    if (img.isEmpty() == false) {
      filemap = method.file_upload(img, rep, req, "event");
      FileBean FBean=(FileBean) filemap.get("vo");
      int no=FBean.getFile_no();
      //게시판 파일번호저장
      bean.setBoard_fileNo(no);
    }
    map.put("bean", bean);
    map.put("dbtable", "tb_event_board");
    logger.info("입력정보:" + map.toString());
    BSevice.board_Insert(map);
    model.setViewName("redirect:http://localhost:8080/board/event/eventList");
    logger.info("이벤트등록처리-end");
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
    logger.info("공지사항목록-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("board/notice/noticeList");
    model.addObject("title", "공지사항목록");
    logger.info("공지사항목록-end");
    return model;
  }
  
  /**
   * @메소드명 :noticeview
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :공지사항보기
   */
  @RequestMapping("board/qna/noticeView")
  public ModelAndView noticeView() {
    logger.info("공지사항보기-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("board/notice/noticeView");
    model.addObject("title", "공지사항보기");
    logger.info("공지사항보기-start");
    return model;
  }
  
  /**
   * @메소드명 : noticeInsert
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :공지사항등록페이지
   */
  @RequestMapping("board/notice/noticeInsert")
  public ModelAndView noticeInsert() {
    logger.info("공지사항등록-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("/board/notice/noticeInsert");
    model.addObject("title", "공지사항등록");
    logger.info("공지사항등록-end");
    return model;
  }
  /**
   * @메소드명 : noticeInsert_ok
   * @작성일 : 2018. 8. 18. 오전 1:46:36
   * @작성자 : KHS
   * @설명 :공지사항등록처리
   */
  @RequestMapping("board/notice/noticeInsert_ok")
  public ModelAndView noticeInsert_ok(ModelAndView model, HttpServletResponse rep, HttpServletRequest req, @ModelAttribute("BoardBean") BoardBean bean, MultipartFile img) {
    logger.info("공지사항등록처리-start");
    HashMap<String, Object> map = new HashMap<String, Object>();
    HashMap<String, Object> filemap = new HashMap<String, Object>();
    if (img.isEmpty() == false) {
      filemap = method.file_upload(img, rep, req, "notice");
      FileBean FBean=(FileBean) filemap.get("vo");
      int no=FBean.getFile_no();
      //게시판 파일번호저장
      bean.setBoard_fileNo(no);
    }
    map.put("bean", bean);
    map.put("dbtable", "tb_notice_board");
    BSevice.board_Insert(map);
    model.setViewName("redirect:http://localhost:8080/board/notice/noticeList");
    logger.info("공지사항등록처리-end");
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
    model.setViewName("board/qna/qnaList");
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
  @RequestMapping("board/qna/qnaView")
  public ModelAndView qnaview() {
    logger.info("qnaview-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("board/qna/qnaView");
    model.addObject("title", "QnA목록");
    logger.info("qnaview-start");
    return model;
  }
  
  /**
   * @메소드명 : qnaInsert
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 : QnA등록페이지
   */
  @RequestMapping("board/qna/qnaInsert")
  public ModelAndView qnaInsert() {
    logger.info("QnA등록페이지-start");
    ModelAndView model = new ModelAndView();
    model.setViewName("board/qna/qnaInsert");
    model.addObject("title", "QnA등록");
    logger.info("QnA등록페이지-end");
    return model;
  }
  /**
  * @메소드명 : qnaInsert_ok
  * @작성일 : 2018. 7. 3. 오후 7:15:34
  * @작성자 : KHS
  * @설명 : QnA등록처리
  */
 @RequestMapping("board/qna/qnaInsert_ok")
 public ModelAndView qnaInsert_ok(ModelAndView model, HttpServletResponse rep, HttpServletRequest req, @ModelAttribute("BoardBean") BoardBean bean, MultipartFile img) {
   logger.info("QnA등록처리-start");
   HashMap<String, Object> map = new HashMap<String, Object>();
   HashMap<String, Object> filemap = new HashMap<String, Object>();
   if (img.isEmpty() == false) {
     filemap = method.file_upload(img, rep, req, "qna");
     FileBean FBean=(FileBean) filemap.get("vo");
     int no=FBean.getFile_no();
     //게시판 파일번호저장
     bean.setBoard_fileNo(no);
   }
   map.put("bean", bean);
   map.put("dbtable", "tb_qna_board");
   BSevice.board_Insert(map);
   model.setViewName("redirect:http://localhost:8080/board/qna/qnaList");
   logger.info("QnA등록처리-end");
   return model;
 }
}
