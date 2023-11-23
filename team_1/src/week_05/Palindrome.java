package week_05;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isPalindrome = false;
        System.out.print("Enter a string : ");
        String yourStr = input.nextLine();
        yourStr=yourStr.toUpperCase();

        int firstIndexOfString = 0;
        int lastIndexOfString = yourStr.length()-1;

        while(firstIndexOfString<lastIndexOfString){


            if(yourStr.charAt(firstIndexOfString)== yourStr.charAt(lastIndexOfString)){
                isPalindrome=true;
            }else{
                isPalindrome=false;
                break;
            }

            firstIndexOfString++;
            lastIndexOfString--;
        }

        System.out.print("is that a palindrome : "+isPalindrome);




    }
}

