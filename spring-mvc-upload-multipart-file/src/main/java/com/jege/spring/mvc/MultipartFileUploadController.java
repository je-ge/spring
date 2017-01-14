package com.jege.spring.mvc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MultipartFileUploadController {

  @RequestMapping(value = "/upload", method = RequestMethod.GET)
  public String uploadGet() {
    System.out.println("先以get的请求方式显示上传页面");
    return "upload";
  }

  int i = 0;// 简单改变上传文件的名字

  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  public String uploadPost(MultipartFile upload, HttpServletRequest request) throws Exception {
    System.out.println("在以post请求方式处理上传的请求");

    if (upload != null) {
      // 记录开始上传文件的时间
      long startTime = System.currentTimeMillis();

      System.out.println("上传文件的名称：" + upload.getOriginalFilename());
      System.out.println("上传文件的类型：" + upload.getContentType());
      System.out.println("上传文件的大小：" + upload.getSize());
      System.out.println("前台jsp提交上传控件的name属性：" + upload.getName());
      System.out.println("获取上传文件的后缀名：" + FilenameUtils.getExtension(upload.getOriginalFilename()));

      String webapp = request.getServletContext().getRealPath("/upload");
      System.out.println("上传文件保存到服务器webapp的路径:" + webapp);

      // 存放文件的路径
      File deskFile = new File(webapp, i++ + upload.getOriginalFilename());
      System.out.println("上传文件存放的最终路径：" + deskFile.getAbsolutePath());

      // 上传文件存放最终路径的父目录不存在，就创建一次
      File parentFile = deskFile.getParentFile();
      if (!parentFile.exists()) {
	parentFile.mkdirs();
      }

      // 方法1：使用commons-io工具包IOUtils类
      // 获取上传文件的流
      InputStream inputStream = upload.getInputStream();
      FileOutputStream output = new FileOutputStream(deskFile);
      // 把上传文件的inputStream拷贝到文件里面
      IOUtils.copy(inputStream, output);
      inputStream.close();
      output.close();

      // 方法2：使用MultipartFile.Transto 来保存上传的文件
      // upload.transferTo(deskFile);

      // 通过测试方法2会快点

      // 添加提示信息
      request.setAttribute("msg", "上传成功");

      // 记录结束上传文件的时间
      long endTime = System.currentTimeMillis();
      System.out.println("上传究竟用了多少时间：" + String.valueOf(endTime - startTime) + "ms");
    }

    // 直接转发到upload.jsp
    return "upload";
  }

}
