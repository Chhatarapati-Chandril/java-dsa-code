import java.util.*;

// Topological Sort
// Only for Directed Acyclic Graphs (DAG)
// A linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
// Applications: task scheduling, resolving dependencies, etc.

public class TopologicalSort {

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

        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // ********************************* topological sort using DFS *********************************

    // Time Complexity: O(V + E)
    // Space Complexity: O(V) for the stack and visited array.

    public static void topSortDFS(ArrayList<Edge>[] graph) {

        boolean[] vis = new boolean[graph.length]; 
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, stack);  // modified dfs
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, stack);
            }
        }
        stack.push(curr);
    }


    // ********************************* topological sort using BFS - Kahn's Algo *********************************

    // Fact: DAG has at least one vertex with in-degree 0 and at least one vertex with out-degree 0.

    public static void calcInDegree(ArrayList<Edge> graph[], int[] indeg) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void topSortBFS(ArrayList<Edge> graph[]) {
        int[] indeg = new int[graph.length];
        calcInDegree(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e  = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    // ********************************* All paths from source to target *********************************

    // TC: exponential
    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path+" "+dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPaths(graph, e.dest, dest, path+" "+src);
        }
    }




    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.print("Topological Sort using DFS: "); 
        topSortDFS(graph);
        System.out.print("Topologica Sort using BFS: "); 
        topSortBFS(graph);

        int src = 5;
        int dest = 1;

        System.out.println("All paths from src -> dest: ");
        printAllPaths(graph, src, dest, "");
    }
    
}
