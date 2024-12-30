package weightedGraphs.vertexAdjecency;

public class Graph {

    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex[] vertexList;
    private int nVerts;
    private int nTree;
    private DistanceParent[] sPath;
    private int currentVert;
    private int startToCurrent;


    public Graph() {

        vertexList = new Vertex[MAX_VERTS];
        nVerts = 0;
        nTree = 0;

        sPath = new DistanceParent[MAX_VERTS];
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label, MAX_VERTS);
    }

    public void addEdge(int start, int end, int weight) {

        Edge edge = new Edge();
        edge.endVertex = end;
        edge.weight = weight;

        if (vertexList[start].edges[end] == null) {
            vertexList[start].edges[end] = edge;
        }
    }

    public void path() {

        int startTree = 0;
        vertexList[startTree].isInTree = true;
        nTree = 1;

        for (int i = 0; i < nVerts; i++) {

            int tempDist = vertexList[startTree].edges[i] == null ? INFINITY : vertexList[startTree].edges[i].weight;

            sPath[i] = new DistanceParent(startTree, tempDist);
        }

        while (nTree < nVerts) {

            int indexMin = getMin();
            int minDist = sPath[indexMin].distance;

            if (minDist == INFINITY) {

                System.out.println("There are unreachable vertices");
                break;

            } else {

                currentVert = indexMin;
                startToCurrent = sPath[indexMin].distance;
            }

            vertexList[currentVert].isInTree = true;
            nTree++;

            adjustSPath();
        }

        displayPaths();

        nTree = 0;

        for (int i = 0; i < nVerts; i++) {
            vertexList[i].isInTree = false;
        }
    }

    private int getMin() {

        int minDist = INFINITY;
        int indexMin = 0;

        for (int i = 0; i < nVerts; i++) {
            if (!vertexList[i].isInTree && sPath[i].distance < minDist) {

                minDist = sPath[i].distance;
                indexMin = i;
            }
        }

        return indexMin;
    }

    private void adjustSPath() {

        int column = 1;

        while (column < nVerts) {

            if (vertexList[column].isInTree) {
                column++;
                continue;
            }

            int currentToFringe = vertexList[currentVert].edges[column] == null ? INFINITY : vertexList[currentVert].edges[column].weight;

            int startToFringe = startToCurrent + currentToFringe;

            int sPathDistance = sPath[column].distance;

            if (startToFringe < sPathDistance) {
                sPath[column].parentVert = currentVert;
                sPath[column].distance = startToFringe;
            }

            column++;
        }
    }

    private void displayPaths() {

        for (int i = 0; i < nVerts; i++) {
            System.out.print(vertexList[i].label + "=");

            if (sPath[i].distance == INFINITY) {
                System.out.print("inf");
            } else {
                System.out.print(sPath[i].distance);
            }

            char parent = vertexList[sPath[i].parentVert].label;
            System.out.print("(" + parent + ") ");
        }

        System.out.println();
    }

    public void transitiveClosure() {

        for (int row = 0; row < nVerts; row++) {

            for (int column = 0; column < nVerts; column++) {

                if (vertexList[row].edges[column] != null) {

                    for (int cellInColumn = 0; cellInColumn < nVerts; cellInColumn++) {

                        if (vertexList[cellInColumn].edges[row] != null) {

                            if (vertexList[cellInColumn].edges[column] == null) {
                                vertexList[cellInColumn].edges[column] = new Edge();
                            }

                            vertexList[cellInColumn].edges[column].weight = vertexList[row].edges[column].weight + vertexList[cellInColumn].edges[row].weight;
                        }
                    }
                }

            }
        }

        printAdjMatrix();
    }

    public void printAdjMatrix() {

        for (int i = 0; i < nVerts; i++) {
            System.out.print(vertexList[i].label + "| ");
            for (int j = 0; j < nVerts; j++) {
                if (vertexList[i].edges[j] == null) {
                    System.out.print("X ");
                } else {
                    System.out.print(vertexList[i].edges[j].weight + " ");
                }
            }

            System.out.println();
        }
    }
}
