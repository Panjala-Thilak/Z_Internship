package Assignment6;

public class ConstructorChaining {
    ConstructorChaining()
    {
        this("Hello");
        System.out.println("This is Default Constructor");
    }
    ConstructorChaining(String string)
    {
        System.out.println("This is parameterized Constructor "+string);
    }

    public static void main(String[] args) {
        ConstructorChaining object=new ConstructorChaining();

    }
}

