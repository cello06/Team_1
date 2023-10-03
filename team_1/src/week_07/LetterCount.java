package week_07;

import java.util.Locale;
import java.util.Scanner;

public class LetterCount {
    public static void main(String[] args) {
        int[] countOfLetter = getCountOfLetter();
        printLetters(countOfLetter);
    }

    public static int[] getCountOfLetter() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = input.nextLine();
        str = str.toLowerCase(Locale.ROOT);

        int[] countOfLetters = new int['z' - 'a'];

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                countOfLetters[str.charAt(i) - 'a']++;
            }

        }
        return countOfLetters;
    }

    public static void printLetters(int[] countOfLetter) {

        for (int i = 0; i < countOfLetter.length; i++) {
            if (countOfLetter[i] > 0) {
                System.out.println((char) (i + 'a') + " ----> " + countOfLetter[i] + ((countOfLetter[i] > 1) ? " times" : " time"));
            }
        }
    }
}
