import java.io.*;
import java.util.*;

public class DigraphBFS {
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
        }
    }

    static void BFS(int s, int V, LinkedList<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            s = q.poll();
            if (visited[s] == false) {
                System.out.println(s + " ");
                visited[s] = true;
            }

            Iterator<Integer> itr = adj[s].iterator();
            while (itr.hasNext()) {
                int v = itr.next();
                if(!visited[v])
                    q.add(v);
            }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 1);
        g.addEdge(4, 0);
        g.addEdge(4, 5);
        System.out.println("Following is Breadth First Traversal "+"(starting from vertex 0)");
        BFS(0,g.V,g.adj);
    }
}
