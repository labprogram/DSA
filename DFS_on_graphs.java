// Write a Java program to implement depth-first search (DFS) on Graphs.
// Save the file as DFSGraph.java

import java.util.Scanner;

class DFSGraph {
    private int V;
    private int[][] adjMatrix;

    public DFSGraph(int v) {
        V = v;
        adjMatrix = new int[V][V];
    }

    public void addEdge(int v, int w) {
        adjMatrix[v][w] = 1;
        adjMatrix[w][v] = 1;
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < V; i++) {
            if (adjMatrix[v][i] == 1 && !visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = scanner.nextInt();
        DFSGraph graph = new DFSGraph(V);
        System.out.print("Enter number of edges: ");
        int E = scanner.nextInt();
        System.out.println("Enter the edges (format: start end): ");
        for (int i = 0; i < E; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            graph.addEdge(start, end);
        }
        System.out.print("Enter starting vertex for DFS: ");
        int startDFS = scanner.nextInt();
        System.out.println("Depth First Traversal (starting from vertex " + startDFS + "): ");
        graph.DFS(startDFS);
        scanner.close();
    }
}
