package com.jege.spring.transaction.util;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
/**
 * 
 * 类似spring的事务管理器
 *
 */
public class TransactionManager {

  // 切入点
  @Pointcut("execution(* com.jege.spring.transaction.service.I*Service.*(..))")
  public void pointcutId() {

  }

  // 环绕方法：替换上面的4个方法
  // 添加一个ProceedingJoinPoint参数，此参数由spring自动注入
  @Around(value = "pointcutId()")
  public Object around(ProceedingJoinPoint joinPoint) {
    Object resultObject = null;
    try {
      String methodName = joinPoint.getSignature().getName();
      System.out.println("调用的方法名：" + methodName);
      System.out.println("调用的方法的参数：" + Arrays.toString(joinPoint.getArgs()));
      System.out.println("调用目标对象：" + joinPoint.getTarget());

      // 以get，find开头的方法都不需要事务处理
      if (methodName.startsWith("get") || methodName.startsWith("find")) {
	resultObject = joinPoint.proceed();
      } else {
	System.out.println("开始事务");
	HiberanteUtils.getSession().beginTransaction();
	// 调用真实主题角色的方法
	resultObject = joinPoint.proceed();
	System.out.println("提交事务");
	HiberanteUtils.getSession().getTransaction().commit();
      }
    } catch (Throwable e) {
      System.out.println("出现异常");
      HiberanteUtils.getSession().getTransaction().rollback();
    } finally {
      System.out.println("关闭资源");
      HiberanteUtils.closeSession();
    }
    return resultObject;
  }
}
