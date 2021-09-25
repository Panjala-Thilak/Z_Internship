package com.zemoso.aopdemo;

import com.zemoso.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {
         AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);

        List<Account> accounts=null;
        try
        {
            boolean tripWire=true;
            accounts=accountDAO.findAccounts(tripWire);

        }
        catch (Exception exc){
            System.out.println("\n\n Main program...caught exception : "+exc);
        }

        System.out.println("\n\n Main program : AfterThrowingDemo");
        System.out.println("------");
        System.out.println(accounts);
        System.out.println();
        context.close();
    }

}
