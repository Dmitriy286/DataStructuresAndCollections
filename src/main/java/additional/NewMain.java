package additional;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class NewMain {
    public static void main(String[] args) {
        test();
    }

    public static void other() {

    }

    public static void test() {
        String separator = File.separator;
        String path = "C:" + separator + "Users" + separator + "Professional" + separator +"IdeaProjects" + separator + "DataStructures and Collections" +
                separator + "src" + separator + "main" + separator + "resources" + separator + "Test.txt";

//        File file = new File(path);
        File file = new File("path");
        System.out.println("Before try catch block");

        try {
            System.out.println("Inside try catch block, start");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            String[] numbersString = line.split(" ");
            System.out.println(Arrays.toString(numbersString));
            System.out.println("Inside try catch block, finish");
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            String message = e.getMessage();
            System.out.println("Exception");
            System.out.println(message);
        } finally {
            System.out.println("In finally");
        }

        System.out.println("After try catch block");
        otherMethod();
    }

    private static void otherMethod() {
        System.out.println("Other method called");
    }
}
