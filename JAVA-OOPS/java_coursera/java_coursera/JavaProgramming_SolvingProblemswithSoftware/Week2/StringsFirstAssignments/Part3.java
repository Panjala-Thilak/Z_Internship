package java_coursera.JavaProgramming_SolvingProblemswithSoftware.Week2.StringsFirstAssignments;

public class Part3 {
    public boolean twoOccurrences(String stringa,String stringb)
    {
        int firstStartIndex=stringb.indexOf(stringa);
        if(firstStartIndex==-1)
            return false;
        int secondStartIndex=stringb.indexOf(stringa,firstStartIndex+stringa.length());
        if(secondStartIndex==-1)
            return false;
        return true;
    }
    void testing(){
        String stringa_1="an";
        String stringb_1="banana";
        String stringa_2="ram",stringb_2="ramasita";
        String stringa_3="zoo",stringb_3="forest";
        System.out.println("Two Occurrences  3.........................Striga = "+stringa_1+" Stringb = "+stringb_1+" "+twoOccurrences(stringa_1,stringb_1));
        System.out.println("Two Occurrences String = "+stringa_2+" Stingb= "+stringb_2+" "+twoOccurrences(stringa_2,stringb_2));
        System.out.println("Last Part Striga = "+stringa_1+" Stringb = "+stringb_1+" "+lastPart(stringa_1,stringb_1));
        System.out.println("Last Part Stringa = "+stringa_2+" Stingb= "+stringb_2+" "+lastPart(stringa_2,stringb_2));
        System.out.println("Last Part Stinga ="+stringa_3+ " Stringb ="+stringb_3+" "+lastPart(stringa_3,stringb_3));
    }
    public String lastPart(String stringa,String stringb)
    {
        int index=stringb.indexOf(stringa);
        if(index==-1)
            return stringb;
        else
            return stringb.substring(index+stringa.length(),stringb.length());
    }

    public static void main(String[] args) {
        Part3 part3=new Part3();
        part3.testing();;
    }
}
