package graphs.minimumSpanningTree;

public class Vertex {

    public char label;
    public  boolean wasVisited;

    public Vertex(char label) {
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
