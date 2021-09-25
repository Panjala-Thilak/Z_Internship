package designpatterns.decoratordp;

public class IPhone extends PhoneDecorator{
    public IPhone(Phone phone) {
        super(phone);
    }
    @Override
    public void printModel()
    {
        super.printModel();
        System.out.println("Adding Features of IPhone");
    }

}
