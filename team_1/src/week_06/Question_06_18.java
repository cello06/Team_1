package week_06;

import java.util.Scanner;

public class Question_06_18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a password : ");
        String password = input.nextLine();

        System.out.println((isValid(password) ? "Valid" : "Invalid") + " Password");

        System.out.println(password.length() < 8);
        System.out.println(!containsDigitOrNumber(password));
        System.out.println(!atLeastTwoDigits(password));
        System.out.println(!atLeastOneUpperCase(password));
    }

    public static boolean isValid(String password) {
        if (password.length() < 8 ||
                !containsDigitOrNumber(password) ||
                !atLeastTwoDigits(password) ||
                !atLeastOneUpperCase(password)) {
            return false;
        }
        return true;
    }

    public static boolean containsDigitOrNumber(String password) {
        for (int i = 0; i <= password.length() - 1; i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean atLeastTwoDigits(String password) {
        int countDigit = 0;
        for (int i = 0; i <= password.length() - 1; i++) {
            if (Character.isDigit(password.charAt(i))) {
                countDigit++;
                if (countDigit == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean atLeastOneUpperCase(String password) {
        for (int i = 0; i <= password.length() - 1; i++) {
            if (password.charAt(i) <= 'Z' && password.charAt(i) >= 'A') {
                return true;
            }
        }
        return false;
    }
}

