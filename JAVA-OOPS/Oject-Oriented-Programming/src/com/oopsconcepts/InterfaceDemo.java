package com.oopsconcepts;

interface InterfaceExample {
    static final String a="Static Variable";
    public void method1();
    public int method2();
    public static void method3(){
        System.out.println("Method 3");
    };
    default int method4()
    {
        method5();
        return 4;
    }
    private void method5()
    {
        System.out.println("Private method method 5");
    }
}

class InterfaceDemo implements InterfaceExample
{
    @Override
    public int method2() {
        System.out.println("THis is method 2");
        return 2;
    }

    @Override
    public void method1() {
        System.out.println("This is method 1");
    }

    public static void main(String[] args) {
        InterfaceExample interfaceobject;
        InterfaceDemo object=new InterfaceDemo();
        object.method1();
        object.method2();
        InterfaceExample.method3();
        System.out.println(object.method4());

    }
}