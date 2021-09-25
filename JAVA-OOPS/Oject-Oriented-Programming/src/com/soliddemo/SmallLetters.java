package com.soliddemo;

import java.util.ArrayList;
import java.util.List;

public class SmallLetters implements ISmallLetters{
    List<Character> smallLetters=new ArrayList<>();
    SmallLetters()
    {
        for(int i=97;i<=122;i++) {
            smallLetters.add((char) i);
        }
    }
    public void getSmallLetters()
    {
        for (int i=0;i< smallLetters.size();i++)
        {
            System.out.print(smallLetters.get(i)+"    ");
        }
        System.out.println();
    }
}
