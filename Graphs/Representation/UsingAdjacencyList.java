package Graphs.Representation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UsingAdjacencyList {
    
    // Edge class represents an edge in the graph.
    // It has a source node (src) and a destination node (dest).
    static class Edge {
        int src;
        int dest;

        // Constructor to initialize the edge with the source and destination nodes.
        Edge(int _src, int _dest) {
            src = _src;
            dest = _dest;
        }
    }

    // createGraph method: Initializes the graph using adjacency lists.
    public static void createGraph(ArrayList<Edge> graph[]) {
        // Initialize each ArrayList in the graph to hold the edges.
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Add edges to the graph. Each edge connects the source to the destination.
        graph[0].add(new Edge(0, 2)); // Node 0 is connected to node 2
        graph[1].add(new Edge(1, 2)); // Node 1 is connected to node 2
        graph[1].add(new Edge(1, 3)); // Node 1 is connected to node 3
        graph[2].add(new Edge(2, 0)); // Node 2 is connected to node 0
        graph[2].add(new Edge(2, 1)); // Node 2 is connected to node 1
        graph[2].add(new Edge(2, 3)); // Node 2 is connected to node 3
        graph[3].add(new Edge(3, 1)); // Node 3 is connected to node 1
        graph[3].add(new Edge(3, 2)); // Node 3 is connected to node 2
    }

    // print method: Prints the adjacency list representation of the graph.
    public static void print(ArrayList<Edge> graph[]) {
        // Iterate through each vertex (node) in the graph.
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + " : ");
            // For each vertex, print its outgoing edges (if any).
            for (Edge edge : graph[i]) {
                System.out.print("{ " + edge.src + " -> " + edge.dest + " }, ");
            }
            System.out.println(); // Move to the next line for the next vertex
        }
    }

    // bfs method: Performs Breadth-First Search (BFS) traversal starting from node 0.
    public static void bfs(ArrayList<Edge> graph[]) {
        Queue<Integer> q = new LinkedList<>(); // Queue to store nodes for BFS.
        boolean[] vis = new boolean[4]; // Array to keep track of visited nodes (size = number of nodes).
        
        // Start BFS from node 0.
        q.add(0); // Enqueue the starting node.
        
        // Continue until there are no more nodes to process in the queue.
        while (!q.isEmpty()) {
            int cur = q.remove(); // Dequeue the front element.
            
            // If the current node is not visited yet, process it.
            if (!vis[cur]) {
                System.out.print(cur + " "); // Print the current node.
                vis[cur] = true; // Mark the node as visited.
                
                // Add all neighbors (destination nodes) of the current node to the queue.
                for (int i = 0; i < graph[cur].size(); i++) {
                    Edge e = graph[cur].get(i);
                    q.add(e.dest); // Enqueue the destination of the current edge.
                }
            }
        }
    }

    // dfs method: Performs Depth-First Search (DFS) traversal using recursion.
    public static void dfs(ArrayList<Edge> graph[], boolean[] vis, int node) {
        // Mark the current node as visited.
        vis[node] = true;
        System.out.print(node + " "); // Print the current node
        
        // Visit all unvisited neighbors (destination nodes) of the current node.
        for (int i = 0; i < graph[node].size(); i++) {
            Edge e = graph[node].get(i);
            // If the destination node is not visited, recursively call dfs.
            if (!vis[e.dest]) {
                dfs(graph, vis, e.dest); // Recursively visit the neighbor node.
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("hello");

        // Create an adjacency list for a graph with 4 vertices.
        ArrayList<Edge>[] graph = new ArrayList[4];

        // Initialize the graph by adding edges.
        createGraph(graph);

        // Print the graph (adjacency list representation).
        print(graph);
        
        System.out.println("\nBFS traversal or search:");
        bfs(graph); // Perform BFS starting from node 0.

        System.out.println("\nDFS traversal or search:");
        boolean[] vis = new boolean[4]; // Initialize a visited array for DFS.
        dfs(graph, vis, 0); // Perform DFS starting from node 0.
    }
}
