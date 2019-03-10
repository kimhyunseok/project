package com.test.project.Dto;

import java.util.Date;

import lombok.Data;

/**
 * @패키지   com.test.project.Dto
 * @파일이름  FileBean.java
 * @작성자   김현석
 * @작성날짜  2019. 2. 5. 오전 3:17:08
 * @설명:
 */
@Data
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
