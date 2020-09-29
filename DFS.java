import java.util.*;
import java.util.LinkedList;

public class DFS{

    static class Graph{
        int V;
        LinkedList<Integer>[] adj;

        Graph(int V) {
            this.V = V;
            adj = new LinkedList[V];

            for(int i=0;i<V;i++){
                adj[i] = new LinkedList<Integer>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }
    }

    static void dfs(int s, int V, LinkedList<Integer>[] adj) {
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++){
            visited[i] = false;
        }

        Stack<Integer> st = new Stack<>();
        st.push(s);

        while(!st.isEmpty()){
            s = st.peek();
            st.pop();

            if(visited[s] == false){
                System.out.println(s+ " ");
                visited[s] = true;
            }

            Iterator<Integer> itr = adj[s].iterator();
            while(itr.hasNext()){
                int v = itr.next();
                if(!visited[v]){
                    st.push(v);
                }
            }
        }
    }

    public static void main(String[] args){
        Graph g = new Graph(9);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        g.addEdge(1, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 8); 
        int V = g.V;
        LinkedList<Integer>[] adj = g.adj;
        dfs(1, V, adj);
    }
}