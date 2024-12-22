package heap.priorityQueue;

public class PriorityQueueApp {
    public static void main(String[] args) {
        priorityQueue();
    }

    private static void priorityQueue() {
        PriorityQueue priorityQueue = new PriorityQueue(5);

        priorityQueue.insert(30);
        priorityQueue.insert(50);
        priorityQueue.insert(10);
        priorityQueue.insert(40);
        priorityQueue.insert(20);
        priorityQueue.insert(5);

        System.out.println(priorityQueue.peekMax());

        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.remove() + " ");
        }

        System.out.println();
    }
}
