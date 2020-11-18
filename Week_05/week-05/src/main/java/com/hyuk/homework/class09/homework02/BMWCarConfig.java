package com.hyuk.homework.class09.homework02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Hyuk
 * @description : BMWCarConfig
 * @date : 2020/11/18 6:11 下午
 */
@Configuration
public class BMWCarConfig {

    @Bean
    public Car bmwCar() {
        return new BMWCar();
    }
}
