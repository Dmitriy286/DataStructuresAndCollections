package weightedGraphs.hamiltonCycles;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        Graph graph = new Graph();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1, 91); //AB
        graph.addEdge(0, 2, 62); //AC
        graph.addEdge(0, 3, 55); //AD
        graph.addEdge(1, 2, 44); //BC
        graph.addEdge(1, 4, 31); //BE
        graph.addEdge(2, 3, 52); //CD
        graph.addEdge(2, 4, 45); //CE
        graph.addEdge(3, 4, 83); //DE

        graph.searchForCycle();
    }
}