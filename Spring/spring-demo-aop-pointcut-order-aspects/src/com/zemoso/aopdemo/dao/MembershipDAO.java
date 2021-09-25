package com.zemoso.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public boolean addMember()
    {
        System.out.println(getClass()+": Doing my db work: adding a membership account");
        return true;
    }

    public void play()
    {
        System.out.println("I am playing cricket!!");
    }
}
