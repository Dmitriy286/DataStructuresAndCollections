package btree.tre234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tree234App {

    public static void main(String[] args) throws IOException {

        Tree234 tree234 = new Tree234();

////        tree234.insert(5);
////        tree234.insert(7);
//        tree234.insert(50);
//        tree234.insert(40);
//        tree234.insert(60);
//        tree234.insert(30);
////        tree234.insert(2);
//        tree234.insert(70);
//
//        tree234.insert(20);
//        tree234.insert(10);

//        initUserInterface(tree234);

//        tree234.traverse();
//        System.out.println();
//        System.out.println(tree234.size());

        long[] array = new long[]{50, 40, 60, 30, 70, 20, 10};

        System.out.println(Arrays.toString(tree234.sort(array)));

//        tree234.findMin();
    }

    private static void initUserInterface(Tree234 tree234) throws IOException {
        long value;

        while (true) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, or find: ");

            char choice = getChar();

            switch (choice) {
                case 's':
                    tree234.display();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    tree234.insert(value);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    int found = tree234.find(value);

                    if (found != -1) {
                        System.out.println("Found " + value);
                    } else {
                        System.out.println("Not found " + value);
                    }
//                default:
//                    System.out.println("Invalid entry");
            }
        }
    }

    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();

        return s;
    }

    private static char getChar() throws IOException {
        String s = getString();

        return s.charAt(0);
    }

    private static int getInt() throws IOException {
        String s = getString();

        return Integer.parseInt(s);
    }
}
