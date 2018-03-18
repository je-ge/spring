package com.jege.spring.transaction.dao;

import org.springframework.stereotype.Repository;

import com.jege.spring.transaction.entity.User;
import com.jege.spring.transaction.util.HiberanteUtils;

@Repository
public class UserDaoImpl implements IUserDao {

  @Override
  public void save(User user) {
    HiberanteUtils.getSession().saveOrUpdate(user);
  }

  @Override
  public User findByKey(Long id) {
    return (User) HiberanteUtils.getSession().get(User.class, id);
  }

}
