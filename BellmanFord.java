import java.util.*;

// adjacency list representation of weighted matrix
class Graph {
    int V, E;
    WeightedEdge edge[];
        
    // weighted edge
    class WeightedEdge {
        int u, v, weight;

        WeightedEdge() {
            this.u = 0;
            this.v = 0;
            this.weight = 0;
        }

        WeightedEdge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
    
    Graph(int V, int E) {
        this.V = V;
        this.E = E;
        edge = new WeightedEdge[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new WeightedEdge();
        }
    }
}

public class BellmanFord {

    public void bellmanFord(Graph g, int source) {
        int V = g.V, E = g.E;
        int dist[] = new int[E];

        for (int i = 0; i < V; i++) {
            // initially all vertices from the sources are infinity, as the paths hasn't been explored yet
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;

        // now relaxing all the edges V - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < E; j++) {
                int u = g.edge[j].u;
                int v = g.edge[j].v;
                int weight = g.edge[j].weight;

                // condition for relaxation
                if ((dist[u] != Integer.MAX_VALUE) && (dist[u] + weight < dist[v])) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // checking for negative cycles
        // bellman ford doesn't work on negative weighted cycles as it can
        // be relaxed to perpetuity
        for (int j = 0; j < E; j++) {
            int u = g.edge[j].u;
            int v = g.edge[j].v;
            int weight = g.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println(
                        "This graph contains negative weighted cycles, where Bellman Ford algorithm doesn't work well as the edges in that cycle can be relaxed to perpetuity");
                return;
            }
        }
        display(dist, V);
    }

    public void display(int dist[], int V) {
        System.out.println("Shortest path from single source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }
    
    public static void main(String[] args) {
        int V = 4;
        int E = 5;

        Graph g = new Graph(V, E);
        // add edge 1->2
        g.edge[0].u = 1;
        g.edge[0].v = 2;
        g.edge[0].weight = 4;
  
        // add edge 1->4
        g.edge[1].u = 1;
        g.edge[1].v = 4;
        g.edge[1].weight = 5;
  
        // add edge 4->3
        g.edge[2].u = 4;
        g.edge[2].v = 3;
        g.edge[2].weight = 3;
  
        // add edge 3->2
        g.edge[3].u = 3;
        g.edge[3].v = 2;
        g.edge[3].weight = -10;
  
        // add edge 2->4 
        g.edge[4].u = 2;
        g.edge[4].v = 4;
        g.edge[4].weight = 5;
  
        
        BellmanFord obj = new BellmanFord();
        obj.bellmanFord(g, 1);
    }
}