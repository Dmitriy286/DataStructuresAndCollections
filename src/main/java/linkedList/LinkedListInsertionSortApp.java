package linkedList;

import java.util.HashSet;
import java.util.Random;

public class LinkedListInsertionSortApp {
    public static void main(String[] args) {
        int size = 10;
        int[] valueArray = new int[size];

        for (int i = 0; i < size; i++) {
            int n = new Random().nextInt(100);
            valueArray[i] = n;

            HashSet set = new HashSet<>();
        }

        System.out.println("Unsorted array:");
        for (int i = 0; i < size; i++) {
            System.out.print(valueArray[i] + " ");
        }
        System.out.println();

        LinkedList sortedLinkedList = new LinkedList(valueArray);

        for (int i = 0; i < size; i++) {
            valueArray[i] = sortedLinkedList.deleteFirst().getIntData();
        }

        System.out.println("Sorted array:");
        for (int i = 0; i < size; i++) {
            System.out.print(valueArray[i] + " ");
        }
        System.out.println();
    }
}
