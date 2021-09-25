package Assignment6;

public class ObjectExample {
    ObjectExample(String s)
    {
        System.out.println(s);
    }

    public static void main(String[] args) {
        ObjectExample list[]=new ObjectExample[10];
        //No Constructor call made when we initialize the array of objects
        for(int i=0;i<10;i++)
            list[i]=new ObjectExample(Character.toString(i+'0'));
    }
}
