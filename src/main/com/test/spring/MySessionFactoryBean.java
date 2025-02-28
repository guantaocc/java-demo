package com.test.spring;

import org.springframework.beans.factory.FactoryBean;

public class MySessionFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        Object obj = new Object();
        return obj;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
