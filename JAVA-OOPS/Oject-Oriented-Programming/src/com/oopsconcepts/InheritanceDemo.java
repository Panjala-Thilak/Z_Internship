package com.oopsconcepts;
//Multilevel
class A
{
    A()
    {
        System.out.println("class A");
    }

}
class B extends A
{
    B()
    {
        System.out.println("Class B");
    }
}
class C extends B
{
    C()
    {
        System.out.println("Class C");
    }
}
public class InheritanceDemo {
    public static void main(String[] args) {
        C c=new C();
    }
}
