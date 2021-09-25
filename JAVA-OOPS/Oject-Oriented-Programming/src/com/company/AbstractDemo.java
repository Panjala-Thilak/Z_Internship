package com.company;
public abstract class AbstractDemo {
    public abstract void method();
    public abstract int getEmployee();
}
class Dept extends AbstractDemo
{
    @Override
    public void method() {
        System.out.println("this is the method");
    }

    @Override
    public int getEmployee() {
        return 100;
    }
}