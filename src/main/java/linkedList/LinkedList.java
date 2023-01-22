package linkedList;

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertFirst(int intData, double doubleData) {
        Node newNode = new Node(intData, doubleData);
        if (isEmpty()) {
            this.tail = newNode;
        }
        newNode.setNext(head);
        this.head = newNode;
    }

    public void insertLast(int intData, double doubleData) {
        Node newNode = new Node(intData, doubleData);
        if (isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    public Node deleteFirst() {
        Node temp = this.head;
        if (this.head.getNext() == null) {
            this.tail = null;
        }
        this.head = head.getNext();
        return temp;
    }

    public Node find(int value) {
        Node foundNode = this.head;
        while (foundNode.getIntData() != value) {
            if (foundNode.getNext() == null) {
                return null;
            } else {
                foundNode = foundNode.getNext();
            }
        }
        return foundNode;
    }

    public Node delete(int value) {
        Node currentNode = this.head;
        Node previous = this.head;
        while (currentNode.getIntData() != value) {
            if (currentNode.getNext() == null) {
                return null;
            } else {
                previous = currentNode;
                currentNode = currentNode.getNext();
            }
        }

        if (currentNode == this.head) {
            this.head = this.head.getNext();
        } else {
            previous.setNext(currentNode.getNext());
        }
        return currentNode;
    }

    public void displayLinkedList() {
        System.out.print("List (first --> last): ");
        Node current = this.head;
        while (current != null) {
            System.out.print(current);
            System.out.print(" --> ");
            current = current.getNext();
        }
        System.out.print("null");
        System.out.println();
    }
}
