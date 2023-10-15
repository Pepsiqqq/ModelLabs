
import java.util.Scanner;

class laba1 {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        String word = sc.nextLine();
        sc.close();
        System.out.println(WordBackwards(word, ""));
    }
    static String WordBackwards(String input, String result)
        {
            String last = Character.toString(input.charAt(input.length()-1));
            input = input.substring(0, input.length() - 1);
            String recurs = "";
            if (input.length() != 0)
            {
                recurs = WordBackwards(input, recurs);
            }
            return last + recurs;
        }
}