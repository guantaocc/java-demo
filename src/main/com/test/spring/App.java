package com.test.spring;


import com.test.spring.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    User user = ctx.getBean(User.class);

}
