package lostmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lostmap{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MST t = new MST(); 
        int V = Integer.parseInt(br.readLine()); // number of Villages
        int[][] adjMatrix = new int[V][V];
        for(int i = 0; i < V; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < V; j++){
                adjMatrix[i][j] = Integer.parseInt(input[j]);
            }
        }
        t.primMST(adjMatrix); 

    }
}