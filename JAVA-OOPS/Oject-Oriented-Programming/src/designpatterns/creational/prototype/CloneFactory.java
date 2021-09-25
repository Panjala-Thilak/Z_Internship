package designpatterns.creational.prototype;

public class CloneFactory {
    public Car getClone(Car vehicle)
    {
        return vehicle.makeCopy();
    }
}
