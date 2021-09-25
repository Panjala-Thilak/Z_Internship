package com.zemoso.aopdemo;

import com.zemoso.aopdemo.dao.AccountDAO;
import com.zemoso.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {

    public static void main(String[] args) {
         AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);

        List<Account> accounts=accountDAO.findAccounts(false);

        System.out.println("\n\n Main program : AfterReturningDemo");
        System.out.println("------");
        System.out.println(accounts);
        System.out.println();
        context.close();
    }

}
