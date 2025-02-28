package com.test.spring.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕aop接收器
 */
public class MyMethodAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 执行目标的核心功能
        System.out.println("before invoke");
        // 结果向上传递
        Object ret = methodInvocation.proceed();
        System.out.println("after invoke");
        return ret;
    }
}
