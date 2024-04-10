//import java.util.Arrays;
import java.util.Scanner;


public class millionairemadness{
    public static void main(String[]args){
        MapData mappy= new MapData();
        /*
        System.out.println();
        for(int i=0;i<mappy.r;i++){
            System.out.println(Arrays.toString(mappy.satData[i]));
        }        
        */
        mappy.Cost(0, 0);
        /*
        System.out.println();
        for(int i=0;i<mappy.r;i++){
            System.out.println(Arrays.toString(mappy.cost[i]));
        }
         */
        

        System.out.println(mappy.cost[mappy.r-1][mappy.c-1]);

    }
    
    public static class MapData{
        //Vault
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] satData;
        int[][] cost = new int[r][c];
        public MapData(){
            sc.nextLine();
            satData = new int[r][c];
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    satData[i][j] =  sc.nextInt();
                    cost[i][j] = -1;
                }
            }
            cost[0][0] = 0;
            sc.close();
        }
        //Cost
        public void Cost(int i, int j){
            if(!(i==r && j==c)){
                int C = cost[i][j];
                int S = satData[i][j];
                if (i-1 >= 0) {//up
                    if (cost[i-1][j]==-1||cost[i-1][j]>C) {//change to use helper functions
                        cost[i-1][j] = Math.max(C,satData[i-1][j]-S);
                        Cost(i-1,j);
                    }
                } else {}
                if (i+1 < r) {//down
                    if (cost[i+1][j]==-1||cost[i+1][j]>C) {
                        cost[i+1][j] = Math.max(C,satData[i+1][j]-S);
                        Cost(i+1,j);
                    }
                } else {}
                if (j-1 >= 0) {//left
                    if (cost[i][j-1]==-1||cost[i][j-1]>C) {
                        cost[i][j-1] = Math.max(C,satData[i][j-1]-S);
                        Cost(i,j-1);
                    }
                } else {}
                if (j+1 < c) {//right
                    if (cost[i][j+1]==-1||cost[i][j+1]>C) {
                        cost[i][j+1] = Math.max(C,satData[i][j+1]-S);
                        Cost(i,j+1);
                    }
                } else {}
            }
            
        }
    }
}