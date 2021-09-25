package com.oopsconcepts;
// Data Hiding
import java.util.Scanner;

class BankAccount
{
    private  double balance=1000000;
    private String username="Thilak";
    private String password="Thilak";

    public double getBalance(String username,String password) {
        if(this.username.equals(username) && this.password.equals(password))
            return balance;
        else {
            System.out.println("Invalid username or password");
            return 0;
        }
    }
}
public class AccessAccount {
    public static void main(String[] args) {
        BankAccount account=new BankAccount();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the username");
        String username= scanner.nextLine();
        System.out.println("Enter the password");
        String password=scanner.nextLine();
        System.out.println(account.getBalance(username,password));

    }
}
