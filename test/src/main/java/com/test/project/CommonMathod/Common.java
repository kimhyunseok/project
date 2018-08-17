package com.test.project.CommonMathod;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.test.project.Dto.FileBean;
import com.test.project.Service.FileService;

/**
 * @패키지 com.test.project.CommonMathod
 * @파일이름 CommonMethod.java
 * @작성자 KHS
 * @작성날짜 2018. 8. 12. 오후 1:07:26
 * @설명:
 */
@Controller
public class Common {
  
  private static Logger logger = LogManager.getLogger(Common.class);
  @Autowired
  FileService service;
  
  /**
   * @메소드명 : file_Insert
   * @작성일 : 2018. 8. 12. 오후 1:07:29
   * @작성자 : KHS
   * @설명 :파일 업로드
   */
  public HashMap<String, Object> edtImg_Upload(MultipartFile img, HttpServletResponse response, HttpServletRequest request, String location) {
    // TODO Auto-generated method stub
    response.setContentType("image/pjpeg");
    MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
    Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
    HashMap<String, Object> map = new HashMap<String, Object>();
    FileBean vo = new FileBean();
    while (iterator.hasNext()) {
      img = multipartHttpServletRequest.getFile(iterator.next());
      if (img.isEmpty() == false) {
        
        logger.info("------------- file start -------------");
        logger.info("name : " + img.getContentType());
        logger.info("filename : " + img.getOriginalFilename());
        logger.info("size : " + img.getSize());
        vo.setFile_size(img.getSize());
        logger.info("-------------- file end --------------\n");
      }
      
    }
    // String filePath = "\\upload_img\\";
    // 파일 기본경로
    String defaultPath = request.getSession().getServletContext().getRealPath("/");
    // 파일 기본경로 _ 상세경로
    String filePath = defaultPath + "resources" + File.separator + "upload_img" + File.separator + location + File.separator;
    System.out.println("----------" + filePath);
    String originalFileName = img.getOriginalFilename();
    String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
    UUID uuid = UUID.randomUUID();
    
    String fileName = uuid.toString() + "_" + originalFileName;
    // 저장경로 폴더 생성
    File file = new File(filePath);
    
    if (file.exists() == false) {
      file.mkdirs();
    }
    
    // 서버에 파일 write
    file = new File(filePath + fileName);
    try {
      img.transferTo(file);
      map.put("uploaded", 1);
      map.put("fileName", fileName);
      map.put("url", "http://localhost:8080/resources/upload_img/" + location + "/" + fileName);
    } catch (IllegalStateException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    logger.debug("서버전송 완료");
    
    vo.setFile_o_name(originalFileName);
    vo.setFile_name(fileName);
    vo.setFile_url("http://localhost:8080/resources/upload_img/" + location + "/" + fileName);
    
    // DB에 파일내역 insert
    map.put("vo", vo);
    service.file_Insert(vo);
    return map;
  }
  
  /**
   * @메소드명 : file_Insert
   * @작성일 : 2018. 8. 12. 오후 1:07:29
   * @작성자 : KHS
   * @설명 :파일 업로드
   */
  public HashMap<String, Object> file_upload(MultipartFile img, HttpServletResponse response, HttpServletRequest request, String location) {
    // TODO Auto-generated method stub
    response.setContentType("image/pjpeg");
    MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
    Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
    HashMap<String, Object> map = new HashMap<String, Object>();
    FileBean vo = new FileBean();
    while (iterator.hasNext()) {
      img = multipartHttpServletRequest.getFile(iterator.next());
      if (img.isEmpty() == false) {
        
        logger.info("------------- file start -------------");
        logger.info("name : " + img.getContentType());
        logger.info("filename : " + img.getOriginalFilename());
        logger.info("size : " + img.getSize());
        vo.setFile_size(img.getSize());
        logger.info("-------------- file end --------------\n");
      }
      
    }
    // String filePath = "\\upload_img\\";
    // 파일 기본경로
    String defaultPath = request.getSession().getServletContext().getRealPath("/");
    // 파일 기본경로 _ 상세경로
    String filePath = defaultPath + "resources" + File.separator + "upload_img" + File.separator + location + File.separator;
    System.out.println("----------" + filePath);
    String originalFileName = img.getOriginalFilename();
    String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
    UUID uuid = UUID.randomUUID();
    
    String fileName = uuid.toString() + "_" + originalFileName;
    // 저장경로 폴더 생성
    File file = new File(filePath);
    
    if (file.exists() == false) {
      file.mkdirs();
    }
    
    vo.setFile_o_name(originalFileName);
    vo.setFile_name(fileName);
    vo.setFile_url("http://localhost:8080/resources/upload_img/" + location + "/" + fileName);
    vo.setFile_location(location);
    map.put("vo", vo);
    // DB에 파일내역 insert
    service.file_Insert(vo);
    return map;
  }
  
}
