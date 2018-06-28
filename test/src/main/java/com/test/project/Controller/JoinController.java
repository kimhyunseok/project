/**
* 1. 프로젝트명 : test
* 2. 패키지명(또는 디렉토리 경로) : com.test.project.Controller
* 3. 파일명 : LoginController.java
* 4. 작성일 : 2018. 6. 26. 오후 5:46:20
* 5. 작성자 : KHS
* 6. 설명 :
*/

package com.test.project.Controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.test.project.NaverLoginBO;
import com.test.project.Dto.User;
import com.test.project.Service.UserService;

/**
 * @패키지 com.test.project.Controller
 * @파일이름 LoginController.java
 * @작성자 KHS
 * @작성날짜 2018. 6. 26. 오후 5:46:20
 * @설명:
 */
@Controller
public class JoinController {
  /* NaverLoginBO */
  private static Logger logger = LogManager.getLogger(JoinController.class);
  @Autowired
  UserService service;
  
  /**
   * @메소드명 : joinChk
   * @작성일 : 2018. 6. 29. 오전 1:25:45
   * @작성자 : KHS
   * @설명 : 회원가입
   */
  @RequestMapping(value = "/IdChk.ajax", method = { RequestMethod.GET, RequestMethod.POST })
  @ResponseBody
  public HashMap<String, Object> IdChk(User user, HttpServletRequest request) {
    logger.info("================IdChk Start=================");
    HashMap<String, Object> map = new HashMap<String, Object>();
    String user_id = user.getUser_id();
    int idchk = service.UserCnt(user_id);
    map.put("idchk", idchk);
    logger.info("================IdChk End=================");
    return map;
  }
  
}
