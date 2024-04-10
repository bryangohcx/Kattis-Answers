//import java.util.Arrays;
import java.util.Scanner;

public class islands3{
    public static void main(String[]args){
        MapData mappy= new MapData();
        //before checker
        //System.out.println("Before boomy");
        /*for(int i=0;i<mappy.r;i++){
            char[] x = mappy.satData[i];
            System.out.println(Arrays.toString(x));
        }*/
        //Boomy
        for(int i=0;i<mappy.r;i++){
            for(int j=0;j<mappy.c;j++){
                if(mappy.satData[i][j]=='L'){
                    mappy.islands ++;
                    mappy.satData[i][j] = 'X';
                    mappy.Boomy(i,j);
                }
            }
        }
        //after checker
        //System.out.println("After boomy");
        /*for(int i=0;i<mappy.r;i++){
            char[] x = mappy.satData[i];
            System.out.println(Arrays.toString(x));
        }*/
        System.out.println(mappy.islands);
    }
    
    public static class MapData{
        //Cartographer
        Scanner sc = new Scanner(System.in);
        int islands = 0;
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] satData;
        public MapData(){
            sc.nextLine();
            satData = new char[r][c];
            for(int i=0;i<r;i++){
                String row = sc.nextLine();
                for(int j=0;j<c;j++){
                    satData[i][j]= row.charAt(j);
                }
            }
            sc.close();
        }
        //Boomy
        public void Boomy(int i, int j){
            char curr = satData[i][j];
            if (curr =='X'){
                //go all 4 directions and change all 'C' and 'L' to 'X' //recurse it
                if (i-1 >= 0) {//up
                    if (satData[i-1][j] == 'C' || satData[i-1][j] == 'L') {
                        satData[i-1][j] = 'X';
                        Boomy(i-1, j);
                    }
                } else {}
                if (i+1 < r) {//down
                    if (satData[i+1][j] == 'C' || satData[i+1][j] == 'L') {
                        satData[i+1][j] = 'X';
                        Boomy(i+1, j);
                    }
                } else {}
                if (j-1 >= 0) {//left
                    if (satData[i][j-1] == 'C' || satData[i][j-1] == 'L') {
                        satData[i][j-1] = 'X';
                        Boomy(i, j-1);
                    }
                } else {}
                if (j+1 < c) {//right
                    if (satData[i][j+1] == 'C' || satData[i][j+1] == 'L') {
                        satData[i][j+1] = 'X';
                        Boomy(i, j+1);
                    }
                } else {}
            }
        }
    }
}