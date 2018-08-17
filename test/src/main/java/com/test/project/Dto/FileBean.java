package com.test.project.Dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileBean {
  private int file_no;
  private String file_location;
  private String file_o_name;
  private String file_name;
  private String filename;
  private String file_url;
  private Long file_size;
  private Date file_in_date;
  
  @Override
  public String toString() {
    return "FileBean [file_no=" + file_no + ", file_location=" + file_location + ", file_o_name=" + file_o_name + ", file_name=" + file_name + ", filename=" + filename + ", file_url=" + file_url + ", file_size=" + file_size + ", file_in_date=" + file_in_date + "]";
  }
}
