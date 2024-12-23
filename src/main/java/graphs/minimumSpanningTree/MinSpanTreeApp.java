package graphs.minimumSpanningTree;

public class MinSpanTreeApp {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('A'); // 0
        graph.addVertex('B'); // 1
        graph.addVertex('C'); // 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4
        graph.addVertex('F'); // 5
        graph.addVertex('G'); // 6
        graph.addVertex('H'); // 7
        graph.addVertex('I'); // 8


        graph.addEdge(0, 1); // AB
        graph.addEdge(0, 2); // AC
        graph.addEdge(0, 3); // AD
        graph.addEdge(1, 4); // BE
        graph.addEdge(2, 3); // CD
        graph.addEdge(2, 4); // CE
        graph.addEdge(2, 5); // CF
        graph.addEdge(2, 6); // CG
        graph.addEdge(3, 7); // DH
        graph.addEdge(5, 8); // FI
        graph.addEdge(6, 7); // GH
        graph.addEdge(7, 8); // HI


//        graph.addEdge(0, 1); // AB
//        graph.addEdge(0, 2); // AC
//        graph.addEdge(0, 3); // AD
//        graph.addEdge(0, 4); // AE
//        graph.addEdge(1, 2); // BC
//        graph.addEdge(1, 3); // BD
//        graph.addEdge(1, 4); // BE
//        graph.addEdge(2, 3); // CD
//        graph.addEdge(2, 4); // CE
//        graph.addEdge(3, 4); // DE


        System.out.print("Minimum spanning tree: ");
        graph.bsf();
        graph.mst();
        System.out.println();
    }
}
