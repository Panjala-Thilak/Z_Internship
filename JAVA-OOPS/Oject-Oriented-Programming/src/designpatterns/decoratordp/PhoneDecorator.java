package designpatterns.decoratordp;

public class PhoneDecorator implements Phone{
    public Phone phone;
    PhoneDecorator(Phone phone)
    {
        this.phone=phone;
    }
    @Override
    public void printModel() {
        this.phone.printModel();
    }
}
