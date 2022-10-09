public class MatrixGraph {
        private final int[][] adjMatrix;
        private final int V;

        public MatrixGraph(int V) {
            this.V = V;
            adjMatrix = new int[V][V];
            for(int i=0; i<V; i++) {
                for(int j=0; j<V; j++) {
                    adjMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        public void addEdge(int i, int j, int w) {
            adjMatrix[i][j] = w;
        }

        public void removeEdge(int i, int j) {
            adjMatrix[i][j] = Integer.MAX_VALUE;
        }
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < V; i++) {
                s.append(i).append(": ");
                for (int w : adjMatrix[i]) {
                    s.append(w).append(" ");
                }
                s.append("\n");
            }
            return s.toString();
        }
        public int[][] getAdjMatrix() {
            return  adjMatrix;
        }
        public int getV() {
            return V;
    }
}
