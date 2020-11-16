import java.io.*;
import java.util.*;

public class Digraph {
    private int v;
    private LinkedList<Integer> adj[];
    
    // constructor initialise the variables
    Digraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    // adding a directed edge to the graph
    // if it was an undirected graph it would have been
    // adj[v].add(w); adj[w].add(v);
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // checking if there is a path from the given source 
    //to the destination in the digraph
    boolean isPath(int s, int d) {
        LinkedList<Integer> temp;
        boolean visited[] = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        Iterator<Integer> i;
        // BFS
        while (queue.size() != 0) {
            s = queue.poll();
            int n;
            i = adj[s].listIterator();
            while (i.hasNext()) {
                n = i.next();
                if (n == d) {
                    return true;
                }
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }
}

class client {
    public static void main(String args[]) {
        Digraph g = new Digraph(7);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 1);
        g.addEdge(3, 2);
        g.addEdge(4, 3);
        g.addEdge(5, 2);
        g.addEdge(5, 4);

        int u = 1;
        int v = 3;
        if (g.isPath(u, v))
            System.out.println("There is a path from " + u + " to " + v);
        else
            System.out.println("There is no path from " + u + " to " + v);
        u = 3;
        v = 1;
        if(g.isPath(u, v))
            System.out.println("There is a path from " + u + " to " + v);
        else
            System.out.println("There is a path from " + u + " to " + v);
    }
}