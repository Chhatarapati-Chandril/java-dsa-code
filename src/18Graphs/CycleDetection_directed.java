import java.util.*;

public class CycleDetection_directed {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(1, 0));
        graph[0].add(new Edge(2, 3));
        graph[0].add(new Edge(3, 0));
    }

    // ********************************* detect cycle (undirected graph) with DFS *********************************
    
    public static boolean isCycle(ArrayList<Edge>[] graph) {

        boolean[] vis = new boolean[graph.length];
        boolean[] stack_arr = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack_arr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack_arr) {
        vis[curr] = true;
        stack_arr[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // visited -> cycle exist
            if (stack_arr[e.dest]) {
                return true;
            }
            if (!stack_arr[e.dest] && isCycleUtil(graph, e.dest, vis, stack_arr)) {
                return true;
            }
        }
        // in recursion, after call, node removes from stack
        stack_arr[curr] = false;
        return false;
    }



    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println("Cycle: " + isCycle(graph));

    }
    
}
