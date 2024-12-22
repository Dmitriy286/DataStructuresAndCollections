package heap.ascHeap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {

        Heap heap = new Heap(31);

        heap.insert(70);
        heap.insert(40);
        heap.insert(50);
        heap.insert(20);
        heap.insert(60);
        heap.insert(100);
        heap.insert(80);
        heap.insert(30);
        heap.insert(10);
        heap.insert(90);

        heap.display();


        heap.toss(111);
        heap.toss(99);
        heap.toss(33);
        heap.toss(13);

        heap.display();

        heap.restoreHeap();

        heap.display();

//        initUserInterface(heap);
    }

    private static void initUserInterface(Heap heap) throws IOException {
        int valueOne, valueTwo;
        boolean success;

        while (true) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, remove or change: ");

            char choice = getChar();

            switch (choice) {
                case 's':
                    heap.display();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    valueOne = getInt();
                    success = heap.insert(valueOne);

                    if (!success) {
                        System.out.println("Can't insert; full heap");
                    }

                    break;
                case 'r':
                    if (!heap.isEmpty()) {
                        heap.remove();
                    } else {
                        System.out.println("Can't remove. Heap empty");
                    }

                    break;
                case 'c':
                    System.out.print("Enter current index of item: ");
                    valueOne = getInt();

                    System.out.print("Enter new key: ");
                    valueTwo = getInt();

                    success = heap.change(valueOne, valueTwo);

                    if (!success) {
                        System.out.println("Invalid index");
                    }

                    break;
                default:
                    System.out.println("Invalid entry");
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
