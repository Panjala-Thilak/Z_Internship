package Assignment4;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

public class Assignment4 {
    public static void main(String[] args) throws Exception{
        Scanner scanner=new Scanner(System.in);
        int testCase=scanner.nextInt();
        while(testCase-->0)
        {
            String date1=scanner.next();
            String date2=scanner.next();
            Date signupDate=new SimpleDateFormat("dd-MM-yyyy").parse(date1);
            Date currentDate=new SimpleDateFormat("dd-MM-yyyy").parse(date2);
            if(currentDate.compareTo(signupDate)>0)
            {
                Date start,end,cal;
                cal=signupDate;
                cal.setYear(currentDate.getYear());
                Calendar calendar=Calendar.getInstance();
                calendar.setTime(cal);
                calendar.add(Calendar.DATE, 30);
                end=calendar.getTime();
                calendar.add(Calendar.DATE,-60);
                start=calendar.getTime();
                if(end.compareTo(currentDate)>0)
                    end=currentDate;
                SimpleDateFormat print=new SimpleDateFormat("dd-MM-yyyy");
                System.out.println(print.format(start)+"  "+print.format(end));

            }
            else
            {
                System.out.println("No range");
            }
        }
    }
}