package com.soliddemo;

public class Numbers implements INumbers{
    @Override
    public void printNumbers() {
        for(int number=1;number<=5;number++) {
            System.out.print(number + "   ");
        }
        System.out.println();
    }
}
