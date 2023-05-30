public class Main {
    public static void main(String[] args) {

        MyGraph myGraph = new MyGraph(4);
        myGraph.addEdge(0, 1);
        myGraph.addEdge(2, 3);
        myGraph.printEdge();
        System.out.println(myGraph.HaveEdge(0,1));
    }
}
