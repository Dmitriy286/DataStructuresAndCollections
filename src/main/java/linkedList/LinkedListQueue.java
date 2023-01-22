package linkedList;

public class LinkedListQueue {
    LinkedList linkedListQueue;

    public LinkedListQueue() {
        linkedListQueue = new LinkedList();
    }

    public void insert(int value) {
        linkedListQueue.insertLast(value, 0);
    }

    public Node remove() {
        return linkedListQueue.deleteFirst();
    }

    public boolean isEmpty() {
        return linkedListQueue.isEmpty();
    }

    public void display() {
        System.out.println("Queue (first->last");
        linkedListQueue.displayLinkedList();
    }
}
