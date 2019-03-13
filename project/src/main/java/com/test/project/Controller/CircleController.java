package com.test.project.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.test.project.CommonMathod.CFileUploadMathod;
import com.test.project.Dto.CircleBean;
import com.test.project.Dto.FileBean;
import com.test.project.Dto.pagingBean;
import com.test.project.Service.CircleService;
import com.test.project.Service.FileService;

/**
 * @패키지 com.test.project.Controller
 * @파일이름 CircleController.java
 * @작성자 KHS
 * @작성날짜 2018. 8. 12. 오후 12:06:57
 * @설명:동아리 컨트롤러
 */

@Controller
public class CircleController {
  private static Logger logger = LogManager.getLogger(CircleController.class);
  @Autowired
  private FileService service;
  @Autowired
  private CircleService cService;
  private CFileUploadMathod method = new CFileUploadMathod();
  private pagingBean test;
  
  /**
   * @메소드명 : Cricle
   * @작성일 : 2018. 7. 3. 오후 7:15:34
   * @작성자 : KHS
   * @설명 :동아리리스트
   */
  @RequestMapping("circle/circleList")
  public ModelAndView Cricle(HttpServletRequest req) {
    ModelAndView model = new ModelAndView();
    logger.info("동아리리스트-start");
    HashMap<String, Object> map = new HashMap<String, Object>();
    ArrayList<CircleBean> list;
    int listCnt = cService.Circle_Cnt();
    // 전체리스트 개수
    int curNum = Integer.parseInt(req.getParameter("pageNum"));
    // 현재 페이지
    
    test = new pagingBean(listCnt, curNum, 12);
    logger.info(">>>>>>>>>>>>>" + listCnt + " " + curNum);
    map.put("start", test.getStartIndex());
    list = cService.Circle_List(map);
    model.addObject("list", list);
    model.addObject("pagination", test);
    model.setViewName("circle/circleList");
    model.addObject("title", "동아리목록");
    logger.info("동아리리스트-end");
    return model;
  }
  
  /**
   * @메소드명 : circleInsert
   * @작성일 : 2018. 7. 3. 오후 7:15:42
   * @작성자 : KHS
   * @설명 :동아리등록
   */
  @RequestMapping("circle/circleInsert")
  public ModelAndView circleInsert(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView model = new ModelAndView();
    logger.info("circleInsert-start");
    model.setViewName("circle/circleInsert");
    model.addObject("title", "이벤트목록");
    return model;
  }
  
  /**
   * @메소드명 : circleInsert_ok
   * @작성일 : 2018. 8. 17. 오전 12:40:21
   * @작성자 : KHS
   * @설명 :동아리 등록처리
   */
  @RequestMapping("circle/circleInsert_ok")
  public String circleInsert_ok(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("CircleBean") CircleBean bean, @RequestParam(value = "logo", required = false) MultipartFile img) {
    logger.info("동아리등록처리-start");
    HashMap<String, Object> map = method.file_upload(img, response, request, "circle");
    // String url=(String) map.get("url");
    
    FileBean FBean = (FileBean) map.get("vo");
    service.file_Insert(FBean);
    bean.setCircle_Logo_Fileno(FBean.getFile_no());
    logger.info(">>>>>>>>>" + bean.toString());
    cService.Circle_insert(bean);
    try {
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<script>alert('동아리를 등록되었습니다.');</script>");
      
      out.flush();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    logger.info("동아리등록처리-finish");
    return "redirect:http://localhost:8080/circle/circleList?pageNum=1";
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
    HashMap<String, Object> map = method.edtImg_Upload(img, response, request, "circle");
    FileBean bean = (FileBean) map.get("vo");
    logger.info("----------chkEditor_이미지등록" + bean.toString() + "-------------");
    service.file_Insert(bean);
    return map;
  }
  
  /**
   * @throws UnsupportedEncodingException
   * @메소드명 : mapPosition
   * @작성일 : 2018. 8. 16. 오후 9:53:52
   * @작성자 : KHS
   * @설명 :맵 경도위도 얻는 api
   */
  @ResponseBody
  @RequestMapping(value = "/mapPosition_ajax")
  public HashMap<String, Object> mapPosition(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
    HashMap<String, Object> map = new HashMap<String, Object>();
    StringBuilder html = new StringBuilder();
    String addr = request.getParameter("address");
    String url = "https://openapi.naver.com/v1/map/geocode?query=" + URLEncoder.encode(addr, "UTF-8");
    String clientId = "30acVBn_RNTBZdDAcwhu";
    String clientSecret = "Si1F3zLXWa";
    HttpClient client = HttpClientBuilder.create().build();
    HttpGet request1 = new HttpGet(url);
    request1.addHeader("X-Naver-Client-Id", clientId); // 해더에 Clinet Id와 Client Secret을 넣습니다
    request1.addHeader("X-Naver-Client-Secret", clientSecret);
    try {
      HttpResponse response1 = client.execute(request1);
      BufferedReader reader = new BufferedReader(new InputStreamReader(response1.getEntity().getContent(), "UTF-8"));
      String current = "";
      while ((current = reader.readLine()) != null) {
        html.append(current);
      }
      reader.close();
    } catch (ClientProtocolException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    map.put("map", html.toString());
    return map;
  }
}
