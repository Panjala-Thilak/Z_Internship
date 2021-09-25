package designpatterns.decoratordp;

public class BasicPhone implements Phone{

    @Override
    public void printModel() {
        System.out.println("Basic Phone");
    }
}
