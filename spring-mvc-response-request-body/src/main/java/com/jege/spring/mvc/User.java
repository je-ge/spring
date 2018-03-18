package com.jege.spring.mvc;

/**
 * @author JE哥
 * @email 1272434821@qq.com
 * @description:模型对象
 */
public class User {
  private Long id;
  private String name;

  public User() {
    super();
  }

  public User(Long id, String name) {
    super();
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + "]";
  }

}
