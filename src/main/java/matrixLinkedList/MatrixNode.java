package matrixLinkedList;

public class MatrixNode {

    private String value;
    private MatrixNode nextRight;
    private MatrixNode nextDown;

    public MatrixNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MatrixNode getNextRight() {
        return nextRight;
    }

    public void setNextRight(MatrixNode nextRight) {
        this.nextRight = nextRight;
    }

    public MatrixNode getNextDown() {
        return nextDown;
    }

    public void setNextDown(MatrixNode nextDown) {
        this.nextDown = nextDown;
    }

    @Override
    public String toString() {
        return "{" +
                value +
                "} ";
    }
}
