package com.zemoso.aopdemo;

import com.zemoso.aopdemo.dao.AccountDAO;
import com.zemoso.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
         AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);

        MembershipDAO membershipDAO=context.getBean("membershipDAO",MembershipDAO.class);

        Account account=new Account();
        accountDAO.addAccount(account,true);

        accountDAO.doWork();

        System.out.println("\nExecuting membershipDAO methods\n");

        membershipDAO.addMember();

        membershipDAO.play();

        context.close();
    }

}
