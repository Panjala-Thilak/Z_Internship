package com.soliddemo;

import java.util.HashMap;

public class NumbersInRoman extends Numbers{
    HashMap<Integer,String> map=new HashMap<>();
    NumbersInRoman()
    {
        map.put(1,"I");
        map.put(2,"II");
        map.put(3,"III");
        map.put(4,"IV");
        map.put(5,"V");
    }
    public void printNumbers()
    {
        for(int number=1;number<=5;number++) {
            System.out.print(map.get(number) + "    ");
        }
        System.out.println();
    }
}
