package com.jmypackage1.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyTest implements InvocationHandler {
    private Object obj;
    public ProxyTest(Object obj){
        this.obj=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      String strs= (String) method.invoke(proxy,args);
        strs.toUpperCase();

        return strs;
    }
}
