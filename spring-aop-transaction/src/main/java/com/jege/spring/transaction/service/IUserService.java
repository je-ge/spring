package com.jege.spring.transaction.service;

import com.jege.spring.transaction.entity.User;

//抽象主题角色，现实世界是不存在
//声明了真实主题和代理主题的共同接口
public interface IUserService {
  void save(User user);

  User findByKey(Long id);
}
