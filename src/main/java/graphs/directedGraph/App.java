package graphs.directedGraph;

public class App {

    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addVertex('A'); // 0
        graph.addVertex('B'); // 1
        graph.addVertex('C'); // 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4


        graph.addEdge(1, 0); // BA
        graph.addEdge(1, 4); // BE
        graph.addEdge(3, 4); // DE
        graph.addEdge(0, 2); // AC
        graph.addEdge(4, 2); // EC


        graph.display();

        System.out.println("Connectivity table: ");
        graph.dfs();
    }
}
