package com.zjw.aopdemo;

import com.zjw.aopdemo.dao.AccountDAO;
import com.zjw.aopdemo.dao.MembershipDAO;
import com.zjw.aopdemo.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        //call the business method
        Account myAccount = new Account();
        theAccountDAO.addAccount(myAccount,true);
        theAccountDAO.addAccount(myAccount);

        //check again
        System.out.println("\n Check Again");
        theMembershipDAO.addAccount();

        //close the context
        context.close();
    }
}
