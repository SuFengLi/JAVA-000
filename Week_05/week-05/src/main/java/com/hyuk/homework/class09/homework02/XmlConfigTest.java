package com.hyuk.homework.class09.homework02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : Hyuk
 * @description : XmlConfigTest
 * @date : 2020/11/18 5:55 下午
 */
public class XmlConfigTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car = (Car)applicationContext.getBean("benzCar");
        System.out.println(car.getName());

    }
}
