package com.jmypackage1.test;

import org.springframework.cglib.proxy.Enhancer;

public class TestMain {
    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(CgTest.class);
        enhancer.setCallback(new AgentTset());
        CgTest s=(CgTest) enhancer.create();
        System.out.println(s.getStrs());
    }
}
