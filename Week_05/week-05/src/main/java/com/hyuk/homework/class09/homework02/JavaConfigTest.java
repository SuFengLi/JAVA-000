package com.hyuk.homework.class09.homework02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Hyuk
 * @description : JavaConfigTest
 * @date : 2020/11/18 6:12 下午
 */
public class JavaConfigTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BMWCarConfig.class);
        Car car = (Car)applicationContext.getBean("bmwCar");
        System.out.println(car.getName());
    }
}
