package com.hello.controller;

import com.hello.controller.Exception.LoginException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/index")
public class HelloController {

    @RequestMapping("/test1")
    public String test1(HttpSession session, HttpServletRequest req, Integer id){
        req.setAttribute("name", "sonssong");
        session.setAttribute("age", 18);
        System.out.println(id);
        return "redirect:/hello/data";
    }

    @RequestMapping("/data")
    public String data1(){
        return "data";
    }

    @RequestMapping("/test2")
    public String test2(String username){
        System.out.println(username);
        return "index";
    }

    @RequestMapping("/json-test")
    @ResponseBody
    public User jsonTest(){
        User user = new User();
        user.setBirth(new Date());
        user.setUsername("xx");
        return user;
    }

    @ResponseBody
    @RequestMapping("/login")
    public User login(Integer id){
        if(id.equals(1)){
            User user = new User();
            user.setBirth(new Date());
            user.setUsername("xx");
            return user;
        } else {
            throw new LoginException("登录异常");
        }
    }

    @RequestMapping("/upload")
    public String upload(){
        return "index";
    }
}
