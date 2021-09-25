package designpatterns.creational.prototype;

public class TestCloning {
    public static void main(String[] args) {
        CloneFactory vehicleFactory=new CloneFactory();
        Maruthi maruthi=new Maruthi();
        System.out.println(maruthi.getCarName());
        Car clonedCar=vehicleFactory.getClone(maruthi);
        System.out.println("Car Hashcode :" + System.identityHashCode(maruthi));
        System.out.println("ClonedCar Hashcode :"+ System.identityHashCode(clonedCar));
    }
}
