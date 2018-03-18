package com.jege.spring.mvc;

/**
 * @author JE哥
 * @email 1272434821@qq.com
 * @description:模型类
 */
public class User {
  private Integer id;
  private String name;
  private String password;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
  }

}
