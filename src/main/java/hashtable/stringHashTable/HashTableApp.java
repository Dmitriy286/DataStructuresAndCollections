package hashtable.stringHashTable;


import java.util.Arrays;

public class HashTableApp {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable(23);

        System.out.println("HASH: " + hashTable.hash("new big string"));

        String[] strings = new String[] {
                "first string",
                "second string",
                "third string",
                "animal capital",
                "pigs are fire",
                "bulk",
                "brandy",
                "scotland",
                "new big string",
                "notexistingword"
        };

        Arrays.stream(strings).forEach(s -> {
            DataItem dataItem = new DataItem(s);

            hashTable.insert(dataItem);

            hashTable.display();

        });

        hashTable.display();

        DataItem found = hashTable.find("new big string");
        System.out.println("Found: " + found.getData());

        DataItem dataItem = new DataItem("new big string");

        hashTable.insert(dataItem);

        hashTable.display();

        hashTable.delete("brandy");

        hashTable.display();

        DataItem dataItemTwo = new DataItem("brandy");

        hashTable.insert(dataItemTwo);

        hashTable.display();
    }
}
