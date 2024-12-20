package hashtable.treeHashTable;


public class HashTable {

    private Tree[] hashArray;
    private int size;

    private final static double LOAD_FACTOR = 0.5;
    private int capacity;

    public HashTable(int size) {
        this.size = size;
        this.hashArray = new Tree[size];

        for (int i = 0; i < size; i++) {
            hashArray[i] = new Tree();
        }
    }

    public void display() {

        for (int i = 0; i < size; i++) {
            System.out.print(i + ". ");
            hashArray[i].traverse(1);
        }

        System.out.println();
    }

    public int hash(int key) {
        return key % size;
    }

    public void insert(Node node) {

        int key = node.iData;
        int hash = hash(key);

        Node foundNode = hashArray[hash].find(key, null, false);

        if (foundNode != null && foundNode.iData == node.iData) {
            System.out.println("Not allowed duplicated keys");

            return;
        }

        hashArray[hash].insert(key, node.dData);

        capacity++;
    }

    public Node find(int key) {

        int hash = hash(key);

        Node foundNode = hashArray[hash].find(key, null, false);

        return foundNode;
    }
}
