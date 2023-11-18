import java.util.Scanner;

public class WordBackwards {
    static String wordBackwardsMethodRecurs(String input, String result)
        {
            String last = Character.toString(input.charAt(input.length()-1));
            input = input.substring(0, input.length() - 1);
            String recurs = "";
            if (input.length() != 0)
            {
                recurs = wordBackwardsMethodRecurs(input, recurs);
            }
            return last + recurs;
        }
    static void wordBackwardsMethodInit(Scanner sc){
        System.out.println("Type word to turn backward");
        String word = sc.next();
        System.out.println(wordBackwardsMethodRecurs(word, ""));
    }
}
