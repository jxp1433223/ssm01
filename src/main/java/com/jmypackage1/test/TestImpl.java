package com.jmypackage1.test;
/*要被增强的对象-----目标对象*/
public class TestImpl implements ITest {
    @Override
    public String getStr() {
        /*返回大写形式*/
        return "abcd";
    }
}
