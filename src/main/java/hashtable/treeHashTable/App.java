package hashtable.treeHashTable;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {
        Node node;

        int key;

        int size, n, keysPerCell = 100;

        double dData;

        System.out.println("Enter size of hash table: ");
        size = getInt();

        System.out.println("Enter initial number of items: ");
        n = getInt();


        HashTable hashTable = new HashTable(size);

        for (int i = 0; i < n; i++) {
            key = (int) (Math.random() * keysPerCell * size);

            dData = (double) (Math.random() * size);

            node = new Node();
            node.iData = key;
            node.dData = dData;

            hashTable.insert(node);
        }

        initUserInterface(hashTable);
    }

    private static void initUserInterface(HashTable hashTable) throws IOException {
        int key;
        double dData;
        Node node;

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

                    System.out.print("Enter double value to insert: ");
                    dData = (double) getInt();

                    node = new Node();
                    node.iData = key;
                    node.dData = dData;

                    hashTable.insert(node);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    key = getInt();
                    node = hashTable.find(key);

                    if (node != null) {
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
