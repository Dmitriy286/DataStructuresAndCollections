package weightedGraphs.vertexAdjecency;

import java.util.List;

public class Vertex {

    public char label;
    public boolean isInTree;

    public Edge[] edges;

    public Vertex(char label, int edges) {
        this.label = label;
        this.isInTree = false;
        this.edges = new Edge[edges];
    }
}
