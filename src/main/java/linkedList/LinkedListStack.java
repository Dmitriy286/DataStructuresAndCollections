package linkedList;

public class LinkedListStack {
    private LinkedList stackLinkedList;

    public LinkedListStack() {
        stackLinkedList = new LinkedList();
    }

    public void push(int value) {
        stackLinkedList.insertFirst(value, 0.0);
    }

    public Node pop() {
        return stackLinkedList.deleteFirst();
    }

    public boolean isEmpty() {
        return stackLinkedList.isEmpty();
    }

    public void display() {
        System.out.println("Stack (top->bottom):");
        stackLinkedList.displayLinkedList();
    }
}
