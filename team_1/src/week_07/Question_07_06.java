package week_07;

import java.util.Scanner;

public class Question_07_06 {
    public static void main(String[] args) {
        int[] primeNumbers = getPrimeNumbers();
        printPrimeNumbers(primeNumbers);
    }

    public static int[] getPrimeNumbers() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter how many prime number that you want to print : ");
        int countOfPrime = input.nextInt();

        return getPrimeNumbers(countOfPrime);
    }

    public static int[] getPrimeNumbers(int countOfPrime) {
        int[] primeNumbers = new int[countOfPrime];

        int number = 2;
        int count = 0;

        while (count < countOfPrime) {
            if (isPrime(number)) {
                primeNumbers[count] = number;
                count++;
            }
            number++;
        }
        return primeNumbers;
    }

    public static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printPrimeNumbers(int[] primeNumbers) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many prime numbers on line you want : ");
        int countOfNumbersOnLine = input.nextInt();

        for (int i = 0; i < primeNumbers.length; i++) {
            if (i % countOfNumbersOnLine == 0) {
                System.out.printf("\n%5d", primeNumbers[i]);
            } else {
                System.out.printf("%5d", primeNumbers[i]);
            }
        }
    }
}

