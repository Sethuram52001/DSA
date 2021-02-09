import java.util.LinkedList;

public class WeightedGraph {
    // weighted edge structure  - consists of source, destination and weight
    static class WeightedEdge {
        int source;
        int destination;
        int weight;

        // constructor
        public WeightedEdge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices; // number of vertices
        LinkedList<WeightedEdge>[] adj; // linkedlist rep of adjacency list

        // constructor
        Graph(int vertices) {
            this.vertices = vertices;
            adj = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        // adding edge, with weight
        public void addEdge(int source, int destination, int weight) {
            WeightedEdge edge = new WeightedEdge(source, destination, weight);
            adj[source].addFirst(edge);
        }

        // printing the graph
        public void printGraph() {
            for (int i = 0; i < vertices; i++) {
                LinkedList<WeightedEdge> list = adj[i];
                for (int j = 0; j < list.size(); j++) {
                    System.out.println("vertex-"+i+" is connected to "+list.get(j).destination+" with weight "+list.get(j).weight);
                }
            }
        }
    }
    public static void main(String[] args) {
        int vertices = 6;
        Graph g = new Graph(vertices);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 2);
        g.addEdge(1, 2, 5);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 0, 4);
        g.addEdge(4, 1, 4);
        g.addEdge(4, 5, 6);
        g.printGraph();
    }
}
