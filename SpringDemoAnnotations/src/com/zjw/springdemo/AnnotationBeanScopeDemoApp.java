package com.zjw.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    //load spring config file
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    //retrieve bean from spring container
    Coach theCoach = context.getBean("tennisCoach", Coach.class);

    Coach alphaCoach = context.getBean("tennisCoach", Coach.class);


}
