package com.oopsconcepts;

import java.util.ArrayList;

interface Mobile
{
    public void calling(String number);
    public void sendMessage(String message);
}
abstract class Moilee
{
    private ArrayList<String> contacts=new ArrayList<>();
    abstract void calling(String number);
    abstract void sendingMessage(String message);
    public void addContact(String number)
    {
        contacts.add(number);
    }
}
class Apple implements Mobile
{
    private ArrayList<String> contacts=new ArrayList<>();
    public void addContacts(String number)
    {
        contacts.add(number);
    }
    @Override
    public void calling(String number) {
        System.out.println("calling ......"+number);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Message....."+message);
    }
}

class Vivo extends Moilee
{
    @Override
    void calling(String number) {
        System.out.println("calling from Vivo...."+number);
    }

    @Override
    void sendingMessage(String message) {
        System.out.println("sending message from Vivo..."+message);
    }
}
public class AbstractionDemo {
    public static void main(String[] args) {
        Apple myPhone=new Apple();
        myPhone.calling("9573056206");
        myPhone.sendMessage("Hello!!!!");
        myPhone.addContacts("9573056206");

        Vivo myNewPhone=new Vivo();
        myNewPhone.addContact("9182073210");
        myNewPhone.calling("9182073210");
        myNewPhone.sendingMessage("This is my new phone");
    }
}
