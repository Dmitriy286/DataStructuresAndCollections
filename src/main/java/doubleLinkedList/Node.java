package doubleLinkedList;

public class Node {
    public long value;
    public Node next;
    public Node previous;

    public Node(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node value: " + value;
    }
}
