package week_07;

import java.util.Scanner;

public class Question_07_14 {
    public static void main(String[] args) {
        int[] numbers = getNumbers();
        int gcdOfNumbers = gcd(numbers);
        printGCD(gcdOfNumbers);
    }

    public static int[] getNumbers() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter five numbers : ");
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }
        return numbers;
    }

    public static int getMin(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int gcd(int... numbers) {
        int minimumNumber = getMin(numbers);
        int gcd = 1;
        boolean isDivised;
        for (int i = 2; i < minimumNumber; i++) {
            isDivised = true;
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] % i != 0) {
                    isDivised = false;
                }
            }
            if (isDivised) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static void printGCD(int gcd) {
        System.out.println("The greatest common divisor is " + gcd);
    }
}

