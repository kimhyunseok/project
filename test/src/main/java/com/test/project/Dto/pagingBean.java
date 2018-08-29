package com.test.project.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
     * 페이징 처리 순서
     * 1. 총 페이지수
     * 2. 총 블럭(range)수
     * 3. range setting
     */
    
    // 총 게시물 수와 현재 페이지를 Controller로 부터 받아온다.
    /** 현재페이지 **/
    setCurPage(curPage);
    /** 총 게시물 수 **/
    setListCnt(listCnt);
    
    /** 1. 총 페이지 수 **/
    setPageCnt(listCnt);
    /** 2. 총 블럭(range)수 **/
    setRangeCnt(pageCnt);
    /** 3. 블럭(range) setting **/
    rangeSetting(curPage);
    
    /** DB 질의를 위한 startIndex 설정 **/
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
