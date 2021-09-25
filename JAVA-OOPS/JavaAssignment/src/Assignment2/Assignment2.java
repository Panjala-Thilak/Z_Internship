package Assignment2;

import java.util.HashMap;
import java.util.Scanner;
// Time Complexity=o(n) Space Complexity=o(1)
public class Assignment2 {
    public boolean checkAlphabets(String inputString)
    {
        if(inputString.length()<26)
            return false;
        HashMap<Character,Integer> map=new HashMap<>();
        inputString=inputString.toLowerCase();
        for(int i=0;i<inputString.length();i++)
        {
            if(inputString.charAt(i)>=97 && inputString.charAt(i)<=122) {
                if (!map.containsKey(inputString.charAt(i))) {
                    map.put(inputString.charAt(i), 1);
                }
            }
        }
        if(map.size()==26)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Assignment2 assignment2=new Assignment2();
        while(true) {
            System.out.println("Enter the input String or 0 to exit");
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.next();
            if(inputString.equals("0"))
                break;
            if (assignment2.checkAlphabets(inputString)) {
                System.out.println(inputString + " contains all alphabets");
            } else {
                System.out.println(inputString + " does not contains all alphabets");
            }
        }
    }
}
