package week_03;

import java.util.Scanner;

public class Deneme {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of lines : ");
        int numberOfLine = input.nextInt();

        for(int i = 1; i<=numberOfLine;i++){
            for(int j=1;j<=numberOfLine-i;j++){
                System.out.print("  ");
            }
            for(int k=i;k>=1;k--){
                System.out.print(k+" ");
            }
            for(int l=2;l<=i;l++){
                System.out.print(l+" ");
            }
            System.out.println();
        }

    }
}

