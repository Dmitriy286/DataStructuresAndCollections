package graphs.knightMove;

public class Node {
    private int intData;
    private double doubleData;
    private Node next;

    private boolean wasVisited;

    private Knight knight;

    public Node(int intData, double doubleData) {
        this.intData = intData;
        this.doubleData = doubleData;
        this.wasVisited = false;
    }

    public Node(Knight knight) {
        this.knight = knight;
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

    public boolean wasVisited() {
        return wasVisited;
    }

    public void setVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public Knight getVertex() {
        return knight;
    }

    public void setVertex(Knight knight) {
        this.knight = knight;
    }

    @Override
    public String toString() {
        return "{" + intData + "}";
    }
}
