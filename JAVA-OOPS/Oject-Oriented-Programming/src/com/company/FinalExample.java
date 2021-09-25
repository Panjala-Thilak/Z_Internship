package com.company;
class FinalClass{
    final int a=50;
    public final void method()
    {
        System.out.println("Final Method");
    }
}
public class FinalExample extends FinalClass
{
    /*
    public void method()
    {
        System.out.println("Child Class method");
    }
     */
    public static void main(String[] args) {
        FinalClass finalObject=new FinalClass();
        //finalObject.a=20;
        System.out.println(finalObject.a);
        finalObject.method();
    }
}
