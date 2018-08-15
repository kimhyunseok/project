package com.test.project.Dao;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;
import com.test.project.Dto.FileBean;

@Mapper
public interface FileDao {
  public int file_Insert(FileBean file);
  public int file_Update();
  public int file_Delete();
}
