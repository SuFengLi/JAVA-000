package com.hyuk.homework.class09.homework02;

import lombok.Data;

/**
 * @author : Hyuk
 * @description : Car
 * @date : 2020/11/18 5:38 下午
 */
@Data
public class Car {

    private String name;

    public Car() {}

    public Car(String name) { this.name = name; }
}
