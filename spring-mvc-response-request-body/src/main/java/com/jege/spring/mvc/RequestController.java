package com.jege.spring.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author JE哥
 * @email 1272434821@qq.com
 * @description:前台提交json字符串自动转换为后台模型对象
 */
@Controller
public class RequestController {

  @GetMapping("/jsonRequest1")
  public String jsonRequest1() {
    return "jsonRequest1";
  }

  @PostMapping("/jsonRequest2")
  public String jsonRequest2(User user) {
    System.out.println(user);
    return "jsonRequest1";
  }

  @PostMapping("/jsonRequest3")
  @ResponseBody
  public String jsonRequest3(@RequestBody User user) {
    System.out.println(user);
    return "ok";
  }

  @PostMapping("/jsonRequest4")
  @ResponseBody
  public String jsonRequest4(@RequestBody List<User> users) {
    System.out.println(users);
    return "ok";
  }

  @PostMapping("/jsonRequest5")
  @ResponseBody
  public String jsonRequest5(Long[] ids) {
    System.out.println(ids.length);
    System.out.println(Arrays.toString(ids));
    return "ok";
  }

  @PostMapping("/jsonRequest6")
  @ResponseBody
  public String jsonRequest6(String ids) {
    System.out.println(ids);
    return "ok";
  }

  @PostMapping("/jsonRequest7")
  @ResponseBody
  public String jsonRequest7(@RequestParam(value = "ids[]") String[] ids) {
    System.out.println(ids.length);
    System.out.println(Arrays.toString(ids));
    return "ok";
  }
  
}
