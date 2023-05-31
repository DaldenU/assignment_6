import java.util.LinkedList;

public class MyGraph {
    private int numOfVertices;
    private LinkedList<Integer>[] adgList;

    // Constructs a MyGraph object with the specified number of vertices.
    public MyGraph(int numOfVertices){
        this.numOfVertices = numOfVertices;
        adgList = new LinkedList[numOfVertices];
        for(int i = 0; i < numOfVertices; i++){
            adgList[i] = new LinkedList<>();
        }
    }

    // Adds an edge between the source and destination vertices.
    public void addEdge(int source, int destination){
        validateVertex(source);
        validateVertex(destination);
        adgList[source].add(destination);
        adgList[destination].add(source);
    }

    // Validates the given vertex index.
    private void validateVertex(int index){
        if(index < 0 || index > numOfVertices){
            throw new IllegalArgumentException("Vertex "+ index + " is out of range");
        }
    }

    // Prints the edges of each vertex in the graph.
    public void printEdge(){
        for(int i = 0; i < numOfVertices; i++){
            System.out.print("Vertex number " + i +" is connected to: ");
            for(int neighbor : adgList[i]){
                System.out.println(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Removes the edge between the source and destination vertices.
    public void removeEdge(int source, int destination){
        validateVertex(source);
        validateVertex(destination);
        adgList[source].remove(destination);
        adgList[destination].remove(source);
    }

    // Checks if there is an edge between the source and destination vertices.
    public boolean haveEdge(int source, int destination){
        validateVertex(source);
        validateVertex(destination);
        return adgList[source].contains(destination);
    }

    // Returns the neighbors of the specified vertex.
    public LinkedList<Integer> getNeighbor(int vertex){
        validateVertex(vertex);
        return adgList[vertex];
    }

    // Performs Depth-First Search starting from the specified startVertex.
    public void DFS(int startVertex){
        validateVertex(startVertex);
        boolean[] visited = new boolean[numOfVertices];
        DFSHelper(startVertex, visited);
    }

    // Helper method for Depth-First Search traversal.
    private void DFSHelper(int vertex, boolean[] visited){
        visited[vertex] = true;
        System.out.println(vertex + " ");
        for(int neighbor : adgList[vertex]){
            if(!visited[vertex]){
                DFSHelper(neighbor, visited);
            }
        }
    }

}