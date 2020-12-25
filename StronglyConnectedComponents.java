import java.util.*;

public class StronglyConnectedComponents {
    class Graph {
        int V;
        ArrayList<ArrayList<Integer> > adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<ArrayList<Integer> >(V); 
            for (int i = 0; i < V; ++i) 
                adj.add(new ArrayList<Integer>()); 
        }

        void addEdge(int v, int w) {
            adj.get(v).add(w);
        }

        void DFShelper(int v, boolean visited[]) {
            visited[v] = true;
            System.out.println(v + " ");
            int n;
            Iterator<Integer> i = adj.get(v).iterator();
            while (i.hasNext()) {
                n = i.next();
                if (!visited[n])
                    DFShelper(n, visited);
            }
        }
        
        Graph getTranspose() {
            Graph g = new Graph(V);
            for (int v = 0; v < V; v++) {
                Iterator<Integer> i = adj.get(v).listIterator();
                while (i.hasNext()) {
                    g.adj.get(i.next()).add(V);
                }
            }
            return g;
        }
    }
}
