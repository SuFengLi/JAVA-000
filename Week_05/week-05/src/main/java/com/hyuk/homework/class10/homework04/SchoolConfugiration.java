package com.hyuk.homework.class10.homework04;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hyuk
 * @description : SchoolConfugiration
 * @date : 2020/11/18 10:06 下午
 */
@Configuration
public class SchoolConfugiration {

    @Bean
    @ConditionalOnMissingBean
    public Student student100(){
        Student student = new Student().create();
        student.init();
        return student;
    }

    @Bean
    @ConditionalOnMissingBean
    public School school(){
        return new School();
    }

    @Bean
    @ConditionalOnMissingBean
    public Klass klass(@Qualifier("student100") Student student){
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        Klass klass = new Klass();
        klass.setStudents(studentList);
        return klass;
    }
}
