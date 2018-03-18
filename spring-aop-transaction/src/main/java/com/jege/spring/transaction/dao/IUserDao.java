package com.jege.spring.transaction.dao;

import com.jege.spring.transaction.entity.User;

public interface IUserDao {
  void save(User user);

  User findByKey(Long id);
}
