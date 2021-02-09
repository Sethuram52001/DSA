import java.util.*;
import java.lang.*;
import java.io.*;

class Dijkstra {
    static final int V = 4; // V = 9

    // find the vertex with min distance
    // from the set of vertices not yet included in shortest path tree
    int minDistance(int dist[], boolean sptSet[]) {
        // initial the least value possible
        int min = Integer.MAX_VALUE, min_index = -1;

        for(int v=0;v<V;v++) {
            if(sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];
        boolean sptSet[] = new boolean[V];
        
        for(int i=0;i<V;i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for(int count = 0;count<V-1;count++) {
            int u =minDistance(dist, sptSet);

            sptSet[u] = true;

            for(int v = 0;v<V;v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v];          
            }
        }
        printSolution(dist, V);
    }

    void printSolution(int dist[], int n) {
        System.out.println("Vertex distance from source");
        for(int i=0;i<V;i++){
            System.out.println((i+1)+"\t\t"+dist[i]);
        }
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 3, 0, 5 }, 
                                        { 0, 0, 0, 0 },
                                        { 0, -10, 0, 0 },
                                        { 0, 0, 2, 0 } };
    
        Dijkstra d = new Dijkstra();
        d.dijkstra(graph, 0);
    }
}

/*
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
*/