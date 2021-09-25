package designpatterns.creational.prototype;

public abstract class Car implements Cloneable {

    private String carName;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public abstract void modelName();

    public Car makeCopy()
    {
        System.out.println("Car is being made");
        Car carObject=null;
        try
        {
            carObject=(Car) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return carObject;
    }
}