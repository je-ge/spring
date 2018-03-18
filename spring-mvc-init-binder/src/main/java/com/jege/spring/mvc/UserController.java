package com.jege.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JE哥
 * @email 1272434821@qq.com
 * @description:控制器类
 */
@Controller
public class UserController {

  // 访问地址
  // http://localhost:8080/user?id=1&name=xyz&password=je-ge

  @RequestMapping("/user")
  public void user(User user) {
    System.out.println(user);
  }

}
