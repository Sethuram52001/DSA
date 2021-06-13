import java.util.*;

public class Prim_MST {
    int infinity = Integer.MAX_VALUE;

    public void Prim(int graph[][], int V) {
        int no_edge = 0;
        boolean selected[] = new boolean[V];
        Arrays.fill(selected, false);
        selected[0] = true;
        System.out.println("Edge : Weight");
        while (no_edge < V - 1) {
            int min = infinity;
            int x = 0;
            int y = 0;

            for (int i = 0; i < V; i++) {
                if (selected[i] == true) {
                    for (int j = 0; j < V; j++) {
                        if (!selected[j] && graph[i][j] != 0) {
                            if (min > graph[i][j]) {
                                min = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + " : " + graph[x][y]);
            selected[y] = true;
            no_edge++;
        }
    }

    public static void main(String[] args) {
        Prim_MST p = new Prim_MST();
        int V = 6;
        int[][] G = {   {0, 2, 3, 0, 0, 0},
                        {2, 0, 5, 3, 4, 0},
                        {3, 5, 0, 0, 4, 0},
                        {0, 3, 0, 0, 2, 3},
                        {0, 4, 4, 2, 0, 5},
                        {0, 0, 3, 0, 0, 0}
                    };
        p.Prim(G, V);
    }
}