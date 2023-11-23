package week_07;

import java.util.Scanner;

public class Question_07_01 {
    public static void main(String[] args) {
        gradeCalculation();
    }

    public static void gradeCalculation() {
        int[] scores = getScores();
        int max = getMax(scores);
        char[] grades = getGrades(scores, max);
        printGrades(scores, grades);
    }

    public static int[] getScores() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students : ");
        int countOfStudents = input.nextInt();
        System.out.print("Enter " + countOfStudents + " scores : ");
        int[] scores = new int[countOfStudents];

        for (int i = 0; i < scores.length; i++) {
            scores[i] = input.nextInt();
        }
        return scores;
    }

    public static int getMax(int[] scores) {
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    public static char[] getGrades(int[] scores, int max) {

        char[] grades = new char[scores.length];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= (max - 10)) {
                grades[i] = 'A';
            } else if (scores[i] >= (max - 20)) {
                grades[i] = 'B';
            } else if (scores[i] >= (max - 30)) {
                grades[i] = 'C';
            } else if (scores[i] >= (max - 40)) {
                grades[i] = 'D';
            } else {
                grades[i] = 'F';
            }
        }
        return grades;
    }

    public static void printGrades(int[] scores, char[] grades) {
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Student " + i + " score is " + scores[i] + " and grade is " + grades[i]);
        }
    }
}

