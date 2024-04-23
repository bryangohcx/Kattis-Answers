import java.util.*;

public class DominoKnockDown {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List
    private LinkedList<Integer> transposeAdj[]; // Transpose of the graph

    // Constructor
    DominoKnockDown(int v) {
        V = v;
        adj = new LinkedList[v];
        transposeAdj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
            transposeAdj[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        transposeAdj[w].add(v); // Add edge to the transpose graph
    }

    // A function used by DFS
    private void DFSUtil(int v, boolean visited[], List<Integer> component) {
        visited[v] = true;
        component.add(v);
        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited, component);
        }
    }

    // Function that returns reverse postorder of the graph
    private void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        for (int n : adj[v]) {
            if (!visited[n])
                fillOrder(n, visited, stack);
        }
        stack.push(v);
    }

    // The main function that finds and prints all strongly connected components
    private List<List<Integer>> getSCCs() {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!visited[i])
                fillOrder(i, visited, stack);

        // Mark all the vertices as not visited (For second DFS)
        Arrays.fill(visited, false);
        List<List<Integer>> sccs = new ArrayList<>();

        // Now process all vertices in order defined by Stack
        while (!stack.empty()) {
            int v = stack.pop();
            if (!visited[v]) {
                List<Integer> component = new ArrayList<>();
                DFSUtil(v, visited, component);
                sccs.add(component);
            }
        }
        return sccs;
    }

    // The function to find and print all SCCs
    int findDominoesToKnock() {
        List<List<Integer>> sccs = getSCCs();
        int count = 0;

        // For every SCC, check if it has incoming edges from outside the SCC
        for (List<Integer> scc : sccs) {
            boolean hasIncomingEdges = scc.stream().anyMatch(
                v -> transposeAdj[v].stream().anyMatch(u -> !scc.contains(u))
            );
            if (!hasIncomingEdges) {
                count++; // This SCC needs a domino to be knocked down
            }
        }

        // Additionally, check for vertices with no incoming edges (sources)
        for (int i = 0; i < V; i++) {
            if (transposeAdj[i].isEmpty()) { // No incoming edges for vertex i
                count++;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of dominos (vertices):");
        int vertices = scanner.nextInt();

        System.out.println("Enter the number of connections (edges):");
        int edges = scanner.nextInt();

        DominoKnockDown g = new DominoKnockDown(vertices);

        System.out.println("Enter the connections (edges) in the format 'source target':");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt() - 1; // Subtract 1 for 0-based indexing
            int target = scanner.nextInt() - 1; // Subtract 1 for 0-based indexing
            g.addEdge(source, target);
        }

        int dominoesToKnock = g.findDominoesToKnock();
        System.out.println("Minimum number of dominos to knock down: " + dominoesToKnock);

        scanner.close();
    }
}
