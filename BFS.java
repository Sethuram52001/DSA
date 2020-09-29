import java.util.*;
import java.util.LinkedList;

public class BFS{
    static class Graph {
        int V;
        LinkedList<Integer>[] adj;

        Graph(int V) {
            this.V = V;
            adj = new LinkedList[V];

            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<Integer>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }
    }

    static void bfs(int s, int V, LinkedList<Integer>[] adj) {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            s = q.poll();
            //st.pop();

            if (visited[s] == false) {
                System.out.println(s + " ");
                visited[s] = true;
            }

            Iterator<Integer> itr = adj[s].iterator();
            while (itr.hasNext()) {
                int v = itr.next();
                if (!visited[v]) {
                    q.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(5, 7);
        g.addEdge(3, 6);
        g.addEdge(6, 8);
        int V = g.V;
        LinkedList<Integer>[] adj = g.adj;
        bfs(1, V, adj);
    }
}