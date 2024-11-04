package sorting;

public class QuickSort {

    public static void main(String[] args) {

        int maxSize = 50;
        ArrayIns arr;

        arr = new ArrayIns(maxSize);

        for (int i = 0; i < maxSize; i++) {
            long n = (int) (Math.random() * 99);
            arr.insert(n);
        }

        arr.display();
        arr.quickSort();
        arr.display();
    }
}
