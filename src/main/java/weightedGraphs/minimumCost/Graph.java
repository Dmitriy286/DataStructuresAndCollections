package weightedGraphs.minimumCost;

public class Graph {

    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int nVerts;
    private int nTree;
    private DistanceParent[] sPath;
    private int currentVert;
    private int startToCurrent;


    public Graph() {

        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        nTree = 0;

        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMatrix[i][j] = INFINITY;
            }
        }

        sPath = new DistanceParent[MAX_VERTS];
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end, int weight) {
        adjMatrix[start][end] = weight;
    }

    public void path() {

        for (int startVert = 0; startVert < nVerts; startVert++) {

            vertexList[startVert].isInTree = true;
            nTree = 1;

            for (int i = 0; i < nVerts; i++) {
                int tempDist = adjMatrix[startVert][i];
                sPath[i] = new DistanceParent(startVert, tempDist);
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

            int currentToFringe = adjMatrix[currentVert][column];

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
}