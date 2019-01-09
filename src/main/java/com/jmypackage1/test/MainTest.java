package com.jmypackage1.test;

import java.lang.reflect.Proxy;

public class MainTest {
    public static void main(String[] args) {
        ITest t=new TestImpl();
        ProxyTest pt=new ProxyTest(t);
       ITest prot=(ITest) Proxy.newProxyInstance(t.getClass().getClassLoader(),t.getClass().getInterfaces(),pt);
        System.out.println(prot.getStr());
    }
}
