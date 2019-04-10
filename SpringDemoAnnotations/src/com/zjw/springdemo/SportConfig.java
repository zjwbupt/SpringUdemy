package com.zjw.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.zjw.springdemo")
class SportConfig {

    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService(); // inject
    }



    @Bean
    public Coach swimCoach(){
        SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());

        return mySwimCoach;
    }
}
