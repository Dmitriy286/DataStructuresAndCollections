package weightedGraphs.floyd;

public class App {

    public static void main(String[] args) {
        Graph graph = new Graph();

//        graph.addVertex('A');
//        graph.addVertex('B');
//        graph.addVertex('C');
//        graph.addVertex('D');
//        graph.addVertex('E');

//        graph.addEdge(0, 1, 50); //AB
//        graph.addEdge(0, 3, 80); //AD
//        graph.addEdge(1, 2, 60); //BC
//        graph.addEdge(1, 3, 90); //BD
//        graph.addEdge(2, 4, 40); //CE
//        graph.addEdge(3, 2, 20); //DC
//        graph.addEdge(3, 4, 70); //DE
//        graph.addEdge(4, 1, 50); //EB


        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(1, 0, 70); //BA
        graph.addEdge(1, 3, 10); //BD
        graph.addEdge(3, 2, 20); //DC
        graph.addEdge(2, 0, 30); //CA


//        System.out.println("Shortest paths");
//        graph.path();
//        System.out.println();

//        graph.printAdjMatrix();
        graph.transitiveClosure();
    }
}
