package graphs.knightMove;

public class Knight {

    public char label;
    public  boolean wasVisited;

    public Knight(char label) {
        this.label = label;
        this.wasVisited = false;
    }

    public void display() {
        System.out.print(label);
    }

    @Override
    public String toString() {
        return "[" +
                label +
                ", " + wasVisited +
                ']';
    }
}
