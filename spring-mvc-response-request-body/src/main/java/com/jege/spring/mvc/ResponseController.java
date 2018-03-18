package com.jege.spring.mvc;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JE哥
 * @email 1272434821@qq.com
 * @description:直接输出各种json字符串
 */
@RestController
public class ResponseController {

  @GetMapping("/jsonResponse1")
  public String jsonResponse1() {
    return "jsonResponse1";
  }

  @GetMapping("/jsonResponse2")
  public Integer[] jsonResponse2() {
    return new Integer[] { 1, 2, 3 };
  }

  @GetMapping("/jsonResponse3")
  public User jsonResponse3() {
    return new User(100L, "je_ge");
  }

  @GetMapping("/jsonResponse4")
  public List<User> jsonResponse5() {
    return Arrays.asList(new User(100L, "je_ge1"), new User(200L, "je_ge2"));
  }

}
