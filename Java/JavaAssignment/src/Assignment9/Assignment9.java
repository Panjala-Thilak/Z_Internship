package Assignment9;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment9 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        String regex="[A-Z].*\\.";//regular expression to check a line starting with a capital letter and ends with a period
        Pattern pattern= Pattern.compile(regex);
        Matcher match=pattern.matcher(line);
        if(match.find())
        {
            System.out.println("This starts with capital letter and ends with period");
        }
        else
        {
            System.out.println("Not a perfect statement");
        }
    }
}