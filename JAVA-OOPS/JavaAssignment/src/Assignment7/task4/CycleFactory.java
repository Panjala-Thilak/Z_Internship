package Assignment7.task4;

public class CycleFactory {
    public Cycle getType(String type)
    {
        if(type==null) return null;
        if(type.equalsIgnoreCase("Unicycle"))
            return new Unicycle();
        if(type.equalsIgnoreCase("Bicycle"))
            return new Bicycle();
        if(type.equalsIgnoreCase("Tricycle"))
            return new Tricycle();
        return null;
    }
}
