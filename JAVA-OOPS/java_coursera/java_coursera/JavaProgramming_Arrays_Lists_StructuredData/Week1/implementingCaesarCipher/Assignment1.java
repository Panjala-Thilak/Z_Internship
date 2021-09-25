package java_coursera.JavaProgramming_Arrays_Lists_StructuredData.Week1.implementingCaesarCipher;
//Word PLay
public class Assignment1 {
    public boolean isVowel(char ch) {
        ch = Character.toUpperCase(ch);

        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }

        return false;
    }

    public void testIsVowel() {
        char ch = 'z';
        System.out.println(ch + " is a vowel = " + isVowel(ch));

        ch = 'A';
        System.out.println(ch + " is a vowel = " + isVowel(ch));
    }

    public String replaceVowels(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder();

        for (int i = 0; i < phrase.length(); i++) {
            char currentCharacter = phrase.charAt(i);

            if (isVowel(currentCharacter)) {
                newPhrase.append(ch);
            } else {
                newPhrase.append(currentCharacter);
            }
        }

        return newPhrase.toString();
    }

    public void testReplaceVowels() {
        String phrase = "Hello World";
        char ch = '*';
        System.out.println(phrase + " -> " + replaceVowels(phrase, ch));
    }


    public String emphasize(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder();

        for (int i = 0; i < phrase.length(); i++) {
            char currentCharacter = phrase.charAt(i);

            if (Character.toLowerCase(currentCharacter) == Character.toLowerCase(ch)) {
                if (i % 2 == 0) {
                    newPhrase.append('*');
                } else {
                    newPhrase.append('+');
                }
            } else {
                newPhrase.append(currentCharacter);
            }
        }

        return newPhrase.toString();
    }

    public void testEmphasize() {
        String phrase = "dna ctgaaactga";
        char ch = 'a';
        System.out.println(phrase + " with " + ch + " replaced become = " + emphasize(phrase, ch));

        phrase = "Mary Bella Abracadabra";
        ch = 'a';
        System.out.println(phrase + " with " + ch + " replaced become = " + emphasize(phrase, ch));
    }

    public static void main(String[] args) {
        Assignment1 assignment1=new Assignment1();
        assignment1.testIsVowel();
        assignment1.testReplaceVowels();
        assignment1.testEmphasize();
    }
}
