import java.io.*;
import java.util.*;;

class DigraphDFS {
    private int V;
    private LinkedList<Integer> adj[];
    private boolean[] visited;

    DigraphDFS(int V) {
        this.V = V;
        this.adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
        this.visited = new boolean[V];
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFS(n);
            }
        }
    }

    public static void main(String[] args) {
        DigraphDFS g = new DigraphDFS(7);
        g.addEdge(0, 1);
        g.addEdge(0, 5);
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 3);
        System.out.println("Following is Depth First Traversal "+"(starting from vertex 2)");
        g.DFS(2);
    }
}
