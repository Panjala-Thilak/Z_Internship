package designpatterns.factorymethod;

class Diesel extends Fuel
{
    @Override
    void getRate() {
        rate = 90;
    }
}
