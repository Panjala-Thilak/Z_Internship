package Assignment5.singleton;

public class Sample2 {
    String stringVariable;
    public static Sample2 method(String s)
    {
        Sample2 sample2=new Sample2();
        sample2.stringVariable=s;
        return sample2;
    }
    public void printString()
    {
        System.out.println(stringVariable);
    }
}
