package week_12;

import java.io.File;

public class Question_12_27 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Wrong input! \n" +
                    "Usage : java Question_12_26.java *");
            System.exit(1);
        }
        String pathOfDirectory = "";
        if (args[0] == "*") {
            pathOfDirectory = "C:\\Users\\Celallettin\\workspace\\cello_java\\team_works\\team_1\\src\\week_01";
        }
        File directory = new File(pathOfDirectory);
        File[] files = directory.listFiles();
        for (File file :files) {
            String nameOfFile = file.getName();

            nameOfFile = changeFileName(nameOfFile);
            File fileWithNewName = new File(file.getParentFile() + nameOfFile);
            boolean isRenamed = file.renameTo(fileWithNewName);
            if(isRenamed){
                System.out.println("Successfully Renamed! -->" + file.getName());
            }
        }
    }
    public static String changeFileName(String nameOfFile){
        StringBuilder sb = new StringBuilder(nameOfFile);
        int firstIndexOfInteger = findFirstIndexOfInteger(nameOfFile);
        if(firstIndexOfInteger ==-1){
            throw new IllegalArgumentException("Wrong file name");
        }
        if(!Character.isDigit(sb.charAt(firstIndexOfInteger+1)) &&
                !Character.isDigit(sb.charAt(firstIndexOfInteger - 1))){
            sb.insert(firstIndexOfInteger,"0");
        }
        return sb.toString();
    }
    public static int findFirstIndexOfInteger(String line){
        for (int i = 0; i < line.length(); i++) {
            if(Character.isDigit(line.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}
