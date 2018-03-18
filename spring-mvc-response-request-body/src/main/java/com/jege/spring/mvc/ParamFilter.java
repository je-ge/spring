package com.jege.spring.mvc;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @author JE哥
 * @email 1272434821@qq.com
 * @description:
 */
@WebFilter(urlPatterns = "/*")
public class ParamFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // TODO Auto-generated method stub

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    Map<String, String[]> parameterMap = request.getParameterMap();
    for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
      System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue()));
    }
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    // TODO Auto-generated method stub

  }

}
