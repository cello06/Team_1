package week_05;

public class LoopQuestion {
    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            //Patern A sayıları

            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            //Patern A boşlukları
            for (int j = 1; j <= 6 - i; j++) {
                System.out.print("  ");
            }
            System.out.print(" | ");
            //Patern B sayılar

            for (int j = 1; j <= 7 - i; j++) {
                System.out.print(j + " ");
            }
            //Patern B boşlukları
            for (int j = 1; j < i; j++) {
                System.out.print("  ");
            }
            System.out.print(" | ");
            //Patern C boşlukları

            for (int j = 1; j <= 6 - i; j++) {
                System.out.print("  ");
            }

            //Patern C sayıları

            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }

            System.out.print(" | ");
            // Patern D sayıları

            for (int j = 1; j <= 7 - i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
