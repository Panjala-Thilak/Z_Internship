//Factory Method Design Pattern
//subclasses decide which classes to instantiate
package abstractfactorymethod;
import java.util.Scanner;


public class BillGeneration {
    public static void main(String[] args) {

        GetFuelFactory fuelFactory=new GetFuelFactory();
        System.out.println("Enter the fuel Type:");
        Scanner scanner=new Scanner(System.in);
        String fuelType=scanner.next();

        Fuel fuel=fuelFactory.getFuel(fuelType);

        System.out.println("Enter the number of liters :");
        double liters=scanner.nextDouble();
        System.out.println("The Bill for the "+fuelType+" of "+liters+ " liters is:");

        fuel.getRate();
        fuel.calculateBill(liters);

    }

}
