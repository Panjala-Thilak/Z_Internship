package com.soliddemo;

import java.util.HashMap;

public class NumbersInWords extends Numbers{
    HashMap<Integer,String> map=new HashMap<>();
    NumbersInWords()
    {
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(4,"Four");
        map.put(5,"Five");
    }
    public void printNumbers()
    {
        for(int number=1;number<=5;number++) {
            System.out.print(map.get(number) + "    ");
        }
        System.out.println();
    }
}
