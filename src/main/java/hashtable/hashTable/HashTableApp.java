package hashtable.hashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashTableApp {

    public static void main(String[] args) throws IOException {

        DataItem dataItem;

        int key, size, n, keysPerCell;

        System.out.println("Enter size of hash table: ");
        size = getInt();

        System.out.println("Enter initial number of items: ");
        n = getInt();

        keysPerCell = 10;

        HashTable hashTable = new HashTable(size);

        for (int i = 0; i < n; i++) {
            key = (int) (Math.random() * keysPerCell * size);
            dataItem = new DataItem(key);
            hashTable.insert(dataItem);
        }

        initUserInterface(hashTable);
    }

    private static void initUserInterface(HashTable hashTable) throws IOException {
        int key;
        DataItem dataItem;

        while (true) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, or find: ");

            char choice = getChar();

            switch (choice) {
                case 's':
                    hashTable.display();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    key = getInt();
                    dataItem = new DataItem(key);
                    hashTable.insert(dataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    key = getInt();
                    hashTable.delete(key);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    key = getInt();
                    dataItem = hashTable.find(key);

                    if (dataItem != null) {
                        System.out.println("Found " + key);
                    } else {
                        System.out.println("Not found " + key);
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
