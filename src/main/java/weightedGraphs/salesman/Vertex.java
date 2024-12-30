package weightedGraphs.salesman;

public class Vertex {

    public char label;
    public boolean isInTree;

    public Vertex(char label) {
        this.label = label;
        this.isInTree = false;
    }
}
