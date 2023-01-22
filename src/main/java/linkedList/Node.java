package linkedList;

public class Node {
    private int intData;
    private double doubleData;
    private Node next;

    public Node(int intData, double doubleData) {
        this.intData = intData;
        this.doubleData = doubleData;
    }

    public int getIntData() {
        return this.intData;
    }

    public void setIntData(int intData) {
        this.intData = intData;
    }

    public double getDoubleData() {
        return this.doubleData;
    }

    public void setDoubleData(double doubleData) {
        this.doubleData = doubleData;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "{" + intData + "; " + doubleData + "}";
    }
}
