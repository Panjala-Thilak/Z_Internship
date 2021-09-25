package com.zemoso.aopdemo.dao;

import com.zemoso.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    //add a new method to find Accounts
    public List<Account> findAccounts(boolean tripWire){

        if(tripWire)
        {
            throw new RuntimeException("Here is your Exception!!");
        }
        List<Account> myAccounts=new ArrayList<>();
        Account temp1=new Account("nani","diamond");
        Account temp2=new Account("nisanth","gold");
        Account temp3=new Account("thanuja","silver");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }


    public void addAccount(Account account,boolean flag)
    {
        System.out.println(getClass()+": Doing my db work: adding an account\n");
    }

    public boolean doWork()
    {
        System.out.println(getClass()+": doWork()\n");
        return false;
    }

    public String getName() {
        System.out.println("Inside the getName() method");
        return name;
    }

    public void setName(String name) {
        System.out.println("Inside the setName() method");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("Inside the getServiceCode() method");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("Inside the setServiceCode() method");
        this.serviceCode = serviceCode;
    }


}
