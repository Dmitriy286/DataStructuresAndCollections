package linkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public LinkedList(int[] valueArray) {
        this();
        for (int i = 0; i < valueArray.length; i++) {
            sortingInsertFromLafore(valueArray[i]);
        }

    }

    public int size() {
        return length;
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

        length++;
    }

    public void insertLast(int intData, double doubleData) {
        Node newNode = new Node(intData, doubleData);
        if (isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;

        length++;
    }

    public void sortingInsert(int intData) {
        Node newNode = new Node(intData, 0);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;

        } else if (intData < this.head.getIntData()) {
            newNode.setNext(this.head);
            this.head = newNode;
        } else if (intData > this.tail.getIntData()) {
            this.tail.setNext(newNode);
            this.tail = newNode;
        } else {
            Node current = this.head.getNext();
            Node previous = this.head;
            while (current != null) {
                if (current.getIntData() > newNode.getIntData()) {
                    previous.setNext(newNode);
                    newNode.setNext(current);
                    break;
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
        }

        length++;
    }

    public void sortingInsertFromLafore(int intData) {
        Node newNode = new Node(intData, 0);
        Node previous = null;
        Node current = this.head;

        while (current != null && intData > current.getIntData()) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) {
            this.head = newNode;
        } else {
            previous.setNext(newNode);
        }
        newNode.setNext(current);

        length++;
    }

    public Node deleteFirst() {
        Node temp = this.head;
        if (this.head.getNext() == null) {
            this.tail = null;
        }
        this.head = head.getNext();

        length--;

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

        length--;

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
