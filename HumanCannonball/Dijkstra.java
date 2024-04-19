package HumanCannonball;

import java.util.Arrays;
import java.util.PriorityQueue;

class Dijkstra {
    public static double dijkstra(double[][] adjacencyMatrix, int startNode, int endNode) {
        int V = adjacencyMatrix.length;
        double[] time = new double[V];
        Arrays.fill(time, Double.POSITIVE_INFINITY);
        time[startNode] = 0.0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Double.compare(time[a], time[b]));
        pq.add(startNode);

        while (!pq.isEmpty()) {
            int u = pq.poll();

            for (int v = 0; v < V; v++) {
                int c = Math.max(u, v);
                int d = Math.min(u, v);
                if (adjacencyMatrix[c][d] != 0.0) {
                    double newTime = time[u] + adjacencyMatrix[c][d];
                    if (newTime < time[v]) {
                        time[v] = newTime;
                        pq.add(v);
                    }
                }
            }
        }
        return time[endNode];
    }

    public static void main(String[] args) {
        System.out.println("testing");
        double[][] adjacencyMatrix = {
            {0.0, 0.0, 0.0, 0.0}, // Vertex 0
            {10.5, 0.0, 0.0, 0.0}, // Vertex 1
            {0.0, 5.2, 0.0, 0.0}, // Vertex 2
            {0.0, 3.0, 15.7, 0.0}  // Vertex 3
        };
        int startNode = 2; // Vertex 1
        int endNode = 3;   // Vertex 3

        double shortestTimes = dijkstra(adjacencyMatrix, startNode, endNode);
        System.out.println("Shortest travel time from vertex " + startNode + " to vertex " + endNode + ": " +
                shortestTimes + " minutes");
    }
}
