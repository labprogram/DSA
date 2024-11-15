// Write a Java program to implement Breadth-first search (BFS) on Graphs.
// Save the file as BFSGraph.java

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BFSGraph {
    private int V;
    private int[][] adjMatrix;

    public BFSGraph(int v) {
        V = v;
        adjMatrix = new int[V][V];
    }

    public void addEdge(int v, int w) {
        adjMatrix[v][w] = 1;
        adjMatrix[w][v] = 1;
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int i = 0; i < V; i++) {
                if (adjMatrix[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = scanner.nextInt();
        BFSGraph graph = new BFSGraph(V);
        System.out.print("Enter number of edges: ");
        int E = scanner.nextInt();
        System.out.println("Enter the edges (format: start end): ");
        for (int i = 0; i < E; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            graph.addEdge(start, end);
        }
        System.out.print("Enter starting vertex for BFS: ");
        int startBFS = scanner.nextInt();
        System.out.println("Breadth First Traversal (starting from vertex " + startBFS + "): ");
        graph.BFS(startBFS);
        scanner.close();
    }
}
