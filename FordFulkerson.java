import java.util.*;

public class FordFulkerson {
    int V = 6;
    
    boolean bfs(int residual_graph[][], int s, int t, int parent[]) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        Deque<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v = 0; v < V; v++) {
                if (visited[v] == false && residual_graph[u][v] > 0) {
                    if (v == t) {
                        parent[v] = u;
                        return true;
                    }
                    q.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return false;
    }
    
    int fordFulkerson(int graph[][], int s, int t) {
        int u, v;
        int residual_graph[][] = new int[V][V];
        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                residual_graph[u][v] = graph[u][v];
            }
        }

        int parent[] = new int[V];
        int max_flow = 0;

        while (bfs(residual_graph, s, t, parent)) {
            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, residual_graph[u][v]);
            }

            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                residual_graph[u][v] -= path_flow;
                residual_graph[v][u] += path_flow;
            }

            max_flow += path_flow;
        }
        return max_flow;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] {
                { 0, 4, 0, 3, 0, 0 },
                { 0, 0, 4, 0, 0, 0 },
                { 0, 0, 0, 3, 0, 2 },
                { 0, 0, 0, 0, 6, 0 },
                { 0, 0, 0, 0, 0, 6 },
                { 0, 0, 0, 0, 0, 0 }
        };

        FordFulkerson f = new FordFulkerson();
        System.out.println("The max flow of this network = " + f.fordFulkerson(graph, 0, 5));
    }
}
