package com.test.spring;


import com.test.spring.dao.UserDaoImpl;
import com.test.spring.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    @Test
    public void  FactoryBean(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserDaoImpl userImpl = ctx.getBean(UserDaoImpl.class);
        userImpl.insertUser();
        User user = ctx.getBean(User.class);
        System.out.println("=====");
    }

    @Test
    public void setFactoryBean(){

    }

    @Test
    public void springBean(){

    }
}
