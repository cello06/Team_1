package week_12;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Question_12_18 {
    public static void main(String[] args) {
        ArrayList<File> directories = new ArrayList<>();
        if (args.length != 1) {
            System.out.println("Wrong input ! \n" +
                    "Usage : java Question_12_18.java srcRootDirectory");
            System.exit(1);
        }
        String srcRootDirectory = args[0];
        File file = new File(srcRootDirectory);
        if (file.isDirectory()) {
            directories.add(file);
        }
        while (!directories.isEmpty()) {
            File currentFile = directories.remove(0);
            File[] files = currentFile.listFiles();
            if (files.length > 0) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        directories.add(f);
                    }
                    if (f.isFile()) {
                        changePackage(f,currentFile.getName());
                    }
                }
            }
        }
    }

    public static void changePackage(File file,String packageName) {
        try {
            StringBuilder s = new StringBuilder();
            Scanner input = new Scanner(file);
            while (input.hasNext()){
                s.append(input.nextLine()).append("\n");
            }
            input.close();
            PrintWriter output = new PrintWriter(file);
            output.println("//package " + packageName +";\n" + s);
            output.close();

        }catch (FileNotFoundException ex){
            System.out.println("File not found!");
        }
    }
}

