package com.test.spring.advice;

import org.springframework.aop.ThrowsAdvice;
public class MyThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception ex){
        System.out.println("出现异常" + ex.getMessage());
    }
}
