package com.oopsconcepts;
class House
{
    private Kitchen kicthen;
    public House()
    {
        kicthen=new Kitchen();
        kicthen.setFood("Burger");
    }
    public String getFood()
    {
        return kicthen.getFood();
    }
}
class Kitchen
{
    private String food;

    public void setFood(String food) {
        this.food = food;
    }

    public String getFood() {
        return food;
    }
}
public class CompositionDemo {
    public static void main(String[] args) {
        House house=new House();
        System.out.println(house.getFood());
    }
}
