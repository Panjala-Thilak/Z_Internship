package com.soliddemo;

public class Dog extends AnimalsSuitableForPetting{
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }

    @Override
    public void petting() {
        System.out.println("Dog is used as a pet animals");
    }
}
