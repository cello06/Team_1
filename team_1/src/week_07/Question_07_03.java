package week_07;

import java.util.Scanner;

public class Question_07_03 {
    public static void main(String[] args) {
        int[] countOfNumbers = getNumbers();
        printNumbers(countOfNumbers);
    }

    public static int[] getNumbers() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the integers between 1 and 100");
        int number = -1;
        int[] countOfNumbers = new int[101];
        while (number != 0) {
            number = input.nextInt();
            if (number == 100) {
                countOfNumbers[100]++;
            }
            countOfNumbers[number % 100]++;
        }
        return countOfNumbers;
    }

    public static void printNumbers(int[] countOfNumbers) {
        for (int i = 1; i < countOfNumbers.length; i++) {
            if (countOfNumbers[i] > 0) {
                System.out.println((i) + " occurs " + countOfNumbers[i] + ((countOfNumbers[i] > 1) ? " times" : " time"));
            }
        }
    }
}
