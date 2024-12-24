package graphs.directedGraph;


public class Graph {

    private final int MAX_VERTEX = 20;
    private Vertex[] vertexList;
    private LinkedList[] adjList;
    private int nVerts;
    private StackX stack;


    private int initVertex = 0;

    public Graph() {
        vertexList = new Vertex[MAX_VERTEX];

        adjList = new LinkedList[MAX_VERTEX];

        for (int i = 0; i < MAX_VERTEX; i++) {
            adjList[i] = new LinkedList();
        }

        nVerts = 0;

        stack = new StackX();
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjList[start].insert(end, vertexList[end]);
    }

    public void display() {
        for (int i = 0; i < adjList.length; i++) {

            if (vertexList[i] != null) {
                System.out.print(vertexList[i].label + ": ");
                adjList[i].displayLinkedList();
            }
        }
    }

    public void dfs() {

        for (int vertex = 0; vertex < nVerts; vertex++) {

            vertexList[vertex].wasVisited = true;
            vertexList[vertex].display();

            stack.push(vertex);

            while (!stack.isEmpty()) {

                int nextVertex = getAdjUnvisitedVertex(stack.peek());

                if (nextVertex == -1) {
                    stack.pop();
                } else {
                    vertexList[nextVertex].wasVisited = true;
                    vertexList[nextVertex].display();
                    stack.push(nextVertex);
                }
            }

            System.out.println();

            for (int i = 0; i < nVerts; i++) {
                vertexList[i].wasVisited = false;
            }
        }
    }

    private int getAdjUnvisitedVertex(int currentVertex) {

        Node foundNode = adjList[currentVertex].find();

        if (foundNode != null && foundNode.getVertex().wasVisited == false) {
            return foundNode.getIntData();
        }

        return -1;
    }
}
