import org.jgrapht.generate.GnmRandomGraphGenerator;
public class RandomGraph {
    private MatrixGraph AdjMatrix;
    private ListGraph AdjList;
    private int V;
    private int E;
    public RandomGraph(int V, int minWeight, int MaxWeight, int sparseness) {
        AdjMatrix =  new MatrixGraph(V);
        AdjList = new ListGraph();

    }

}
