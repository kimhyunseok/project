package com.test.project.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.project.Dao.FileDao;
import com.test.project.Dto.FileBean;
/**
 * @패키지   com.test.project.Service
 * @파일이름  FileService.java
 * @작성자   KHS
 * @작성날짜  2018. 8. 12. 오후 1:02:07
 * @설명:
 */
@Service
public class FileService {
  
  private static Logger logger = LogManager.getLogger(FileService.class);
  @Autowired
  private FileDao mapper;
  
  
  public int file_Insert(FileBean file) {
    // TODO Auto-generated method stub
    System.out.println(1111111);
   return mapper.file_Insert(file);
  }
  

  public int file_Update() {
    // TODO Auto-generated method stub
    return 0;
  }
  
 
  public int file_Delete() {
    // TODO Auto-generated method stub
    return 0;
  }
  
}
