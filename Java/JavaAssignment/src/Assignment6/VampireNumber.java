package Assignment6;

import java.util.*;

public class VampireNumber{
    static ArrayList<String> list=new ArrayList<>();
    static void permute(String str, int l, int r) {
        if (l == r)
            list.add(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    public List<String> getVampireNumbers(int maxCount)
    {
        List<String> result=new ArrayList<>();
        int n=0,count=0;
        while(count<maxCount)
        {
            String num=String.valueOf(n);
            if(num.length()%2!=0)
            {
                n++;
                continue;
            }
            permute(num,0,num.length()-1);
            for(int i=0;i<list.size();i++)
            {
                String first=list.get(i).substring(0,num.length()/2);
                String second=list.get(i).substring(num.length()/2,num.length());
                if(first.charAt(first.length()-1)=='0'&&second.charAt(second.length()-1)=='0')
                    continue;
                else
                {
                    if(Integer.parseInt(first) * Integer.parseInt(second) == n)
                    {
                        result.add(num);
                        count++;
                        break;
                    }
                }
            }
            n++;
            list.clear();
        }
        return result;
    }
    public static void main(String[] args)
    {
        VampireNumber vampireNumber=new VampireNumber();
        System.out.println(vampireNumber.getVampireNumbers(100));
    }
}