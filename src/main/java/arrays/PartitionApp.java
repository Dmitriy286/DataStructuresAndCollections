package arrays;


public class PartitionApp {

    public static void main(String[] args) {

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
