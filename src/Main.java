import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        MyGraph myGraph = new MyGraph(4);
        myGraph.addEdge(0, 1);
        myGraph.addEdge(2, 3);
        myGraph.printEdge();
        System.out.println(myGraph.haveEdge(0,1));
        System.out.println(myGraph.getNeighbor(2));

        myGraph.DFS(2);
        WeightedGraph<String> graph = new WeightedGraph<>();
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");

        graph.addEdge(vertexA, vertexB, 1);
        graph.addEdge(vertexA, vertexC, 2);
        graph.addEdge(vertexB, vertexC, 3);

        DijkstraSearch<String> dijkstraSearch = new DijkstraSearch<>(graph);

        // Find the shortest paths from vertex A to all other vertices
        Vertex<String> source = vertexA;
        Map<Vertex<String>, Double> distances = dijkstraSearch.shortestPaths(source);
        System.out.println("Shortest paths from " + source + ":");
        for (Vertex<String> vertex : graph.getVertices()) {
            double distance = distances.get(vertex);
            System.out.println("To " + vertex + ": " + distance);
        }

        // Find the shortest path from vertex A to vertex C
        List<Vertex<String>> shortestPath = dijkstraSearch.shortestPathTo(source, vertexC);
        System.out.println("Shortest path from " + source + " to " + vertexC + ":");
        for (Vertex<String> vertex : shortestPath) {
            System.out.print(vertex + " ");
        }
    }

}
