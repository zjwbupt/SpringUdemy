package com.zjw.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //we add all of related advice for logging

    //Before advice
    @Before("execution(* add*(com.zjw.aopdemo.entity.Account, ..))")
//    @Before("execution(public void updateAccount())")
    public void beforeAddAccountAdvice(){

        System.out.println("\n======>>> Executing @Before advice on method");
    }
}
