public class FloydWarshall {
    int V;
    int[][] graph;

    FloydWarshall(int V, int graph[][]) {
        this.V = V;
        this.graph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                this.graph[i][j] = graph[i][j];
            }
        }
    }

    public void floydWarshall() {
        for (int k = 0; k < this.V; k++) {
            for (int i = 0; i < this.V; i++) {
                for (int j = 0; j < this.V; j++) {
                    this.graph[i][j] = (int) Math.min(this.graph[i][j], (this.graph[i][k] + this.graph[k][j]));
                }
            }
        }
    }

    public void display() {
        int infinity = 10000;
        for (int i = 0; i < this.V; i++) {
            for (int j = 0; j < this.V; j++) {
                if (this.graph[i][j] == infinity) {
                    System.out.print("infinity ");
                } else {
                    System.out.print(this.graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int infinity = 10000;
        int graph[][] = {
                            { 0, 3, infinity, 7, 8 },
                            { 3, 0, 1, 4, infinity },
                            { infinity, 1, 0, 2 ,infinity},
                            { 7, 4, 2, 0, 3 },
                            { 8, infinity, infinity, 3, 0 }
                        };
        FloydWarshall f = new FloydWarshall(5, graph);
        f.floydWarshall();
        f.display();
    }
}