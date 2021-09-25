package java_coursera.StringsFirstAssignments;

public class Part1 {
    public String findSimpleGene(String dna)
    {
        int startIndex=dna.indexOf("AGT");
        if(startIndex==-1)
            return "";
        int endIndex=dna.indexOf("TAA",startIndex+3);
        if (endIndex==-1)
            return "";
        if((endIndex-startIndex)%3==0)
            return dna.substring(startIndex,endIndex+3);
        else
            return "";
    }
    public void testSimpleGene()
    {
        //No AGT
        String dna_1="ATTGTTCCTCTAA";
        System.out.println("The DNA String is "+dna_1);
        System.out.println("The Gene is "+findSimpleGene(dna_1));

        //No TAA
        String dna_2="AGTCGGTAGT";
        System.out.println("The DNA String is "+dna_2);
        System.out.println("The Gene is "+findSimpleGene(dna_2));

        //No AGT And TAA
        String dna_3="TCACTACGTAC";
        System.out.println("The DNA String is "+dna_3);
        System.out.println("The Gene is "+findSimpleGene(dna_3));

        //DNA with ATG, TAA and the substring between them is a multiple of 3
        String dna_4="TCAGTTCAGCATAAA";
        System.out.println("The DNA String is "+dna_4);
        System.out.println("The Gene is "+findSimpleGene(dna_4));

        //DNA with ATG, TAA and the substring between them is not a multiple of 3
        String dna_5="TAGTCGTAA";
        System.out.println("The DNA String is "+dna_5);
        System.out.println("The Gene is "+findSimpleGene(dna_5));

    }
}
