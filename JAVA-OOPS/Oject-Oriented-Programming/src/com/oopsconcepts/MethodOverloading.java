package com.oopsconcepts;
//same name but different argument list
class Multiplication
{
    public void product(int a,int b) {
        System.out.println("Product is: " + a*b);
    }
    public void product(int a,int b,int c) {
        System.out.println("Product is: " + a*b*c);
    }
    public void product(double a,double b) {
        System.out.println("Product is: " + a*b);
    }
}
public class MethodOverloading {
    public static void main(String[] args) {
        Multiplication multiplication=new Multiplication();
        multiplication.product(10,20);
        multiplication.product(10,20,20);
        multiplication.product(10.25,20.20);
        multiplication.product('d','a');// a-->97 d-->100
    }
}
//byte-->short-->int --> long --> float -->double
//char --> int --> long --> float -->double