// Write a java program to find the shortest path using Dijkstra’s algorithm.
// Save the file as Dijkstras_Shortest_Path.java

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Dijkstras_Shortest_Path {
    private int[] distances;
    private Set<Integer> settled;
    private Set<Integer> unsettled;
    private int n;
    private int[][] adjacencyMatrix;

    public Dijkstras_Shortest_Path(int n) {
        this.n = n;
        distances = new int[n + 1];
        settled = new HashSet<>();
        unsettled = new HashSet<>();
        adjacencyMatrix = new int[n + 1][n + 1];
    }

    public void dijkstra_algorithm(int[][] adjacency_matrix, int source) {
        int evaluationNode;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                adjacencyMatrix[i][j] = adjacency_matrix[i][j];
            }
        }
        for (int i = 1; i <= n; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        unsettled.add(source);
        distances[source] = 0;

        while (!unsettled.isEmpty()) {
            evaluationNode = getNodeWithMinimumDistanceFromUnsettled();
            unsettled.remove(evaluationNode);
            settled.add(evaluationNode);
            evaluateNeighbours(evaluationNode);
        }
    }

    private int getNodeWithMinimumDistanceFromUnsettled() {
        int min;
        int node = 0;
        Iterator<Integer> iterator = unsettled.iterator();
        node = iterator.next();
        min = distances[node];

        for (int i = 1; i <= distances.length; i++) {
            if (unsettled.contains(i)) {
                if (distances[i] <= min) {
                    min = distances[i];
                    node = i;
                }
            }
        }
        return node;
    }

    private void evaluateNeighbours(int evaluationNode) {
        int edgeDistance;
        int newDistance;

        for (int destNode = 1; destNode <= n; destNode++) {
            if (!settled.contains(destNode)) {
                if (adjacencyMatrix[evaluationNode][destNode] != Integer.MAX_VALUE) {
                    edgeDistance = adjacencyMatrix[evaluationNode][destNode];
                    newDistance = distances[evaluationNode] + edgeDistance;
                    if (newDistance < distances[destNode]) {
                        distances[destNode] = newDistance;
                    }
                    unsettled.add(destNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] adj_mat;
        int nv;
        int source = 0, destination = 0;
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Enter the number of vertices");
            nv = scan.nextInt();
            adj_mat = new int[nv + 1][nv + 1];
            System.out.println("Enter the Weighted Matrix for the graph");

            for (int i = 1; i <= nv; i++) {
                for (int j = 1; j <= nv; j++) {
                    adj_mat[i][j] = scan.nextInt();
                    if (i == j) {
                        adj_mat[i][j] = 0;
                        continue;
                    }
                    if (adj_mat[i][j] == 0) {
                        adj_mat[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            System.out.println("Enter the source");
            source = scan.nextInt();
            System.out.println("Enter the destination");
            destination = scan.nextInt();

            Dijkstras_Shortest_Path dsp = new Dijkstras_Shortest_Path(nv);
            dsp.dijkstra_algorithm(adj_mat, source);
            System.out.println("The Shortest Path from " + source + " to " + destination + " is: ");
            for (int i = 1; i <= dsp.distances.length - 1; i++) {
                if (i == destination) {
                    System.out.println(source + " to " + i + " is " + dsp.distances[i]);
                }
            }
        } catch (InputMismatchException inputMismatch) {
            System.out.println("Wrong Input Format");
        }
        scan.close();
    }
}
