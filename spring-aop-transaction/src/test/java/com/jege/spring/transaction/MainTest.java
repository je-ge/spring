package com.jege.spring.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jege.spring.transaction.entity.User;
import com.jege.spring.transaction.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class MainTest {
  @Autowired
  IUserService userService;

  @Test
  public void testName() throws Exception {
    // 如果添加aop，打印class $Proxy5
    System.out.println(userService.getClass());

    User user = new User();
    user.setName("xxx");

    userService.save(user);
    
    
    System.out.println("---------------");
    System.out.println(userService.findByKey(user.getId()));
  }
}
