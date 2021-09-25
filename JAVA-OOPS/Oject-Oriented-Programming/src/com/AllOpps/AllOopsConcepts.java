package com.AllOpps;

abstract class House
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
    public void garden(String flower)
    {
    }
    public void builtRoom(int length, int breadth) {}

    public void builtRoom(double length, double breadth) {
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
class HouseHolder extends House
{
    @Override
    public void garden(String flower) {
        System.out.println(flower + " plants are planted");
    }

    @Override
    public void builtRoom(int length, int breadth) {
        System.out.println("New room Was built with length "+ length + " breadth " + breadth);
    }

    @Override
    public void builtRoom(double length, double breadth) {
        System.out.println("New room Was built with length "+ length + " breadth " + breadth);
    }
}

public class AllOopsConcepts {
    public static void main(String[] args) {
        HouseHolder householder = new HouseHolder();
        System.out.println(householder.getFood());
        householder.garden("Rose");
        householder.builtRoom(4,5);
        householder.builtRoom(4.5,8.2);
    }
}
