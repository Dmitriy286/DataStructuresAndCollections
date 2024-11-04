package sorting;

public class ShellSort {

    public static void main(String[] args) {

        int maxSize = 50;
        ArraySh arr;

        arr = new ArraySh(maxSize);

        for (int i = 0; i < maxSize; i++) {
            long n = (int) (Math.random() * 99);
            arr.insert(n);
        }

        arr.display();
        arr.shellSort();
        arr.display();

    }
}
