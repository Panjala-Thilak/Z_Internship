package com.zemoso.aopdemo.dao;

import com.zemoso.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

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
