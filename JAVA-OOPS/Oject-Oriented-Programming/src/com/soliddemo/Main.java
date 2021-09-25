package com.soliddemo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ICapitalLetters capitalLetters=new CapitalLetters();
        capitalLetters.getCapitalLetters();
        ISmallLetters smallLetters=new SmallLetters();
        smallLetters.getSmallLetters();

        System.out.println("Enter the Format of Numbers");
        String numberType=scanner.next();
        NumberFactory numberFactory=new NumberFactory();
        Numbers numbers=numberFactory.getNumbers(numberType);
        numbers.printNumbers();

        Dog dog=new Dog();
        dog.sound();
        dog.petting();
        Lion lion=new Lion();
        lion.sound();
        //lion.petting();

        Apple apple=new Apple();
        System.out.println(apple.getColor());
        Orange orange=new Orange();
        System.out.println(orange.getColor());


    }
}
