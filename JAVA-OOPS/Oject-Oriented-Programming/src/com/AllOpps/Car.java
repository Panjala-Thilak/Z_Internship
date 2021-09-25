package com.AllOpps;
class Vehicle
{
    public void startEngine() {
        System.out.println("Engine is starting...");
    }

}

public class Car extends Vehicle {
    public void seater()
    {
        System.out.println("It consists of 4 Seats");
    }
}

class Test
{
    public static void main(String[] args) {
        Car myCar=new Car();
        myCar.startEngine();
        myCar.seater();
    }
}
