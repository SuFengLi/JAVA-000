package com.hyuk.homework.class09.homework02;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Hyuk
 * @description : OtherTest
 * @date : 2020/11/18 7:07 下午
 */
public class OtherTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 1、AnnotationConfigApplicationContext.registerBean
        applicationContext.registerBean("lexus", Car.class, "雷克萨斯");
        applicationContext.refresh();
        Car car = (Car)applicationContext.getBean("lexus");
        System.out.println(car.getName());


        // 2、BeanFactory.registerSingleton
        Car ferrari = new Car("法拉利");
        applicationContext.getBeanFactory().registerSingleton("ferrari", ferrari);
        System.out.println(applicationContext.getBean("ferrari", Car.class).getName());

        // 3、registerBeandefinition
        BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Car.class)
                .addPropertyValue("name", "迈凯伦")
                .getBeanDefinition();
        applicationContext.registerBeanDefinition("mclaren", beanDefinition);
        System.out.println(applicationContext.getBean("mclaren", Car.class).getName());

    }
}
