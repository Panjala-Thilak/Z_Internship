package com.oopsconcepts;
class Vehicle
{
    public void run()
    {
        System.out.println("Vehicle is running.");
    }
}
class Car extends Vehicle
{
    @Override
    public void run() {
        System.out.println("Car is running.");
    }
}
public class MethodOverridingDemo {
    public static void main(String[] args) {
        Vehicle vehicle=new Vehicle();
        vehicle.run();

        Car car=new Car();
        car.run();

        Vehicle vCar=new Car(); // It will call method whose object we are creating
        vCar.run();
    }
}
