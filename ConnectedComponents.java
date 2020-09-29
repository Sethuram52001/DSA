import java.util.*;
import java.util.LinkedList;

public class ConnectedComponents{
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

    static void DFS(int v, boolean visited[], LinkedList<Integer>[] adj){
        visited[v] = true;
        System.out.println(v + " ");
        
        for(int i : adj[v]){
            if(!visited[i])
            DFS(i, visited, adj);
        }
    }
    
    static void connectedComponents(int V, LinkedList<Integer>[] adj){
        boolean visited[] = new boolean[V];
        for(int v=0;v<V;v++){
            if(!visited[v]){
                DFS(v, visited, adj);
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        System.out.println("Following are connected components");
        int V = g.V;
        LinkedList<Integer> adj[] = g.adj;
        connectedComponents(V,adj);
    }
}