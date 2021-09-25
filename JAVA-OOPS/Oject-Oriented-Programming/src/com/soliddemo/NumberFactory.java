package com.soliddemo;

public class NumberFactory {
    public Numbers getNumbers(String numberType)
    {
        if(numberType==null)
            return null;
        if (numberType.equalsIgnoreCase("roman"))
        {
            return new NumbersInRoman();
        }
        else if(numberType.equalsIgnoreCase("words"))
        {
            return new NumbersInWords();
        }

        return null;
    }
}
