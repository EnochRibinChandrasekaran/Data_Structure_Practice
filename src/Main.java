
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNodes("A");
        graph.addNodes("B");
        graph.addNodes("P");
        graph.addNodes("X");
        graph.addEdge("X", "B");
        graph.addEdge("X", "A");
        graph.addEdge("A", "P");
        graph.addEdge("B", "P");
        graph.print();
        System.out.println(graph.topologicalSorting());


    }
}
