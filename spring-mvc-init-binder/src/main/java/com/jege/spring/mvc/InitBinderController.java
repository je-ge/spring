package com.jege.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JE哥
 * @email 1272434821@qq.com
 * @description:对象精准绑定接收控制器类
 */
@Controller
public class InitBinderController {

  // 使用 @InitBinder 注解进行绑定参数。前台表单中name属性仍然使用Object.Param形式传入。
  // （另一种解决思路：扩展spring的HandlerMethodArgumentResolver以支持自定义的数据绑定方式。）
  @InitBinder
  public void init(WebDataBinder binder) {
    binder.setFieldDefaultPrefix("user.");
  }

  // 访问地址
  // http://localhost:8080/user2?user.id=1&user.name=xyz&user.password=je-ge

  @RequestMapping("/user2")
  public void user2(User user) {
    System.out.println(user);
  }

}
