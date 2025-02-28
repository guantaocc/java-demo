package com.test.spring.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;


/**
 * 前置方法
 */

public class MyBeforeAdvice implements MethodBeforeAdvice {
    /**
     *
     * @param method 当前执行的方法
     * @param args 方法的对象
     * @param o 目标对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object o) throws Throwable {
        System.out.println("method" + method.getName() + "args" + args.length + "==" + o.toString());
    }
}
