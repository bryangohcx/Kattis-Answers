package HumanCannonball;

import java.io.*;

public class Main {
    public static void main(String[]args)throws IOException{
        //takes in the buffered reader input of coordinates and creates an ADJMatrix
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //read the start and end
        String[] start = br.readLine().split(" ");
        String[] end = br.readLine().split(" ");
        double[] startVertex = {Double.parseDouble(start[0]),Double.parseDouble(start[1])};
        double[] endVertex = {Double.parseDouble(end[0]),Double.parseDouble(end[1])};

        int numVertices = Integer.parseInt(br.readLine());
        AdjMatrix graph = new AdjMatrix(numVertices+2);
        //store start and end in pos 1 and 2
        graph.addVertices(startVertex);
        graph.addVertices(endVertex);
        //store the rest of the vertices
        for (int i = 0; i < numVertices; i++) {
            String[] vertex = br.readLine().split(" ");
            double[] vertexCoords = {Double.parseDouble(vertex[0]),Double.parseDouble(vertex[1])};
            graph.addVertices(vertexCoords);
        }
        double shortestpath = Dijkstra.dijkstra(graph.adjMatrix,0,1);
        System.out.println(shortestpath);
    }
}

