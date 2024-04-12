package dominos;

import java.util.Scanner;

public class dominos {
    public static void main(String[] args) {
        //open a scanner
        Scanner scanner = new Scanner(System.in);
        
        //read first int
        int T = scanner.nextInt();
        for (int X = 0; X < T; X++) {
            //save int n
            int n = scanner.nextInt();
        
            //create a ufds with n elements
            UFDS ufds = new UFDS(n+1);
        
            // save int m
            int m = scanner.nextInt();
        
            // for m times read the input first integer is the number u want to transfer items to in the ufds
            // second input is the elements you want to transfer to that set
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
            
                // if they are already in the same set skip the transfer
                if (ufds.find(u) == ufds.find(v)) {
                continue;
            }
            
            // otherwise do the transfer and n--
            ufds.union(u, v);
            n--;
        }
        
        // print n
        System.out.println(n);
        }

        
        // close the scanner
        scanner.close();
    }
}

class UFDS {
    private int[] parent;
    private int[] rank;
    
    public UFDS(int n) {
        parent = new int[n];
        rank = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}