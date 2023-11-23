package week_12;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Question_12_20 {
    public static void main(String[] args) {
        ArrayList<File> directories = new ArrayList<>();
        if (args.length != 1) {
            System.out.println("Wrong input!\n" +
                    "Usage : java Question_12_20.java srcRootDirectory");
            System.exit(1);
        }
        String srcRootDirectory = args[0];
        File file = new File(srcRootDirectory);
        if (file.isDirectory()) {
            directories.add(file);
        }
        try {
            while (!directories.isEmpty()) {
                File currentDirectory = directories.remove(0);
                File[] files = currentDirectory.listFiles();

                for (File f : files) {
                    if (f.isDirectory()) {
                        directories.add(f);
                    }
                    if (f.isFile()) {
                        changeFile(f, currentDirectory);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void changeFile(File file, File directory)
            throws FileNotFoundException {
        StringBuilder page = new StringBuilder();
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()){
                String line = input.nextLine();
                if(!line.startsWith("//package " + directory.getName() + ";")){
                    page.append(line).append("\n");
                }
            }
            PrintWriter output = new PrintWriter(file);
            output.println(page.toString());
            output.close();

        }catch (FileNotFoundException ex){
            throw new FileNotFoundException("Problem is in change file method!");
        }

    }
}

