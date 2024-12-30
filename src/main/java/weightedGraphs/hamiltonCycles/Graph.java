package weightedGraphs.hamiltonCycles;

public class Graph {

    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int nVerts;

    private int count;
    private int index;
    private int[][] cycles;
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

    public void searchForCycle() {

        cycles = new int[10000][nVerts + 1];

        for (int i = 0; i < cycles.length; i++) {
            cycles[i] = null;
        }

        initArray = new int[nVerts];

        for (int i = 0; i < nVerts; i++) {
            initArray[i] = i;
        }

        doAnagram(nVerts);

        System.out.println("Cycles: ");

        int i = 0;

        while (true) {

            if (cycles[i] != null) {

                for (int j = 0; j < nVerts + 1; j++) {
                    System.out.print(vertexList[cycles[i][j]].label);
                }

                System.out.println();
            } else {
                break;
            }

            i++;
        }
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end, int weight) {
        adjMatrix[start][end] = weight;
        adjMatrix[end][start] = weight;
    }

    public void calculatePath(int[] path) {

        int[] pathForCalculate = new int[path.length + 1];

        for (int i = 0; i < path.length; i++) {
            pathForCalculate[i] = path[i];
        }

        pathForCalculate[pathForCalculate.length - 1] = path[0];

        for (int i = 0; i < pathForCalculate.length - 1; i++) {

            if (adjMatrix[pathForCalculate[i]][pathForCalculate[i + 1]] == INFINITY) {

                return;
            }
        }

        cycles[index] = pathForCalculate;
        index++;
    }

    private void doAnagram(int newSize) {

        if (newSize == 1) {
            return;
        }

        for (int i = 0; i < newSize; i++) {

            doAnagram(newSize - 1);

            if (newSize == 2) {
//                displayWord();
                calculatePath(initArray);
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

        for (int i = 0; i < nVerts; i++) {
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
