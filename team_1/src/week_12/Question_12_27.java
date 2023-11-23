package week_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Question_12_27 {
    public static void main(String[] args) throws FileNotFoundException {
        //if (args.length != 1) {
        //  System.out.println("Wrong input! \n" +
        //        "Usage : java Question_12_26.java *");
        //System.exit(1);
        //}
        String pathOfDirectory = "";
        //if (args[0] == "*") {
        pathOfDirectory = "C:\\Users\\Celallettin\\workspace\\cello_java\\team_works\\team_1\\src\\week_01";
        //}
        File directory = new File(pathOfDirectory);
        File[] files = directory.listFiles();
        assert files != null;//I took this place from IDE:)
        for (File file : files) {
            File fileWithNewName = changeFileName(file);
            changeInsideTheFile(fileWithNewName);
        }
    }

    public static File changeFileName(File file) {
        String nameOfFile = file.getName();
        nameOfFile = changeLine(nameOfFile);
        File fileWithNewName = new File(file.getParentFile() + "\\" + nameOfFile);
        boolean isRenamed = file.renameTo(fileWithNewName);
        if (isRenamed) {
            System.out.println("Successfully Renamed! -->" + fileWithNewName.getName());
        }
        return fileWithNewName;
    }

    public static String changeLine(String nameOfFile) {
        StringBuilder sb = new StringBuilder(nameOfFile);
        int firstIndexOfInteger = findFirstIndexOfInteger(nameOfFile);
        if (firstIndexOfInteger == -1) {
            throw new IllegalArgumentException("Wrong file name");
        }
        if (!Character.isDigit(sb.charAt(firstIndexOfInteger + 1)) &&
                !Character.isDigit(sb.charAt(firstIndexOfInteger - 1))) {
            sb.insert(firstIndexOfInteger, "0");
        }
        return sb.toString();
    }

    public static void changeInsideTheFile(File fileWithNewName) {
        try {
            Scanner input = new Scanner(fileWithNewName);
            StringBuilder page = new StringBuilder();
            while (input.hasNext()) {
                String line = input.nextLine();
                if (line.contains("Question")) {
                    line = changeLine(line);
                }
                page.append(line).append("\n");
            }
            PrintWriter output = new PrintWriter(fileWithNewName);
            output.println(page.toString());
            output.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not found!");
        }
    }

    public static int findFirstIndexOfInteger(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
