import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGraph {

    public ListGraph getAdjList() {
        return AdjList;
    }

    public MatrixGraph getAdjMatrix() {
        return AdjMatrix;
    }

    public int getE() {
        return E;
    }

    public void setE(int e) {
        E = e;
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    static class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    private final MatrixGraph AdjMatrix;
    private final ListGraph AdjList;
    private int V;
    private int E;

    Random random = new Random();

    // constructor
    public RandomGraph(int V, float sparseness) {
        this.AdjMatrix =  new MatrixGraph(V);
        this.AdjList = new ListGraph();
        List<Edge> graph = graphGenerator(V, sparseness);
        for(Edge edge: graph) {
            this.AdjMatrix.addEdge(edge.src, edge.dest, edge.weight);
        }
        this.V = V;
        this.E = graph.size();
    }
    // graph generator that returns  a list of edges in the graph.
    public List<Edge> graphGenerator(int V, float sparseness) {
        List<Edge> graph  = new ArrayList<>(V);
        for(int i=0; i< V; i++) {
            for(int j = 0; j< V; j++) {
                float edgeProb = random.nextFloat();
                if(edgeProb < sparseness && i != j) graph.add(new Edge(i,j, random.nextInt(V)+1));
            }
        }
        return graph;

    }

}
