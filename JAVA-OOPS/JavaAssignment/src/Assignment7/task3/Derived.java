package Assignment7.task3;

public class Derived extends Base implements Interface4{

    @Override
    public void Interface1Method1() {
        System.out.println("Interface1 Method1");
    }

    @Override
    public void Interface1Method2() {
        System.out.println("Interface1 Method2");
    }

    @Override
    public void Interface2Method1() {
        System.out.println("Interface2 Method1");
    }

    @Override
    public void Interface2Method2() {
        System.out.println("Interface2 Method2");
    }

    @Override
    public void Interface3Method1() {
        System.out.println("Interface3 Method1");
    }

    @Override
    public void Interface3Method2() {
        System.out.println("Interface3 Method2");
    }

    @Override
    public void Interface4Method() {
        System.out.println("Interface4 Method");
    }
    public void method6(Interface1 I)
    {
        I.Interface1Method1();
        I.Interface1Method2();
    }
    public void method7(Interface2 I)
    {
        I.Interface2Method1();
        I.Interface2Method2();
    }
    public void method8(Interface3 I)
    {
        I.Interface3Method1();
        I.Interface3Method2();
    }
    public void method9(Interface4 I)
    {
       I.Interface1Method1();
       I.Interface1Method2();
       I.Interface2Method1();
       I.Interface1Method2();
       I.Interface3Method1();
       I.Interface3Method2();
       I.Interface4Method();
    }
}
