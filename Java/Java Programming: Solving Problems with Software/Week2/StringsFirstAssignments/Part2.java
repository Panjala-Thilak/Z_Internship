package java_coursera.StringsFirstAssignments;

import java.util.Locale;

public class Part2 {
    public String findSimpleGene(String dna,String startCodon,String stopCodon)
    {
        String dnaTemp=dna.toUpperCase();
        int startIndex=dnaTemp.indexOf(startCodon);
        if(startIndex==-1)
            return "";
        int endIndex=dnaTemp.indexOf(stopCodon,startIndex+3);
        if (endIndex==-1)
            return "";
        if((endIndex-startIndex)%3==0)
            return dna.substring(startIndex,endIndex+3);
        else
            return "";
    }
    public void testSimpleGene()
    {

        String startCodon="ATG";
        String stopCodon="TAA";

        //No ATG
        String dna_1="ATTGTTCCTCTAA";
        System.out.println("The DNA String is "+dna_1);
        System.out.println("The Gene is "+findSimpleGene(dna_1,startCodon,stopCodon));

        //No TAA
        String dna_2="AGTCGGTAGT";
        System.out.println("The DNA String is "+dna_2);
        System.out.println("The Gene is "+findSimpleGene(dna_2,startCodon,stopCodon));

        //No ATG And TAA
        String dna_3="TCACTACGTAC";
        System.out.println("The DNA String is "+dna_3);
        System.out.println("The Gene is "+findSimpleGene(dna_3,startCodon,stopCodon));

        //DNA with ATG, TAA and the substring between them is a multiple of 3
        String dna_4="ATGTCAGCATAA";
        System.out.println("The DNA String is "+dna_4);
        System.out.println("The Gene is "+findSimpleGene(dna_4,startCodon,stopCodon));

        //DNA with ATG, TAA and the substring between them is not a multiple of 3
        String dna_5="AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("The DNA String is "+dna_5);
        System.out.println("The Gene is "+findSimpleGene(dna_5,startCodon,stopCodon));

        //DNA with ATG, TAA and the substring between them is a multiple of 3
        String dna_6="gatgctataat";
        System.out.println("The DNA String is "+dna_6);
        System.out.println("The Gene is "+findSimpleGene(dna_6,startCodon,stopCodon));

    }

    public static void main(String[] args) {
        Part2 part2=new Part2();
        part2.testSimpleGene();
    }
}
