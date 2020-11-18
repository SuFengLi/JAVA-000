package com.hyuk.homework.class09.homework01;

/**
 * @author : Hyuk
 * @description : JdkAgentTest
 * @date : 2020/11/18 5:34 下午
 */
public class JdkAgentTest {

    public static void main(String[] args) {
        JdkAgent jdkAgent = new JdkAgent();
        jdkAgent.getInstance(new Student()).findJob();
    }
}
