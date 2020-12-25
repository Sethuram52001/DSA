import java.io.*;
import java.util.*;

class Graph {
	private int V;
	public ArrayList<ArrayList<Integer>> adj;

	Graph(int V) {
		this.V = V;
		adj = new ArrayList<ArrayList<Integer>>(V);
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	void addEdge(int v, int w) {
		adj.get(v).add(w);
	}
}

class TopologicalSort {
	static ArrayList<ArrayList<Integer>> adj;

	static void topologicalSort(int V) {
		Stack<Integer> st = new Stack<>();
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < V; i++) {
			if (visited[i] == false)
				topologicalSortHelper(i, visited, st);
		}

		while (st.empty() == false) {
			System.out.println(st.pop() + " ");
		}
	}
	
	static void topologicalSortHelper(int v, boolean visited[], Stack<Integer> st) {
		visited[v] = true;
		int i;
		Iterator<Integer> it = adj.get(v).iterator();
		while (it.hasNext()) {
			i = it.next();
			if(!visited[i])
			topologicalSortHelper(i, visited, st);
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		System.out.println("Following is a Topological " + "sort of the given graph");
		// funciton call
		int V = 6;
		adj = g.adj;
		topologicalSort(6);
	}
}