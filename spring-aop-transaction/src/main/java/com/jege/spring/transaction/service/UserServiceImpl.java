package com.jege.spring.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jege.spring.transaction.dao.IUserDao;
import com.jege.spring.transaction.entity.User;

//真实主题角色：房东
@Service
public class UserServiceImpl implements IUserService {
  @Autowired
  private IUserDao userDao;

  @Override
  public void save(User user) {
    userDao.save(user);
  }

  @Override
  public User findByKey(Long id) {
    return userDao.findByKey(id);
  }

}
