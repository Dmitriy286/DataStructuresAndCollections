package weightedGraphs.salesman;

public class Graph {

    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int nVerts;

    private int count;
    private int minLength;
    private int[] minPath;
    private int[] initArray;


    public Graph() {

        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMatrix[i][j] = INFINITY;
            }
        }
    }

    public void salesManPath() {

        minLength = INFINITY;
        minPath = new int[nVerts + 1];

        initArray = new int[nVerts];

        for (int i = 0; i < nVerts; i++) {
            initArray[i] = i;
        }

        doAnagram(nVerts, 0);

        System.out.println("Min path is: " + minLength);

        for (int i = 0; i < nVerts + 1; i++) {
            System.out.print(vertexList[minPath[i]].label);
        }
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end, int weight) {
        adjMatrix[start][end] = weight;
        adjMatrix[end][start] = weight;
    }

    public void calculatePath(int[] path, int index) {

        int[] pathForCalculate = new int[path.length + 1];

        for (int i = 0; i < path.length; i++) {
            pathForCalculate[i] = path[i];
        }

        pathForCalculate[pathForCalculate.length - 1] = path[0];

        int sum = 0;

        for (int i = 0; i < nVerts + 1; i++) {
            System.out.print(vertexList[pathForCalculate[i]].label);
        }

        System.out.print("   ");

        for (int i = 0; i < pathForCalculate.length - 1; i++) {

            if (adjMatrix[pathForCalculate[i]][pathForCalculate[i + 1]] == INFINITY) {
                System.out.println("Can not create a path");
                return;
            }

            sum += adjMatrix[pathForCalculate[i]][pathForCalculate[i + 1]];
        }

        System.out.println("sum: " + sum);

        if (sum < minLength) {
            minLength = sum;
            minPath = pathForCalculate;
        }
    }

    private void doAnagram(int newSize, int index) {

        if (newSize == 1) {
            return;
        }

        for (int i = 0; i < newSize; i++) {

            doAnagram(newSize - 1, index);

            if (newSize == 2) {
                calculatePath(initArray, index);
            }

            rotate(newSize);
        }
    }

    private void displayWord() {

        if (count < 99) {
            System.out.print(" ");
        }

        if (count < 9) {
            System.out.print(" ");
        }

        System.out.print(++count + " ");

        for (int i = 0; i < nVerts + 1; i++) {
            System.out.print(vertexList[initArray[i]].label);
        }

        System.out.print("    ");
        System.out.flush();

        if (count % 6 == 0) {
            System.out.println();
        }
    }

    private void rotate(int newSize) {

        int i;

        int position = nVerts - newSize;

        int temp = initArray[position];

        for (i = position + 1; i < nVerts; i++) {
            initArray[i - 1] = initArray[i];
        }

        initArray[i - 1] = temp;
    }
}
