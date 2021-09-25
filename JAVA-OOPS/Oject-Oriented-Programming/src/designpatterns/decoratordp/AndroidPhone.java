package designpatterns.decoratordp;

public class AndroidPhone extends PhoneDecorator{
    AndroidPhone(Phone phone) {
        super(phone);
    }
    @Override
    public void printModel()
    {
        super.printModel();
        System.out.println("Adding Features of Android");
    }
}
