package com.company;
class Fan
{
    private boolean isOn;
    public static int staticVar;
    Fan() {
        System.out.println("Constructor");
    }
    public void turnOn()
    {
        isOn=true;
        System.out.println("Fan is Spinning");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("fan is stopped");
    }
}
public class Demo {
    public static void main(String args[]) {
        Fan myFan = new Fan();
        myFan.turnOn();
        myFan.turnOff();
        Fan yourFan=new Fan();
        myFan.staticVar=4;
        System.out.println(myFan.staticVar);
        System.out.println(yourFan.staticVar);
    }
}
