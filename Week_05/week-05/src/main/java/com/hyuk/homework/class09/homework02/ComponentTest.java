package com.hyuk.homework.class09.homework02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Hyuk
 * @description : ComponentTest
 * @date : 2020/11/18 7:05 下午
 */
public class ComponentTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AudiCar.class);
        Car car = (Car) applicationContext.getBean("audiCar");
        System.out.println(car.getName());
    }
}
