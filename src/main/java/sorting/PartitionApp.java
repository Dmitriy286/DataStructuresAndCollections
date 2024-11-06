package sorting;


import arrays.HighArray;

public class PartitionApp {

    public static void main(String[] args) {

//        partition();

        int maxSize = 8;

        median(maxSize);

        oldMedian(maxSize);
    }

    private static void oldMedian(int maxSize) {

        HighArray arr = new HighArray(maxSize);

        for (int i = 2; i <= maxSize * 2; i += 2) {

            arr.insert(i);
        }

//        arr.insert(5);
//        arr.insert(1);
//        arr.insert(3);
//        arr.insert(25);
//        arr.insert(19);
//        arr.insert(17);
//        arr.insert(21);
//        arr.insert(34);

        arr.display();

        arr.insertionSort();

        arr.median();
    }

    private static void median(int maxSize) {

        ArrayPar arr;

        arr = new ArrayPar(maxSize);

//        for (int i = 0; i < maxSize; i++) {
        for (int i = 2; i <= maxSize * 2; i += 2) {

            arr.insert(i);
        }

//        arr.insert(5);
//        arr.insert(1);
//        arr.insert(3);
//        arr.insert(25);
//        arr.insert(19);
//        arr.insert(17);
//        arr.insert(21);
//        arr.insert(34);

        arr.display();

        arr.median();
    }

    private static void partition() {
        int maxSize = 16;
        ArrayPar arr;

        arr = new ArrayPar(maxSize);

        for (int i = 0; i < maxSize; i++) {
            long n = (int) (Math.random() * 199);
            arr.insert(n);
        }

        arr.display();

        int partDex = arr.partitionIt(0, arr.size() - 1);

        System.out.println(", Partition is at index " + partDex);

        arr.display();
    }
}
