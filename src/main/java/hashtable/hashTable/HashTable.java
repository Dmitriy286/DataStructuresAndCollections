package hashtable.hashTable;

public class HashTable {

    private DataItem[] hashArray;
    private int size;
    private DataItem nonItem;

    private final static double LOAD_FACTOR = 0.5;
    private int capacity;

    public HashTable(int size) {
        this.size = size;
        this.hashArray = new DataItem[size];
        this.nonItem = new DataItem(-1);
    }

    public void display() {
        System.out.println("Table: ");

        for (int i = 0; i < size; i++) {
            if (hashArray[i] != null) {
                System.out.print(hashArray[i].getKey() + " ");
            } else {
                System.out.print("** ");
            }
        }

        System.out.println();
    }

    public int hash(int key) {
//        return key % size;

        return convolutionHash(key, size);
    }

    public int convolutionHash(int key, int arraySize) {

        int digitQuantity = 0;
        int reducingNumber = key;

        while (reducingNumber > 0) {
            reducingNumber /= 10;
            digitQuantity++;
        }

        int digit = 0;

        while (arraySize != 1 && arraySize != 0) {
            arraySize /= 10;
            digit++;
        }

        int delimeter = 1;

        for (int i = 0; i < digit; i++) {
            delimeter *= 10;
        }

        int sum = 0;

        int firstGroupSize = digitQuantity % digit;

        if (firstGroupSize != 0) {
            sum = key % (firstGroupSize * 10);
            key /= firstGroupSize * 10;
        }

        while (key != 0) {

            int group = key % delimeter;

            sum += group;

            key /= delimeter;
        }

        return sum % size;
    }

    public void insert(DataItem item) {

        boolean needToRehash = checkCapacity();

        if (needToRehash) {
            capacity = 0;

            rehash();
        }

        int key = item.getKey();
        int hash = hash(key);
        int step = 1;

        while (hashArray[hash] != null && hashArray[hash].getKey() != -1) {
            hash += step * step;
            ++step;
            hash %= size;
        }


        hashArray[hash] = item;

        capacity++;
    }

    public DataItem delete(int key) {
        int hash = hash(key);

        while (hashArray[hash] != null) {

            if (hashArray[hash].getKey() == key) {
                DataItem temp = hashArray[hash];
                hashArray[hash] = nonItem;

                capacity--;

                return temp;
            }

            ++hash;
            hash %= size;
        }

        return null;
    }

    public DataItem find(int key) {
        int hash = hash(key);
        int step = 1;

        while (hashArray[hash] != null) {

            if (hashArray[hash].getKey() == key) {
                return hashArray[hash];
            }

            hash += step * step;
            ++step;
            hash %= size;
        }

        return null;
    }

    private boolean checkCapacity() {

        return capacity > size * LOAD_FACTOR;
    }

    private void rehash() {

        int oldArraySize = size;

        int newArraySize = getPrime(size * 2);

        DataItem[] oldHashArray = hashArray.clone();

        hashArray = new DataItem[newArraySize];
        size = newArraySize;

        for (int i = 0; i < oldArraySize; i++) {

            if (oldHashArray[i] != null && oldHashArray[i].getKey() != -1) {

                insert(oldHashArray[i]);
            }
        }
    }

    private int getPrime(int min) {

        for (int i = min + 1; true; i++) {

            if (isPrime(i)) {
                return i;
            }
        }
    }

    private boolean isPrime(int n) {

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
