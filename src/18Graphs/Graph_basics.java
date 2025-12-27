import java.util.*;

public class Graph_basics {

    static class Edge {
        int src;
        int dest;
        int wt;
        
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        // 0 - vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 - vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3 - vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4 - vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5 - vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6 - vertex
        graph[6].add(new Edge(6, 5, 1));

    }

    // ********************************* bfs *********************************

    // O(V+E)  ||  O(V^2) -matrix
    public static void bfs(ArrayList<Edge>[] graph) {

        // queue, array

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];

        q.add(0);   // source = 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {   // visit current node
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // ********************************* dfs *********************************

    // O(V+E)
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {

        // recursion stack
        // visit 

        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest , vis);
            }
        }
    }


    // O(V+E)
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if (src == dest) {
            return true; 
        }
        vis[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            // e.dest = neighbour
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        //          +-----+
        //          |  0  |
        //          +-----+
        //             |
        //             | 5
        //             |
        //          +-----+
        //          |  1  |
        //          +-----+
        //          /     \
        //       1 /       \ 3
        //        /         \
        //   +-----+       +-----+
        //   |  2  |---1---|  3  |
        //   +-----+       +-----+
        //       |
        //       | 2
        //       |
        //   +-----+
        //   |  4  |
        //   +-----+


        /*
                1 ---- 3
               /       | \
             0         |  5 -- 6
               \       | /
                2 ---- 4
        */


        int V = 7 ;

        // @SuppressWarnings("unchecked")
        
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }        

        createGraph(graph);
        // bfs(graph);
        // dfs(graph, 0, new boolean[V]);

        System.out.println(hasPath(graph, 0, 7, new boolean[V]));

    }
}