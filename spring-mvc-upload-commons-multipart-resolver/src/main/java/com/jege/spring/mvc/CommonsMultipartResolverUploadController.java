package com.jege.spring.mvc;

import java.io.File;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
/**
 * @author JE哥
 * @email 1272434821@qq.com
 * @description:上传控制器类
 */
@Controller
public class CommonsMultipartResolverUploadController {

  @RequestMapping(value = "/upload", method = RequestMethod.GET)
  public String uploadGet() {
    System.out.println("先以get的请求方式显示上传页面");
    return "upload";
  }

  // 简单改变上传文件的名字
  int i = 0;

  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  public String uploadPost(HttpServletRequest request) throws Exception {
    System.out.println("在以post请求方式处理上传的请求");

    // 记录开始上传文件的时间
    long startTime = System.currentTimeMillis();

    String webapp = request.getServletContext().getRealPath("/uploadFile");
    System.out.println("上传文件保存到服务器webapp的路径:" + webapp);

    // 存放文件的路径
    File deskFile = new File(webapp, "eclipse.zip");
    System.out.println("上传文件存放的最终路径：" + deskFile.getAbsolutePath());

    // 将当前上下文初始化给 CommonsMutipartResolver:配置上传文件解析器
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
    // 检查form中是否有enctype="multipart/form-data"，即是是否有文件上传
    if (multipartResolver.isMultipart(request)) {
      // 将request变成多部件MultipartHttpServletRequest
      MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
      // 获取multiRequest 中所有的文件名
      Iterator<String> iter = multiRequest.getFileNames();
      // 遍历所有文件
      while (iter.hasNext()) {
	MultipartFile file = multiRequest.getFile(iter.next());
	if (file != null) {// 处理上传
	  file.transferTo(deskFile);
	}
      }
    }

    // 添加提示信息
    request.setAttribute("msg", "上传成功");

    // 记录结束上传文件的时间
    long endTime = System.currentTimeMillis();
    System.out.println("上传究竟用了多少时间：" + String.valueOf(endTime - startTime) + "ms");

    // 直接转发到upload.jsp
    return "upload";
  }

}
