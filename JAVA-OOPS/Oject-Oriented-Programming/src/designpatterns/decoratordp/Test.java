package designpatterns.decoratordp;

public class Test {
    public static void main(String[] args) {
        Phone phone = new AndroidPhone(new BasicPhone());
        phone.printModel();
        Phone phone1 = new IPhone(phone);
        phone1.printModel();
    }
}
