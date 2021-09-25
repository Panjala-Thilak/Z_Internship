package abstractfactorymethod;

abstract class Fuel {
    protected double rate;
    abstract void getRate();

    public void calculateBill(double liters){
        System.out.println(liters*rate);
    }
}