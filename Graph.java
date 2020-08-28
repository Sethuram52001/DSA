/*
Graph API:

Graph(int V) // create an empty graph with V vertices

Graph(In in) // create a graph from the input stream

void addEdge(int v, int w) // add an edge v-w

Iterable<Integer> adj(int v) // vertices adajecnt to v

int V() // no of vertices

int E() // no of edges

String toString() // string representation
*/

import java.util.*;

public class Graph {
    private final int V;
    public LinkedList<Integer> adj[];

    public Graph(int V){
        this.V = V;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    public void printGraph(LinkedList<Integer>[] adj){
        for (int i=0;i<5;i++) {
            System.out.print(i);
            for (Integer node : adj[i]) {
                System.out.print(" -> "+node);
            }
            System.out.println();
        }
    }

    public void main(){
 

    }
}

class client{
    public static void main(String[] args) {
        Graph g = new Graph(5);
        //int vertices = 5;
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        LinkedList<Integer>[] adj = g.adj;
        g.printGraph(adj);
    }
}