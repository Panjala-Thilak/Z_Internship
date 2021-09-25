package Assignment11;

import java.util.*;
import java.io.*;

public class Assignment11 {
    public static void main(String[] args) throws IOException{

        HashMap<Character,Integer> characterCounter=new HashMap<>();
        FileReader fileReader=new FileReader(args[0]);
        int c;
        while ((c=fileReader.read())!=-1) {
            if (characterCounter.containsKey((char) c)) {
                characterCounter.put((char) c, characterCounter.get((char) c) + 1);
            } else {
                if ((char) c == '\n')
                    continue;
                characterCounter.put((char) c, 1);
            }
        }
        System.out.println(characterCounter);
        FileWriter fileWriter=new FileWriter(args[0]);
        fileWriter.flush();
        for (Map.Entry<Character, Integer> entry : characterCounter.entrySet()) {
            fileWriter.write(entry.getKey() + " Occurred " + entry.getValue()+"times\n");
        }
        fileWriter.close();

    }
}