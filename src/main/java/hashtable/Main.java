package hashtable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        List<Animal> animals = new ArrayList<>();
//        List<Dog> dogs = new ArrayList<>();
//        List<Haski> haskies = new ArrayList<>();
//
//        animals.add(new Animal());
//        animals.add(new Animal());
//
//        dogs.add(new Dog());
//        dogs.add(new Dog());
//
//        haskies.add(new Haski());
//        haskies.add(new Haski());
//
//        test(animals);
//        test(dogs);
//        test(haskies);
//        String separator = File.separator;
//        String path = "C:" + separator + "Users" + separator + "Professional" + separator +"IdeaProjects" + separator + "DataStructures and Collections" +
//                separator + "src" + separator + "main" + separator + "resources" + separator + "Test.txt";
//
//        File file = new File(path);
//
//        Scanner scanner = new Scanner(file);
//        String line = scanner.nextLine();
//
//        String[] numbersString = line.split(" ");
//
//        System.out.println(Arrays.toString(numbersString));
//
//        int[] numbers = new int[3];
//        int counter = 0;
//
//        for (String number : numbersString) {
//            numbers[counter++] = Integer.parseInt(number);
//        }
//
//        System.out.println(Arrays.toString(numbers));
//
//        scanner.close();

        writefile();

    }

    private static void writefile() throws FileNotFoundException {
        File file = new File("testFile");

        PrintWriter printWriter = new PrintWriter(file);

        printWriter.println("test row 1");
        printWriter.println("test row 2");

        printWriter.close();
    }


//    private static void test(List<? extends Animal> list) {
//        for (Animal a : list) {
//            System.out.println(a);
//        }
//    }
}
