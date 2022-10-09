import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Vertices:\n");
        int V = sc.nextInt();
        System.out.println("sparseness(0.00 to 1.00) :");
        float Spareness = sc.nextFloat();
        RandomGraph graph = new RandomGraph(V, Spareness);
        MatrixGraph adjMatrix = graph.getAdjMatrix();
        int e = graph.getE();
        System.out.println(e);
        String s = adjMatrix.toString();
        //System.out.println(s);
        long start = System.nanoTime();
        dijkstra(adjMatrix, 0);
        long end  = System.nanoTime() - start;
        double elapsedTimeInSecond = (double) end / 1_000_000_000;
        System.out.println("Time Taken: " + elapsedTimeInSecond+ " seconds");
    }
    public static void dijkstra(MatrixGraph graph,  int src) {
        int V = graph.getV();
        int[][] matrix = graph.getAdjMatrix();
        int[] pathArray = new int[V];
        Boolean[] sptSet = new Boolean[V];
        for(int i=0; i < V; i++) {
            pathArray[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        pathArray[src] = 0;
        for(int i =0; i < V-1; i++) {
            int current = minDistanceCompare(pathArray, sptSet, V);
            sptSet[current] = true;
            for(int v = 0; v < V; v++) {
                if(!sptSet[v] && matrix[current][v] !=Integer.MAX_VALUE
                        && pathArray[current] != Integer.MAX_VALUE
                        && pathArray[current] + matrix[current][v] < pathArray[v]) {
                    pathArray[v] = pathArray[current] + matrix[current][v];

                }
            }

        }
        printMinpath(pathArray, V);

    }
    public static int minDistanceCompare(int[] pathArray, Boolean[] sptSet, int V) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int v=0; v<V; v++) {
            if(!sptSet[v] && pathArray[v] <= min) {
                min = pathArray[v];
                min_index = v;
            }
        }
        return min_index;

    }
    public  static void printMinpath(int[] PathArray, int V) {
        System.out.println("Vertex# \t Minimun Distance form source");
        for(int i =0; i < V; i++) {
            System.out.println(i+ " \t\t\t" + PathArray[i]);

        }
    }
}
