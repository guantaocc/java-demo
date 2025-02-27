package com.hello.controller;


import com.sun.deploy.net.HttpResponse;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/index")
    public String inf(){
        return "index";
    }
    @RequestMapping("/test")
    public String upload(MultipartFile source, String username, HttpSession session) throws IOException {
        String originFilename = source.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String ext = FilenameUtils.getExtension(originFilename);
        String filename = uuid + "." + ext;
        // 文件类型
        String type = source.getContentType();
        // 获取 upload_file的磁盘路径 E:\\apache-tomcat-8.5.37\\webapps\ROOT\\upload_file
        String realPath = session.getServletContext().getRealPath("/upload_file");
        System.out.println(realPath);
        // 将上传文件放入磁盘
        source.transferTo(new File(realPath + "\\"  + filename));
        return "result";
    }

    @RequestMapping("file")
    public String file(){
        return "file";
    }

    @RequestMapping("/download")
    public void download(String name, HttpSession session, HttpServletResponse response) throws IOException {
        System.out.println("download");
        String realPath = session.getServletContext().getRealPath("/upload_file");
        String path = realPath + File.separator + name;
        response.setHeader("content-disposition", "attachment;filename="+name);
        IOUtils.copy(new FileInputStream(path), response.getOutputStream());
    }
}
