package com.zjw.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addAccount(){
        System.out.println(getClass() + ": Doing Stuff: Adding a membership account");
    }
}
