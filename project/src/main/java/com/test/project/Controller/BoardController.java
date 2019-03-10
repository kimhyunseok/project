package com.test.project.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.test.project.CommonMathod.CFileUploadMathod;
import com.test.project.Dto.BRelplyBean;
import com.test.project.Dto.BoardBean;
import com.test.project.Dto.FileBean;
import com.test.project.Dto.pagingBean;
import com.test.project.Service.BReplyService;
import com.test.project.Service.BoardService;
import com.test.project.Service.FileService;

/**
 * @패키지 com.test.project.Controller
 * @파일이름 BoardController.java
 * @작성자 KHS
 * @작성날짜 2018. 8. 12. 오후 12:06:57
 * @설명:동아리 컨트롤러
 */

/**
 * @패키지 com.test.project.Controller
 * @파일이름 BoardController.java
 * @작성자 김현석
 * @작성날짜 2019. 3. 10. 오후 10:11:38
 * @설명:
 */
@Controller
public class BoardController {
  private static Logger logger = LogManager.getLogger(BoardController.class);
  @Autowired
  private BoardService BSevice;
  @Autowired
  private BReplyService BReSevice;
  @Autowired
  private FileService FSevice;
  @Autowired
  private CFileUploadMathod method;
  private ModelAndView model = new ModelAndView();
  private pagingBean test;
  
  /**
   * @메소드명 : eventList
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :이벤트목록
   */
  @RequestMapping("board/event/eventList")
  public ModelAndView eventList(HttpServletRequest req) {
    logger.info("이벤트목록-start");
    HashMap<String, Object> map = new HashMap<String, Object>();
    ArrayList<BoardBean> list;
    int listCnt = BSevice.board_Cnt("tb_event_board");
    // 전체리스트 개수
    Enumeration reqName = req.getParameterNames();
    int curNum = Integer.parseInt(req.getParameter("pageNum"));
    test = new pagingBean(listCnt, curNum);
    map.put("db_table", "tb_event_board");
    map.put("start", test.getStartIndex());
    list = BSevice.board_List(map);
    model.setViewName("board/event/eventList");
    model.addObject("pagination", test);
    model.addObject("list", list);
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
  @RequestMapping("board/event/eventView")
  public ModelAndView eventView(HttpServletResponse rep, HttpServletRequest req) {
    logger.info("이벤트보기-start");
    String pageNum = req.getParameter("pageNum");
    HashMap<String, Object> map = new HashMap<String, Object>();
    BoardBean view = null;
    FileBean bean = null;
    map.put("db_table", "tb_event_board");
    map.put("board_No", pageNum);
    view = BSevice.board_View(map);
    bean = FSevice.file_Select(view.getBoard_fileNo());
    ArrayList<BRelplyBean> list = BReSevice.reply_List(pageNum);
    model.setViewName("board/event/eventView");
    model.addObject("title", "이벤트보기");
    model.addObject("View", view);
    model.addObject("Reply", list);
    model.addObject("File", bean);
    logger.info("이벤트보기-end");
    return model;
  }
  
  /**
   * @메소드명 : eventReply_Ins
   * @작성일 : 2019. 3. 10. 오후 10:11:48
   * @작성자 : 김현석
   * @설명 :
   */
  @ResponseBody
  @RequestMapping("board/event/eventReply_Ins.ajax")
  public HashMap<String, Object> eventReply_Ins(HttpServletResponse rep, HttpServletRequest request, @RequestParam(value = "content") String content) {
    logger.info("이벤트댓글-start");
    HashMap<String, Object> map = new HashMap<String, Object>();
    String board_no = request.getParameter("board_no");
    map.put("board_no", board_no);
    map.put("board_content", content);
    BReSevice.reply_Insert(map);
    
    // map.put("content", "succes");
    logger.info("이벤트댓글-end");
    return map;
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
  public ModelAndView eventInsert_ok(ModelAndView model, HttpServletResponse rep, HttpServletRequest req, @ModelAttribute("BoardBean") BoardBean bean) {
    logger.info("이벤트등록처리-start");
    HashMap<String, Object> map = new HashMap<String, Object>();
    HashMap<String, Object> filemap = new HashMap<String, Object>();
    MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req;
    Iterator<String> iterator = mhsr.getFileNames();
    MultipartFile multipartFile = null;
    while (iterator.hasNext()) {
      multipartFile = mhsr.getFile(iterator.next());
      if (multipartFile.isEmpty() == false) {
        logger.debug("------------- file start -------------");
        logger.debug("name : " + multipartFile.getName());
        logger.debug("filename : " + multipartFile.getOriginalFilename());
        logger.debug("size : " + multipartFile.getSize());
        logger.debug("-------------- file end --------------\n");
      }
    }
    String orgname = multipartFile.getOriginalFilename();
    
    // 확장자 구하기
    String exc = orgname.substring(orgname.lastIndexOf(".") + 1, orgname.length());
    
    if (multipartFile.isEmpty() == false) {
      // 이미지 empty
      if (exc.equals("hwp") || exc.equals("jpg") || exc.equals("png") || exc.equals("xlsx")) {
        logger.info("파일저장처리-start");
        filemap = method.file_upload(multipartFile, rep, req, "event");// 파일저장
        FileBean FBean = (FileBean) filemap.get("vo");
        map.put("bean", bean);
        map.put("dbtable", "tb_event_board");
        map.put("board_fileNo", FBean.getFile_no());
        BSevice.board_Insert(map);
        // 게시판 파일번호저장
        model.setViewName("redirect:/board/event/eventList?pageNum=1");
        logger.info("파일저장처리-end");
      } else {
        try {
          rep.setContentType("text/html; charset=UTF-8");
          PrintWriter out = rep.getWriter();
          out.println("<script>alert('엑셀,한글파일,jpg,png만 됩니다.');</script>");
          out.println("<script>window.history.back();</script>");
          out.flush();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      // 이미지 empty
    } else {
      map.put("bean", bean);
      map.put("dbtable", "tb_event_board");
      BSevice.board_Insert(map); // db에 저장하기
      model.setViewName("redirect:/board/event/eventList?pageNum=1");
    }
    
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
      Boolean tf = (Boolean) filemap.get("tf");
      if (tf == true) {
        FileBean FBean = (FileBean) filemap.get("vo");
        int no = FBean.getFile_no();
        // 게시판 파일번호저장
        bean.setBoard_fileNo(no);
        model.setViewName("redirect:/board/notice/noticeList");
      } else {
        try {
          rep.setContentType("text/html; charset=UTF-8");
          PrintWriter out = rep.getWriter();
          out.println("<script>alert('엑셀,한글파일만 됩니다.');</script>");
          out.println("<script>window.history.back();</script>");
          out.flush();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
    map.put("bean", bean);
    map.put("dbtable", "tb_notice_board");
    model.setViewName("board/notice/noticeInsert");
    BSevice.board_Insert(map);
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
      Boolean tf = (Boolean) filemap.get("tf");
      if (tf == true) {
        FileBean FBean = (FileBean) filemap.get("vo");
        int no = FBean.getFile_no();
        model.setViewName("redirect:/board/qna/qnaList");
        // 게시판 파일번호저장
        bean.setBoard_fileNo(no);
      } else {
        try {
          rep.setContentType("text/html; charset=UTF-8");
          PrintWriter out = rep.getWriter();
          out.println("<script>alert('엑셀,한글파일만 됩니다.');</script>");
          out.println("<script>window.history.back();</script>");
          out.flush();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
    map.put("bean", bean);
    map.put("dbtable", "tb_qna_board");
    model.setViewName("board/qna/qnaInsert");
    BSevice.board_Insert(map);
    logger.info("QnA등록처리-end");
    return model;
  }
}
