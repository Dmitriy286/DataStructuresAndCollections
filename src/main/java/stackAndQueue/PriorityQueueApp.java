package stackAndQueue;

import linkedList.SortedLinkedListPriorityQueue;

public class PriorityQueueApp {
    public static void main(String[] args) {
        arrayPriorityQueue();

        linkedListPriorityQueue();
    }

    private static void linkedListPriorityQueue() {

        SortedLinkedListPriorityQueue priorityQueue = new SortedLinkedListPriorityQueue(5);

        priorityQueue.insert(30);
        priorityQueue.insert(50);
        priorityQueue.insert(10);
        priorityQueue.insert(40);
        priorityQueue.insert(20);
        priorityQueue.insert(5);

        priorityQueue.print();

        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.peek());



        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.remove() + " ");
        }
        System.out.println();
    }

    private static void arrayPriorityQueue() {
        PriorityQueue priorityQueue = new PriorityQueue(5);

        priorityQueue.insert(30);
        priorityQueue.insert(50);
        priorityQueue.insert(10);
        priorityQueue.insert(40);
        priorityQueue.insert(20);
        priorityQueue.insert(5);

        System.out.println(priorityQueue.peekMin());

        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.remove() + " ");
        }

        System.out.println();
    }
}
