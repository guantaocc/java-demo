package com.test.spring;


import com.test.spring.dao.UserService;
import com.test.spring.dao.UserServiceImpl;
import com.test.spring.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AppTest {

    /**
     * 测试FactoryBean和xmlPath
     */
    @Test
    public void  FactoryBean(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserServiceImpl userImpl = ctx.getBean(UserServiceImpl.class);
        userImpl.insertUser();
        User user = ctx.getBean(User.class);
        System.out.println("=====");
    }

    /**
     * 测试FactoryBean
     */

    @Test
    public void setFactoryBean(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MySessionFactoryBean sessionFactoryBean = ctx.getBean(MySessionFactoryBean.class);
        System.out.println("========");
    }

    @Test
    public void springBean(){

    }

    /**
     * 测试jdk动态代理
     */
    @Test
    public void invokeProxy(){
        UserService userService = new UserServiceImpl();
        // 注入方法的额外功能
        InvocationHandler in = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 额外功能
                System.out.println("proxys");
                method.invoke(userService, args);
                return null;
            }
        };
        // 代理，组装接口
        UserService proxy = (UserService)Proxy.newProxyInstance(AppTest.class.getClassLoader(), userService.getClass().getInterfaces(), in);
        proxy.insertUser();
    }

    /**
     * 测试cglib动态代理
     */
    @Test
    public void TestDynamicProxy(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println(userService.getClass());
        userService.insertUser();
    }
}
