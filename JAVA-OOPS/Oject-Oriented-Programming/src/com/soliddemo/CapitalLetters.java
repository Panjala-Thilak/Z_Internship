package com.soliddemo;

import java.util.ArrayList;
import java.util.List;

public class CapitalLetters implements ICapitalLetters{
    List<Character> capitalLetters=new ArrayList<>();
    CapitalLetters()
    {
        for(int i=65;i<=90;i++) {
            capitalLetters.add((char) i);
        }
    }
    public void getCapitalLetters()
    {
        for (int i=0;i< capitalLetters.size();i++)
        {
            System.out.print(capitalLetters.get(i)+"    ");
        }
        System.out.println();
    }
}
