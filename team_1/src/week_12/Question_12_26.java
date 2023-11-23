package week_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Question_12_26 {
    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.out.println("Wrong input! \n" +
//                    "Usage : java Question_12_26.java *");
//            System.exit(1);
//        }
        String pathOfDirectory = "";
        //if (args[0] == "*") {
            pathOfDirectory = "C:\\Users\\Celallettin\\workspace\\cello_java\\team_works\\team_1\\src\\week_01";
        //}
        File directory = new File(pathOfDirectory);
        File[] files = directory.listFiles();
        for (File file : files) {
            try {
                StringBuilder page = new StringBuilder();
                Scanner input = new Scanner(file);
                while (input.hasNext()) {
                    String line = input.nextLine();
                    if (line.contains("Question")) {
                        line = changeLine(line);
                    }
                    page.append(line).append("\n");
                }
                PrintWriter output = new PrintWriter(file);
                output.println(page.toString());
                output.close();
            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            }
        }
    }
    public static String changeLine(String line){
        StringBuilder sb = new StringBuilder(line);
        for (int i = 0; i < sb.length(); i++) {
            if(i!=0 && i != sb.length()-1 &&
                    Character.isDigit(sb.charAt(i)) &&
                    !Character.isDigit(sb.charAt(i-1))&&
                    !Character.isDigit(sb.charAt(i+1))){
                sb.insert(i,"0");
            }
            if(i == sb.length()-1 &&
                    Character.isDigit(sb.charAt(i)) &&
                    !Character.isDigit(sb.charAt(i-1))){
                sb.insert(i,"0");
            }
        }
        return sb.toString();
    }
}

