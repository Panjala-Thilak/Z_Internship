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
        account.setName("Thilak");
        account.setLevel("Platinum");

        accountDAO.addAccount(account,true);

        accountDAO.doWork();


        //call the accountdao getter/setter methods
        accountDAO.setName("abc");
        accountDAO.setServiceCode("gold");

        String name=accountDAO.getName();
        String service=accountDAO.getServiceCode();

        System.out.println("\nExecuting membershipDAO methods\n");

        membershipDAO.addMember();

        membershipDAO.play();

        context.close();
    }

}
