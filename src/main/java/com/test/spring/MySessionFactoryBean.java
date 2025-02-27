package com.test.spring;

import org.springframework.beans.factory.FactoryBean;

public class MySessionFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return null;
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
