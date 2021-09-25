package Assignment10;

import java.util.Scanner;


public class SList<T> {

    static Link head;

    private static SListIterator iterator(Link head){

        SListIterator iterator = new SListIterator(head);
        return iterator;

    }

    public static void main(String args[]){

        SList sl = new SList();
        head = new Link("Head Link",null);
        SListIterator iterator = iterator(head);

        while(true){
            System.out.println("Press 1 to insert");
            System.out.println("Press 2 to remove");
            System.out.println("Press 3 to print the list");
            System.out.println("Press -1 to exit");

            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            if(i == -1){
                break;
            }
            switch (i)
            {
                case 1:
                    System.out.println("Enter the data to be inserted");
                    iterator.insert(scanner.next());
                    break;
                case 2:
                    iterator.remove();
                    break;
                case 3:
                    iterator.iterate();
                    break;
                default:
                    System.out.println("Invalid respone!");
            }
        }

    }

}