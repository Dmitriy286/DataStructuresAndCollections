package graphs.minimumSpanningTree;

public class Graph {

    private final int MAX_VERTEX = 20;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int nVerts;
    private Queue queue;


    private int initVertex = 0;

    public Graph() {
        vertexList = new Vertex[MAX_VERTEX];
        adjMatrix = new int[MAX_VERTEX][MAX_VERTEX];
        nVerts = 0;

        for (int i = 0; i < MAX_VERTEX; i++) {
            for (int j = 0; j < MAX_VERTEX; j++) {
                adjMatrix[i][j] = 0;
            }
        }

        queue = new Queue();
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void mst() {
        vertexList[initVertex].wasVisited = true;

        queue.insert(initVertex);

        int nextVertex;

        while (!queue.isEmpty()) {
            int currentVertex = queue.remove();

            while ((nextVertex = getAdjUnvisitedVertex(currentVertex)) != -1) {

                vertexList[nextVertex].wasVisited = true;
                vertexList[currentVertex].display();
                vertexList[nextVertex].display();
                System.out.print("  ");

                queue.insert(nextVertex);
            }
        }

        System.out.println();

        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void bsf() {
        vertexList[initVertex].wasVisited = true;
        vertexList[initVertex].display();

        queue.insert(initVertex);

        int nextVertex;

        while (!queue.isEmpty()) {
            int currentVertex = queue.remove();

            while ((nextVertex = getAdjUnvisitedVertex(currentVertex)) != -1) {

                vertexList[nextVertex].wasVisited = true;
                vertexList[nextVertex].display();
                queue.insert(nextVertex);
            }
        }

        System.out.println();

        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    private int getAdjUnvisitedVertex(int currentVertex) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMatrix[currentVertex][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }

        return -1;
    }
}
