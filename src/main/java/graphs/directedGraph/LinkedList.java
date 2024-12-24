package graphs.directedGraph;

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

    public void insert(int end, Vertex vertex) {
        Node newNode = new Node(vertex);
        newNode.setIntData(end);
        if (isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
    }

    public Node find() {

        Node foundNode = this.head;

        if (foundNode == null) {
            return null;
        }

        while (foundNode.getVertex().wasVisited == true) {
            if (foundNode.getNext() == null) {
                return null;
            } else {
                foundNode = foundNode.getNext();
            }
        }
        return foundNode;
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