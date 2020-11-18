package com.hyuk.homework;

import com.hyuk.homework.class10.homework04.School;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author : Hyuk
 * @description : Bootstrap
 * @date : 2020/11/18 10:13 下午
 */
@SpringBootApplication
public class Bootstrap {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Bootstrap.class, args);
        School school = applicationContext.getBean("school", School.class);
        school.ding();
    }

}
