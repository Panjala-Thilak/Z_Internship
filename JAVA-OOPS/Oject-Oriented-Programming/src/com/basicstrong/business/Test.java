package com.basicstrong.business;

import com.company.AbstractDemo;
import com.company.ProtectedClass;
import com.company.PublicClass;

public class Test extends ProtectedClass{
    public static void main(String[] args) {
        PublicClass publicClass=new PublicClass();
        publicClass.method();
        Test demo=new Test();
        demo.method();
    }
}
