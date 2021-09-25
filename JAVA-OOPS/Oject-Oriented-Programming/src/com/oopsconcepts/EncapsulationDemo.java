package com.oopsconcepts;
class Account
{
    private double balance;

    public void setBalance(double balance)
    {
        //validation
        this.balance=balance;

    }

    public double getBalance()
    {
        //validation
        return balance;
    }
}
public class EncapsulationDemo {
    public static void main(String[] args) {
        Account account=new Account();
        account.setBalance(1000);
        System.out.println(account.getBalance());
    }
}
