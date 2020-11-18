package com.hyuk.homework.class09.homework02;

import org.springframework.stereotype.Component;

/**
 * @author : Hyuk
 * @description : AudiCar
 * @date : 2020/11/18 7:03 下午
 */
@Component(value = "audiCar")
public class AudiCar extends Car{

    public AudiCar() { super("奥迪"); }
}
