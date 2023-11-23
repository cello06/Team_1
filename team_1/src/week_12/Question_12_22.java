package week_12;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Question_12_22 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Wrong input !\n" +
                    "Usage : java Question_12_22 directory oldString newString");
            System.exit(1);
        }
        ArrayList<File> directories = new ArrayList<>();
        String path = args[0];
        String oldString = args[1];
        String newString = args[2];
        File file = new File(path);
        if (file.isDirectory()) {
            directories.add(file);
        }
        while (!directories.isEmpty()) {
            File currentDirectory = directories.remove(0);
            File[] files = currentDirectory.listFiles();
            if (files.length > 0) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        directories.add(f);
                    }
                    if(f.isFile()){
                        changeFile(f,oldString,newString);
                    }

                }
            }
        }
    }
    public static void changeFile
            (File file,String oldString,String newString){
        StringBuilder page = new StringBuilder();
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()){
                String line = input.nextLine();
                line = line.replaceAll(oldString,newString);
                page.append(line).append("\n");
            }
            PrintWriter output = new PrintWriter(file);
            output.println(page.toString());
            output.close();
        }catch (FileNotFoundException ex){
            System.out.println("File not found!");
        }
    }
}

