package hashtable.stringHashTable;


import java.util.Objects;

public class HashTable {

    private DataItem[] hashArray;
    private int size;
    private DataItem nonItem;

    public HashTable(int size) {
        this.size = size;
        this.hashArray = new DataItem[size];
        this.nonItem = new DataItem("_____");
    }

    public void display() {
        System.out.println("Table: ");

        System.out.print("| ");

        for (int i = 0; i < size; i++) {
            if (hashArray[i] != null) {
                System.out.print(hashArray[i].getData() + " | ");
            } else {
                System.out.print("***** | ");
            }
        }

        System.out.println();
    }

    public int hash(String data) {

        int hash = 0;

        for (int i = 0; i < data.length(); i++) {
            int letter = data.charAt(i);
            hash = (hash * 27 + letter) % size;
        }

        return hash;
    }

    public void insert(DataItem item) {
        String data = item.getData();
        int hash = hash(data);

        int step = 1;

        while (hashArray[hash] != null && !Objects.equals(hashArray[hash].getData(), "_____")) {
            hash += step * step;
            ++step;
            hash %= size;
        }

        hashArray[hash] = item;
    }

    public DataItem delete(String data) {
        int hash = hash(data);

        while (hashArray[hash] != null) {

            if (hashArray[hash].getData() == data) {
                DataItem temp = hashArray[hash];
                hashArray[hash] = nonItem;

                return temp;
            }

            ++hash;
            hash %= size;
        }

        return null;
    }

    public DataItem find(String data) {
        int hash = hash(data);

        while (hashArray[hash] != null) {
            if (hashArray[hash].getData() == data) {
                return hashArray[hash];
            }

            ++hash;
            hash %= size;
        }

        return null;
    }
}
