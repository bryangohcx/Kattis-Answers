import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.io.PrintWriter;

class ferryloading4{
    public static void main(String[]args)throws IOException{
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        while(c-->0){
            String str = br.readLine();
            int l = 100*Integer.parseInt(str.split(" ")[0]);
            int m = Integer.parseInt(str.split(" ")[1]);
            Queue<Integer> left = new LinkedList<Integer>();
            Queue<Integer> right = new LinkedList<Integer>();

            while(m-->0){
                String[] s = br.readLine().split(" ");
                int len = Integer.parseInt(s[0]);
                String side = s[1];
                if(side.equals("left")){
                    left.add(len);
                }else{
                    right.add(len);
                }
            }
            
            int tripsL =0;
            int tripsR = 0;
            while (!left.isEmpty()){
                int curr = 0;
                while(!left.isEmpty() && curr+left.peek()<=l){
                    curr+=left.poll();
                    //System.out.println("inner loop");
                }
                tripsL++;
                //System.out.println("nummber of l "+tripsL);
            }
            while (!right.isEmpty()){
                int curr = 0;
                while(!right.isEmpty() && curr+right.peek()<=l){
                    curr+=right.poll();
                }
                tripsR++;
                //System.out.println("nummber of r "+tripsR);
            }
            
            if (tripsL<tripsR){
                //System.out.println("r answerrrrrr");
                pw.println(tripsR*2);
            }   else{
                //System.out.println("l answerrrrrr");
                pw.println(tripsL*2-1);
            }
        }
        pw.flush();
    }
}