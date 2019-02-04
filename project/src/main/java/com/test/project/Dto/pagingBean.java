package com.test.project.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @패키지   com.test.project.Dto
 * @파일이름  pagingBean.java
 * @작성자   김현석
 * @작성날짜  2019. 2. 5. 오전 3:17:04
 * @설명:
 */
@Data
public class pagingBean {
  private int pageSize = 10;
  
  private int rangeSize = 10;
  private int curPage = 1;
  
  private int curRange = 1;
  private int listCnt;
  
  private int pageCnt;
  
  private int rangeCnt;
  
  private int startPage = 1;
  
  private int endPage = 1;
  
  private int startIndex = 0;
  
  private int prevPage;
  
  private int nextPage;
  
  public pagingBean(int listCnt, int curPage){
    
    /**
     * �럹�씠吏� 泥섎━ �닚�꽌
     * 1. 珥� �럹�씠吏��닔
     * 2. 珥� 釉붾윮(range)�닔
     * 3. range setting
     */
    
    // 珥� 寃뚯떆臾� �닔�� �쁽�옱 �럹�씠吏�瑜� Controller濡� 遺��꽣 諛쏆븘�삩�떎.
    /** �쁽�옱�럹�씠吏� ttt**/
    setCurPage(curPage);
    /** 珥� 寃뚯떆臾� �닔 **/
    setListCnt(listCnt);
    
    /** 1. 珥� �럹�씠吏� �닔 **/
    setPageCnt(listCnt);
    /** 2. 珥� 釉붾윮(range)�닔 **/
    setRangeCnt(pageCnt);
    /** 3. 釉붾윮(range) setting **/
    rangeSetting(curPage);
    
    /** DB 吏덉쓽瑜� �쐞�븳 startIndex �꽕�젙 **/
    setStartIndex(curPage);
}
  
  public void setPageCnt(int listCnt) {
    this.pageCnt = (int) Math.ceil(listCnt * 1.0 / pageSize);
  }
  
  public void setRangeCnt(int pageCnt) {
    this.rangeCnt = (int) Math.ceil(pageCnt * 1.0 / rangeSize);
  }
  
  public void rangeSetting(int curPage) {
    
    setCurRange(curPage);
    this.startPage = (curRange - 1) * rangeSize + 1;
    this.endPage = startPage + rangeSize - 1;
    
    if (endPage > pageCnt) {
      this.endPage = pageCnt;
    }
    
    this.prevPage = curPage - 1;
    this.nextPage = curPage + 1;
  }
  
  public void setCurRange(int curPage) {
    this.curRange = (int) ((curPage - 1) / rangeSize) + 1;
  }
  
  public void setStartIndex(int curPage) {
    this.startIndex = (curPage - 1) * pageSize;
  }
  
}