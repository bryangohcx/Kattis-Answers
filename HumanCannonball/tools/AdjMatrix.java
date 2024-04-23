package tools;

public class AdjMatrix {
    public double [][] adjMatrix;
    double [][] vertices;
    int count;
    public AdjMatrix(int n){
        adjMatrix = new double[n][n];
        vertices = new double[n][2];
        count =0;
    }
    public void addVertices(double [] Vertex){
        vertices[count] = Vertex;
        adjMatrix[count][0] = getDistance(0, count)/5;
        for(int i=1;i<count;i++){
            adjMatrix[count][i] = getTime(count,i);
        }
        count++;
    }
    public double getDistance(int i,int j){
        double[] a = vertices[i];
        double[] b = vertices[j];
        return Math.sqrt(Math.pow(a[0]-b[0],2)+Math.pow(a[1]-b[1],2));
    }
    public double getTime(int i,int j){
        double dist = getDistance(i,j);
        return dist<30?dist/5:Math.abs(dist-50)/5+2;
    }
    public static void main(String[] args) {
        System.out.println("testing");
        int numVertices = 4;
        AdjMatrix graph = new AdjMatrix(numVertices);

        // Add vertices (coordinates) to the graph
        double[] vertex0 = {0.0, 100.0};
        double[] vertex1 = {10.0, 5.0};
        double[] vertex2 = {3.0, 8.0};
        double[] vertex3 = {7.0, 0};

        graph.addVertices(vertex0);
        graph.addVertices(vertex1);
        graph.addVertices(vertex2);
        graph.addVertices(vertex3);

        // Print the adjacency matrix
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(graph.adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

