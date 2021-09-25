package Assignment1;

import java.io.*;
import java.util.*;
import java.util.regex.*;
public class Assignment1 {
    public static void getPath(File file,String regex) {

        for (File files : file.listFiles()) {
            if (files.isDirectory()) {
                getPath(files, regex);
            }
            else if (files.isFile()) {
                String fileName = files.getName();
                if (Pattern.matches(regex, fileName))
                    System.out.println(files.getAbsolutePath());
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        File file=new File("/home/thilp");
        while (true) {
            System.out.println("Enter the regular expression or -1 to exit");
            String regex = scanner.next();
            if(regex.equals("-1"))
                break;
            else
                getPath(file,regex);
        }
    }
}