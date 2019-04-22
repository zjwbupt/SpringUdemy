package com.zjw.aopdemo.dao;


import com.zjw.aopdemo.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account theAccount, boolean vipFlag){
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public void addAccount(Account theAccount){
        System.out.println("the Single constructor");
    }

}
