package com.jege.spring.transaction.util;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * 保证在同一次的请求场景中，获取的都是同一个Session，从而正确处理事务
 *
 */
public class HiberanteUtils {
  // 静态SessionFactory
  private static SessionFactory sessionFactory;
  // 线程局部变量:当前线程里面存储一个局部变量Session,可以在当前线程的任意位置取出来,必须是同一个对象
  private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

  static {
    try {
      Configuration configuration = new Configuration();
      configuration.configure();
      sessionFactory = configuration.buildSessionFactory();
    } catch (Exception e) {
      throw new RuntimeException("HibernateUtils:" + e.getMessage());
    }
  }

  // 静态方法:获取Session
  public static Session getSession() {
    // 1.从线程局部变量获取session
    Session session = threadLocal.get();
    // 2.判断session为null,是否已经关闭
    if (session == null || !session.isOpen()) {
      // 3.重新获取
      session = sessionFactory.openSession();
      // 放入线程局部变量
      threadLocal.set(session);
    }
    // 返回局部变量的session
    return session;
  }

  // 静态方法:关闭Session
  public static void closeSession() {
    // 1.从线程局部变量获取session
    Session session = threadLocal.get();
    // 2.判断session不为null并且处于打开状态
    if (session != null && session.isOpen()) {
      // 3.关闭
      session.close();
      // 清空线程局部变量
      threadLocal.remove();
    }
  }
}
