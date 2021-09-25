package Assignment5.main;

import Assignment5.data.Sample1;
import Assignment5.singleton.Sample2;

public class Test {
    public static void main(String[] args) {
        Sample1 sample1=new Sample1();
        sample1.printVariables();
        //sample1.printLocalVariables(); Variables must be initialized before using them.
        Sample2 obj=Sample2.method("Hello");
        obj.printString();
    }
}
