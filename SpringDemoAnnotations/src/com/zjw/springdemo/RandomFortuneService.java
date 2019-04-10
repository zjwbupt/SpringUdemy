package com.zjw.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
    //create an array of Strings
    public String[] data = {
            "Beware of the wolf in sheep`s clothing",
            "iligence is the mother of good luck",
    };

    private Random myRandom = new Random();


    @Override
    public String getFortune() {
        int index = myRandom.nextInt(data.length);
        String theFortune = data[index];

        return theFortune;
    }
}
