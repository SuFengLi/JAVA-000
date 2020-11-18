package com.hyuk.homework.class09.homework01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : Hyuk
 * @description : JdkAgent
 * @date : 2020/11/18 5:29 下午
 */
public class JdkAgent implements InvocationHandler {

    private Person person;

    public Person getInstance(Person person) {
        this.person = person;
        Class<?> clazz = person.getClass();
        return (Person)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.person, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("找到工作了, 真开心啊");
    }

    private void before() {
        System.out.println("来到北京人才市场");
    }


}
