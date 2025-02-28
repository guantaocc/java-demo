package com.test.spring.dao;

import com.test.spring.dao.UserServiceImpl;

/**
 * AOP静态代理原理
 * 要和目标保持一致
 * 组成：目标+额外功能
 */

public class UserServiceProxy implements UserService {
    private UserService userService = new UserServiceImpl();

    public void insertUser(){
        System.out.println("执行前切面");
        userService.insertUser();
        System.out.println("执行后切面");
    }
}
