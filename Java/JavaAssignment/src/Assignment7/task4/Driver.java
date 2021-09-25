package Assignment7.task4;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the cycle type");
        String cycle=scanner.next();
        CycleFactory factory=new CycleFactory();
        Cycle object=factory.getType(cycle);
        object.balance();
    }
}
